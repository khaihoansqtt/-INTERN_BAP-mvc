package com.bap.intern.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bap.intern.mvc.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {
}
