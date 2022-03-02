package io.toDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.toDoList.model.ToDoModel;
import io.toDoList.model.UserModel;
import io.toDoList.service.TodoService;
import io.toDoList.service.UserService;

@RestController
public class TodoController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TodoService todoService;
	
	@PostMapping("/user/newtask")
	public ResponseEntity<Object> createNewTask(@RequestParam String userName,@RequestBody ToDoModel task){
		try {
			UserModel temp =  new UserModel();
			temp.setUserName(userName);
			UserModel user = userService.findUser(temp);
			ToDoModel newTask = new ToDoModel();
			newTask.setTitle(task.getTitle());
			newTask.setDescription(task.getDescription());
			ToDoModel response = todoService.saveTask(newTask);
			user.getTodo().add(response);
		    UserModel updateUser = userService.updateUserTodo(user);
		    return ResponseEntity.status(HttpStatus.OK).body(updateUser);
		}catch(Exception e) {
			return ResponseEntity
		           .status(HttpStatus.OK)
		           .body(e.getMessage());
		}
	}
	
	@PatchMapping("complete/{userId}/{taskId}")
	public ResponseEntity<Object> tastComplete(@PathVariable("userId") Integer userId,@PathVariable("taskId") Integer taskId){
		try {
			ToDoModel response = todoService.findById(taskId); 
			response.setCompleted(true);
			todoService.saveTask(response);
			UserModel usermodel = userService.findUserById(userId);
		    return ResponseEntity.status(HttpStatus.OK).body(usermodel);
		}catch(Exception e) {
			return ResponseEntity
		           .status(HttpStatus.OK)
		           .body(e.getMessage());
		}
	}
	
	@DeleteMapping("delete/{userId}/{taskId}")
	public ResponseEntity<Object> deleteTask(@PathVariable("userId") Integer userId,@PathVariable("taskId") Integer taskId){
		try {
			todoService.deleteTask(taskId); 
			UserModel usermodel = userService.findUserById(userId);
		    return ResponseEntity.status(HttpStatus.OK).body(usermodel);
		}catch(Exception e) {
			return ResponseEntity
		           .status(HttpStatus.OK)
		           .body(e.getMessage());
		}
	}
}
