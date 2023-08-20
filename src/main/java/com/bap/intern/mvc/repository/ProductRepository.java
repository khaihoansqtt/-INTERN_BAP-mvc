package com.bap.intern.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bap.intern.mvc.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
