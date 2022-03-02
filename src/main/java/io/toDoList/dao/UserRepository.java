package io.toDoList.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.toDoList.model.UserModel;

public interface UserRepository  extends JpaRepository<UserModel,Integer>{
	
	@Query("FROM UserModel u WHERE u.userName = ?1")
    UserModel findByUsername(String username);

	@Query("DELETE FROM UserModel n WHERE n.userName = ?1")
	void deleteUserByUserName(String userName);

	@Query("FROM UserModel u WHERE u.id = ?1")
	UserModel findUserById(Integer userId);
	

}
