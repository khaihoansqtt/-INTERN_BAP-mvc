package com.bap.intern.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bap.intern.mvc.service.OrderService;
import com.bap.intern.mvc.service.UserService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;
	
	@PostMapping("/order")
	public String orderCart(@RequestParam("userId") int userId, Model model) {
		orderService.orderCart(userId);
		
		model.addAttribute("message", "order successfully");
		return "redirect:/users/" + userId + "/orders";
	}

}
