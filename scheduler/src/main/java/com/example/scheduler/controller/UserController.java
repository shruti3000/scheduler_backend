package com.example.scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.scheduler.entity.User;
import com.example.scheduler.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	ObjectMapper objectMapper=new ObjectMapper();
	
	@PostMapping("/save")
	public User saveMeet(@RequestBody String jsondata) throws JsonMappingException, JsonProcessingException {
		User user=objectMapper.readValue(jsondata, User.class);
		user.setDate(user.getDate());
		user.setDescription(user.getDescription());
		user.setMeet_id(user.getMeet_id());
		user.setTitle(user.getTitle());
		user.setTime(user.getTime());
		user.setUsername(user.getUsername());
		user.setUsername2(user.getUsername2());
		user.setFlag(user.getFlag());
		
		
		
		
		
//		userService.saveMeet(user);
		return userService.saveMeet(user);
	}
	@GetMapping("/list/{username}")
	public List<User> getMeetByUsers(@PathVariable String username) {
		return userService.getMeetByUsers(username);
	}
	@GetMapping("/list22/{date}")
	public List<User> getMeetByUsersAndDate(@PathVariable String date) {
		return userService.getMeetByUsersAndDate(date);
	}
	
	
	@PutMapping("/update/{user_id}")
//	public User updateMeet(@PathVariable("user_id") Long meet_id, @RequestBody User user) {
//		
//		User user=objectMapper.readValue(jsondata,User.class);
//		return userService.updateMeet(meet_id,user);
//	}
	
	 
    public User updateMeet(@PathVariable long meet_id, @RequestParam(required = true, value = "user") String jsondata) throws JsonMappingException, JsonProcessingException {
        User user = objectMapper.readValue(jsondata, User.class);
        return userService.updateMeet(meet_id,user);
    }
//	@PutMapping("/delete/{user_id}")
//	public String deleteMeet(@PathVariable("user_id") Long meet_id) {
//		 userService.deleteMeet(meet_id);
//		 return "deleted";
//	}

}
