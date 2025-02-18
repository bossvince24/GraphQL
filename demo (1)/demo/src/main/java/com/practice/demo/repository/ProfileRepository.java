package com.practice.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.demo.entity.Profile;
import com.practice.demo.entity.User;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

	List<Profile> findByUserId(Long id);

	List<User> findByBioContainingIgnoreCase(String bio);


}
