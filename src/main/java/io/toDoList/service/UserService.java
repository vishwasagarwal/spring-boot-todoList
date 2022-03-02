package io.toDoList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.toDoList.dao.UserRepository;
import io.toDoList.model.UserModel;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserModel> getAllUsers() throws Exception{
		try {
			List<UserModel> users = new ArrayList<UserModel>();
			userRepository.findAll().forEach(users::add);
			return users;
		}catch(Exception e) {
			throw new Exception("Some error occured");
		}
	}

	public UserModel createNewUser(UserModel user) throws Exception {
		try {
			return userRepository.save(user);
		}catch(Exception e) {
			throw new Exception("cannot create new user");
		}
		
	}

	public UserModel findUser(UserModel user) throws Exception {
		try {
			System.out.println(user.getUserName());
			UserModel result = userRepository.findByUsername(user.getUserName());
			if(result == null) {
				throw new Exception("user not exist");
			}
			return result;
		}catch(Exception e) {
			throw new Exception("user not exist");
		}	
	}
	
	public boolean deleteUserByUserName(UserModel user) throws Exception {
		try {
			userRepository.deleteUserByUserName(user.getUserName());
			return true;
		}catch (Exception e) {
			throw new Exception("some error occurred");
		}
	}

	public UserModel updateUserTodo(UserModel user) throws Exception {
		try {
			UserModel update = userRepository.save(user);
			if(update == null) {
				throw new Exception("unable to update");
			}
			return update;
		}catch (Exception e) {
			throw new Exception(e);
		}
	}

	public  UserModel findUserById(Integer userId) throws Exception {
		try {
			UserModel update = userRepository.findUserById(userId);
			if(update == null) {
				throw new Exception("unable to update");
			}
			return update;
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
	
}
