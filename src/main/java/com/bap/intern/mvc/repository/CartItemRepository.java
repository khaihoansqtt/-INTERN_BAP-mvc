package com.bap.intern.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bap.intern.mvc.entity.CartItem;
import com.bap.intern.mvc.entity.User;


public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	List<CartItem> findByUser(User user);
}
