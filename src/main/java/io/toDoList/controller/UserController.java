package io.toDoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.toDoList.model.UserModel;
import io.toDoList.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@PostMapping("/user")
	public ResponseEntity<Object> createNewUser(@RequestBody UserModel user){
		try {
			UserModel userModel= userService.createNewUser(user);
			return ResponseEntity
            .status(HttpStatus.OK)
            .body(userModel);
		}catch(Exception e) {
			return ResponseEntity
            .status(HttpStatus.OK)
            .body(e.getMessage());
		}
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> getAllUser(){
		try {
			List<UserModel> users= userService.getAllUsers();
			return ResponseEntity
            .status(HttpStatus.OK)
            .body(users);
		}catch(Exception e) {
			return ResponseEntity
            .status(HttpStatus.OK)
            .body(e.getMessage());
		}
	}
	
	@DeleteMapping("/user")
	public ResponseEntity<Object> deleteUser(@RequestBody UserModel user){
		try {
			boolean result = userService.deleteUserByUserName(user);
			return ResponseEntity
            .status(HttpStatus.OK)
            .body(result);
		}catch(Exception e) {
			return ResponseEntity
            .status(HttpStatus.OK)
            .body(e.getMessage());
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<Object> findUserByUsername(@RequestBody UserModel user){
		try {
			UserModel result = userService.findUser(user);
			return ResponseEntity
            .status(HttpStatus.OK)
            .body(result);
		}catch(Exception e) {
			return ResponseEntity
            .status(HttpStatus.OK)
            .body(e.getMessage());
		}
	}
	
	
	
	
	
}
