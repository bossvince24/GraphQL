//package com.practice.demo.graphqlresolvers;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Controller;
//
//import com.practice.demo.entity.Profile;
//import com.practice.demo.repository.ProfileRepository;
//
//@Controller
//public class ProfileResolver {
//	
//	@Autowired
//	private ProfileRepository repository;
//	
//	@QueryMapping
//	public Profile getProfileById(@Argument Long id) {
//		Optional<Profile> profiles = repository.getProfile(id);
//		return profiles.get();
//	}
//	
//	public List<Profile> getProfiles() {
//		return repository.getProfiles();
//	}
//}
//
//   