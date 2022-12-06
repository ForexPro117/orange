package com.example.orange;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.User;
import com.example.user.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<?> setUser(@RequestBody User user) throws NoSuchAlgorithmException {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
	}

	@GetMapping("/user/{userUuid}")
	public User getUser(@PathVariable("userUuid") UUID userUuid) {
		return userService.getUserById(userUuid);
	}

	@PostMapping("/user/login")
	public ResponseEntity<?> login(@RequestParam("email") String email, @RequestParam("password") String password)
			throws NoSuchAlgorithmException {
		return new ResponseEntity<>(userService.login(email, password), HttpStatus.OK);
	}

	@DeleteMapping("/user/{userUuid}")
	public void getUserById(@PathVariable("userUuid") UUID userUuid) {
		userService.deleteUserById(userUuid);
	}

	@GetMapping("/user")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/test")
	public ResponseEntity<?> testUser() throws NoSuchAlgorithmException {
		return new ResponseEntity<>(userService.saveUserTest(), HttpStatus.OK);
	}

}
