package io.toDoList.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.toDoList.dao.TodoRepository;
import io.toDoList.model.ToDoModel;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;

	public ToDoModel saveTask(ToDoModel newTask) throws Exception {
		try {
			return todoRepository.save(newTask);
		}catch(Exception e) {
			throw new Exception("cannot create new Task");
		}
	}

	public ToDoModel findById(Integer taskId) throws Exception {
		try {
			return todoRepository.findTaskById(taskId);
		}catch(Exception e) {
			throw new Exception("cannot create new Task");
		}
	}

	public ToDoModel deleteTask(Integer taskId) throws Exception {
		try {
			  todoRepository.deleteById(taskId); 
			  return null;
		}catch(Exception e) {
			throw new Exception("cannot create new Task");
		}
	}
	
}
