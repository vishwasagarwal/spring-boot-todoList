package io.toDoList.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Todo")
public class ToDoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String description;
	private boolean completed = Boolean.FALSE;
	
	
	public ToDoModel() {
		
	}

	public ToDoModel(Integer id, String title, String description, boolean completed) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	@Override
	public String toString() {		
		return "id = "+ this.id+", title = "+this.title+", description = "+this.description+", completed = "+this.completed;
	}
	
}
