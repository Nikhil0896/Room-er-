package com.springboot.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.spring.Model.User;


@SpringBootApplication
public class SpringSecurityDatabaseAuthentication implements CommandLineRunner {

	
    @Autowired
   
    private BCryptPasswordEncoder bCryptPasswordEncoder;

   
    
    
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDatabaseAuthentication.class, args);
    }

    @Override
    public void run(String...args) throws Exception {
        userRepository.save(new User("Nikhil", bCryptPasswordEncoder.encode("Nikhil")));
    }
}