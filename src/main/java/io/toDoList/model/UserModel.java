package io.toDoList.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User",indexes = {@Index(name = "username_index",columnList = "userName",unique = true)})
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	@Column(name = "userName", nullable = false)
	private String userName;
	private String password;
	
	@OneToMany(targetEntity = ToDoModel.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="user_fk",referencedColumnName = "id")
	private List<ToDoModel> todo = new ArrayList<ToDoModel>();

	
	public UserModel() {
		
	}

	public UserModel(Integer id, String userName, String password, List<ToDoModel> todo) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.todo = todo;
	}

	@Override
	public String toString() {		
		return "id = "+ this.id+", username = "+this.userName+", password = "+this.password+", todo = "+this.todo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ToDoModel> getTodo() {
		return todo;
	}

	public void setTodo(List<ToDoModel> todo) {
		this.todo = todo;
	}	
	
	
}
