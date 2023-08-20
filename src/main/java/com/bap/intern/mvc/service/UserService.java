package com.bap.intern.mvc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.intern.mvc.dto.showOrder.OrderResDto;
import com.bap.intern.mvc.dto.showUser.UserResDto;
import com.bap.intern.mvc.entity.Order;
import com.bap.intern.mvc.entity.User;
import com.bap.intern.mvc.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<UserResDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<UserResDto> showUserRes = users.stream().map(user -> new UserResDto(user)).collect(Collectors.toList());
		return showUserRes;
	}
	
	public User getUserById(int userId) {
		return userRepository.findById(userId).get();
	}
}
