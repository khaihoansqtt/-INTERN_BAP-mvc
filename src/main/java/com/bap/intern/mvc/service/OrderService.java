package com.bap.intern.mvc.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.intern.mvc.entity.CartItem;
import com.bap.intern.mvc.entity.Order;
import com.bap.intern.mvc.entity.OrderItem;
import com.bap.intern.mvc.entity.Product;
import com.bap.intern.mvc.entity.User;
import com.bap.intern.mvc.repository.CartItemRepository;
import com.bap.intern.mvc.repository.OrderRepository;
import com.bap.intern.mvc.repository.UserRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartItemRepository cartItemRepository;
	
	public void orderCart(int userId) {
		User user = userRepository.findById(userId).get();
		List<CartItem> cartItems = cartItemRepository.findByUser(user);
		
		double totalAmount = cartItems.stream()
								.mapToDouble(cartItem -> cartItem.getQuantity() * cartItem.getProduct().getPrice())
								.sum();
		
		Order newOrder = Order.builder().totalAmount(totalAmount).orderDate(new Date()).user(user).build();
		List<OrderItem> orderItems = cartItems.stream().map(cartItem -> mapCartItemToOrderItem(cartItem, newOrder))
												.collect(Collectors.toList());
		newOrder.setOrderItems(orderItems);
		orderRepository.save(newOrder);
		
		// Delete cartItems from cart
		cartItemRepository.deleteAll(cartItems);
	}
	
	public OrderItem mapCartItemToOrderItem(CartItem cartItem, Order order) {
		Product product = cartItem.getProduct();
		
		OrderItem newOrderItem = OrderItem.builder()
											.product(product)
											.price(product.getPrice())
											.quantity(cartItem.getQuantity())
											.order(order)
											.build();
		return newOrderItem;
	}
}
