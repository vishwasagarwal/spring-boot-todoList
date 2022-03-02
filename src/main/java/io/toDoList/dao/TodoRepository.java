package io.toDoList.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.toDoList.model.ToDoModel;


public interface TodoRepository extends JpaRepository<ToDoModel,Integer>{

	@Query("FROM ToDoModel u WHERE u.id = ?1")
	ToDoModel findTaskById(Integer taskId);
    
}
