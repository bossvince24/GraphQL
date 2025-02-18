//package com.practice.demo.service;
//
//import java.util.List;
//import java.util.Optional;
//
//
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import com.practice.demo.entity.User;
//import com.practice.demo.repository.UserRepository;
//
//import jakarta.transaction.Transactional;
//
//@Service
//public class UserService {
//	
//	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);
//	private final UserRepository repository;
//
//	public UserService(UserRepository repository) {
//		super();
//		this.repository = repository;
//	}
//	
//	public List<User> getAllUsers() {
//		return repository.findAll();
//	}
//	
//	public Optional<User> getUserById(Long id) {
//		return repository.findById(id);
//	}
//	
////	public User addUser(String name, String email) {
////		User users = new User();
////		users.setName(name);
////		users.setEmail(email);
////		return repository.save(users);
////	}
//	
//	 @Transactional
//	    public User addUser(String name, String email) {
//	        logger.info("Received addUser request - Name: {}, Email: {}", name, email);
//	        
//	        if (name == null || email == null) {
//	            logger.error("Invalid input: Name or Email is null");
//	            throw new IllegalArgumentException("Name and Email cannot be null");
//	        }
//
//	        User user = new User();
//	        user.setName(name);
//	        user.setEmail(email);
//
//	        User savedUser = repository.save(user);
//	        logger.info("User saved successfully: {}", savedUser);
//
//	        return savedUser;
//	    }
//
//}
