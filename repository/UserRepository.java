package com.springboot.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.spring.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
