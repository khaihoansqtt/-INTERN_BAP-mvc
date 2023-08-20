package com.bap.intern.mvc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bap.intern.mvc.dto.showOrder.OrderResDto;
import com.bap.intern.mvc.dto.showUser.UserResDto;
import com.bap.intern.mvc.entity.Order;
import com.bap.intern.mvc.entity.Product;
import com.bap.intern.mvc.entity.User;
import com.bap.intern.mvc.repository.ProductRepository;
import com.bap.intern.mvc.repository.UserRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
