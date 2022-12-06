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
	public ResponseEntity<?> setUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
	}

	@GetMapping("/user/{userUuid}")
	public User getUser(@PathVariable("userUuid") UUID userUuid) {
		return userService.getUserById(userUuid);
	}
	
	@PostMapping("/user/login")
	public User login(@RequestParam("email") String email,@RequestParam("password") String password) throws NoSuchAlgorithmException {
		return userService.login(email,password);
	}


	@DeleteMapping("/user/{userUuid}")
	public void getUserById(@PathVariable("userUuid") UUID userUuid) {
		userService.deleteUserById(userUuid);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> ssdsUser() {
		var user = new User();
		user.setFirstName("Shadin");
		user.setLastName("Shadinovka");
		user.setMiddleName("Shadinovich");
		user.setSex("male");
		user.setPhone("88005553535");
		user.setEmail("shadin@good.boy");
		user.setRole("God");
		user.setDateOfbirth(new Timestamp(new Date().getTime()));
		user.setDatedOfEmployment(new Timestamp(new Date().getTime()));
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
	}
	

}
