package com.example.scheduler.service;

import java.util.List;

import com.example.scheduler.entity.User;

public interface UserService {
	
	public User saveMeet(User user);
	public List<User>getMeetByUsers(String username);
	public List<User>getMeetByUsersAndDate(String date);
	public User updateMeet(long meetid, User user);
//	public void deleteMeet(long meet_id);
}
