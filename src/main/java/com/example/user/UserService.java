package com.example.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
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
		byte[] salt = new byte[] {1,2,3};
		MessageDigest md = MessageDigest.getInstance("SHA-512");
//		md.update(salt);
		var hash = md.digest(password.getBytes());
		System.err.println("->> "+hash);
		return userRepository.findByEmailAndHash(email, hash.toString()).orElseThrow(() -> new RuntimeException("User not found"));
	}

}
