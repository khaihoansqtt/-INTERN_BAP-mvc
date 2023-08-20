package com.bap.intern.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bap.intern.mvc.dto.cartFeature.AddCartItemResDto;
import com.bap.intern.mvc.entity.Product;
import com.bap.intern.mvc.entity.User;
import com.bap.intern.mvc.service.CartService;
import com.bap.intern.mvc.service.ProductService;
import com.bap.intern.mvc.service.UserService;

@Controller
public class CartController {
	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	
	@GetMapping("/users/{userId}/cart")
	public String showCart(@PathVariable("userId") int userId, Model model) {
		User user = userService.getUserById(userId);
		List<Product> products = productService.getAllProducts();

		model.addAttribute("user", user);
		model.addAttribute("cartItems", user.getCartItems());
		model.addAttribute("products", products);
		return "cart";
	}
	
	@PostMapping("/cart/add")
	public String addProductToCart(@ModelAttribute AddCartItemResDto req, Model model) {
		System.out.println(req);
		int userId = req.getUserId();
		int productId = req.getProductId();
		int quantity = req.getQuantity();
		cartService.addProductToCart(userId, productId, quantity);
		
		model.addAttribute("message", "Đã thêm vào giỏ hàng");
		return "redirect:/users/" + userId + "/cart";
	}

	@PostMapping("/cart/delete")
	public String removeProductFromCart(@RequestParam("cartItemId") int cartItemId, 
											@RequestParam("userId") int userId, Model model) {
		cartService.removeProductFromCart(cartItemId);
		model.addAttribute("message", "Đã xóa giỏ hàng");
		return "redirect:/users/" + userId + "/cart";
	}
}
