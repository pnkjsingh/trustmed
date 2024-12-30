package com.trustmed.userService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trustmed.userService.entity.User;
import com.trustmed.userService.exception.NotFoundException;
import com.trustmed.userService.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> userList=userService.getAllUser();
		return ResponseEntity.ok(userList);
	}

	@GetMapping("/get/{userName}")
	public ResponseEntity<Optional<User>> getById(@PathVariable String userName){
		Optional<User> user=userService.getUserByUserName(userName);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("delete/{userName}")
	public ResponseEntity<String> deleteByUserName(@PathVariable String userName){
		Optional<User> user=userService.getUserByUserName(userName);
		
		if(user.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Name : " + userName + " not found.");
		}
		userService.deleteUser(userName);
		return ResponseEntity.ok("User: \""+userName+"\" deleted successfully.");
	}
	
	@PutMapping("update/{userName}")
	public ResponseEntity<User> updateUser(@PathVariable String userName,@RequestBody User userDetails){
		Optional<User> user= userService.updateUser(userName, userDetails);
				
		return user.map(ResponseEntity::ok).orElseThrow(()-> new NotFoundException("User not found with userName: "+userName));
		
	}
}