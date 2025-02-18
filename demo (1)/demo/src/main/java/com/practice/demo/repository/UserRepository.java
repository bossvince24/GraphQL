package com.practice.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByNameContainingIgnoreCase(String name);


}
