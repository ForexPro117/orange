package com.example.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) throws NoSuchAlgorithmException {
		if(userRepository.existsByEmail(user.getEmail()))
			throw new RuntimeException("User with this email exist");
		
		user.setHash(getHash(user.getPassword()));
		return userRepository.save(user);
	}

	public User getUserById(UUID userUuid) {
		return userRepository.findById(userUuid).orElse(null);
	}

	public void deleteUserById(UUID userUuid) {
		userRepository.deleteById(userUuid);
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User login(String email, String password) throws NoSuchAlgorithmException {
		var hash = getHash(password);
		return userRepository.findByEmailAndHash(email, hash).orElseThrow(() -> new RuntimeException("User not found"));
	}

	private byte[] getHash(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update("shadin".getBytes());
		return md.digest(text.getBytes());
	}

	public Object saveUserTest() throws NoSuchAlgorithmException {
		var user = new User();
		user.setFirstName("Shadin");
		user.setPassword("123");
		user.setLastName("Shadinovka");
		user.setMiddleName("Shadinovich");
		user.setSex("male");
		user.setPhone("88005553535");
		user.setEmail("shadin@good.boy");
		user.setRole("God");
		user.setDateOfbirth(new Timestamp(new Date().getTime()));
		user.setDatedOfEmployment(new Timestamp(new Date().getTime()));
		user.setHash(getHash(user.getPassword()));
		return userRepository.save(user);
	}

}
