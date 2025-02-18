package com.practice.demo.graphqlresolvers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.practice.demo.entity.User;
import com.practice.demo.entity.Profile;
import com.practice.demo.entity.User;
import com.practice.demo.repository.ProfileRepository;
import com.practice.demo.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//import graphql.kickstart.tools.GraphQLMutationResolver;
//import graphql.kickstart.tools.GraphQLQueryResolver;

//@Component
@Controller
//public class UserResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

public class UserResolver {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserResolver.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@QueryMapping
	public List<User> getUsers() {
		return userRepository.findAll();
//		return repository.findAll().stream().map(this:: attachProfile).collect(Collectors.toList());
	}

	@QueryMapping
	public User getUserById(@Argument Long id) {
		LOGGER.info("Fetching user with ID: {}", id);
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
//		return repository.findById(id).map(this::attachProfile).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
	}

	@MutationMapping
	public User addUser(@Argument String name, @Argument String email,
						@Argument String bio, @Argument String profilePictureUrl
						)
			{

		Profile profile = new Profile();
		profile.setBio(bio);
		profile.setProfilePictureUrl(profilePictureUrl);

		profile = profileRepository.save(profile);

		User users = new User();
		users.setName(name);
		users.setEmail(email);
		users.setProfile(profile);
		LOGGER.info("User saved successfully: {}", users);
		return userRepository.save(users);
	}

	@QueryMapping
	public List<User> getUsersByName(@Argument String name) {
		return userRepository.findByNameContainingIgnoreCase(name);
	}

//	@QueryMapping
	private User attachProfile(User user) {
		List<Profile> profiles = profileRepository.findByUserId(user.getId());
		if (!profiles.isEmpty()) {
			user.setProfile(profiles.get(0));
		}
		return user;
	}

	@QueryMapping
	public List<User> getUsersProfile() {
		return userRepository.findAll().stream().map(this::attachProfile).collect(Collectors.toList());
	}

	@QueryMapping
	public User getUserProfileById(@Argument Long id) {
		return userRepository.findById(id).map(this::attachProfile)
				.orElseThrow(() -> new RuntimeException("User not found with ID " + id));
	}
	
	@QueryMapping
	public List<User> getUsersByProfileBio(@Argument String bio) {
		return profileRepository.findByBioContainingIgnoreCase(bio).stream().map(this:: attachProfile)
				.collect(Collectors.toList());
		
	}
}