//package com.practice.demo.controller;
//
//import java.util.List;
//
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//
//import com.practice.demo.entity.User;
//import com.practice.demo.service.UserService;
//
//@Controller
//public class UserController {
//	
//	private final UserService service;
//
//	public UserController(UserService service) {
//		super();
//		this.service = service;
//	}
//	
//	@QueryMapping
//	public List<User> users() {
//		return service.getAllUsers();
//	}
//	
//	@QueryMapping
//	public User user(@Argument Long id) {
//		return service.getUserById(id).orElse(null);
//	}
//	
//	@MutationMapping
//	public User addUser(@Argument String name, @Argument String email) {
//	    return service.addUser(name, email);
//	}
//
//}
