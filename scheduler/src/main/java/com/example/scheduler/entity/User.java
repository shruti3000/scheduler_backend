package com.example.scheduler.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="meetDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	/**
	 * @param username
	 * @param date
	 * @param time
	 * @param title
	 * @param description
	 */
	@Id
	private String username;
	private String date;
	private String time;
	private String title;
	private String description;
	private long meetid;
	private String username2;
	private String flag;
	
	
	/**
	 * 
	 */
	public User() {
		super();
	}

	public User(long meet_id, String username, String date, String time, String title, String description, String username2, String flag) {
		super();
		this.meetid=meet_id;
		this.username = username;
		this.date = date;
		this.time = time;
		this.title = title;
		this.description = description;
		this.username2=username2;
		this.flag=flag;
		
		
	}
	
	public long getMeet_id() {
		return meetid;
	}

	public void setMeet_id(long meetid) {
		this.meetid = meetid;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String username2) {
		this.username2 = username2;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	

	
}
