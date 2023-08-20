package com.bap.intern.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.intern.mvc.entity.CartItem;
import com.bap.intern.mvc.entity.Product;
import com.bap.intern.mvc.entity.User;
import com.bap.intern.mvc.repository.CartItemRepository;
import com.bap.intern.mvc.repository.ProductRepository;
import com.bap.intern.mvc.repository.UserRepository;

@Service
public class CartService {
	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	
//	public List<CartItem> getCartItems(int userId) {
//		User user = userRepository.findById(userId).get();
//		return user.getCartItems();
//	}
	
	public void addProductToCart(int userId, int productId, int quantity) {
		User user = userRepository.findById(userId).get();
		Product product = productRepository.findById(productId).get();
		
		CartItem newCartItem = new CartItem();
		newCartItem.setUser(user);
		newCartItem.setProduct(product);
		newCartItem.setQuantity(quantity);
		
		cartItemRepository.save(newCartItem);
	}
	
	public void removeProductFromCart(int cartItemId) {
		cartItemRepository.deleteById(cartItemId);
	}
}
