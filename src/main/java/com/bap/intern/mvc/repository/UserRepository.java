package com.bap.intern.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bap.intern.mvc.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
}
