package com.argabi.taskmanager.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="tasks")
public class Task {

	//1 ID 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//2 Task name
	@Size(min = 2,message="Task must be greater than 2 characters")
	private String task_name;
	
	//3 Priority Low , Medium , High
	//@Size(min = 1,message="priority 1= hgih 2= meduim  3= low")
	private Long priority;
	
	
	//4 Assignee ( user ID )
	private String assignee;
	
	//5 Creator (FK user_id)
	/////////////////////////////////////////////////////////
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator")
	private User creator;
	/////////////////////////////////////////////////////////

	public  Task () {
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getTask_name() {
		return task_name;
	}


	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}


	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	
}


