package com.bap.intern.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bap.intern.mvc.dto.showOrder.OrderResDto;
import com.bap.intern.mvc.dto.showUser.UserResDto;
import com.bap.intern.mvc.entity.User;
import com.bap.intern.mvc.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public String home(Model model) {
		List<UserResDto> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
	
	@GetMapping("/users/{userId}/orders")
	public String getOrders(@PathVariable("userId") int userId, Model model) {
		User user = userService.getUserById(userId);
		
		model.addAttribute("user", user);
		model.addAttribute("orders", user.getOrders());
		return "orders";
	}
	
	
}
