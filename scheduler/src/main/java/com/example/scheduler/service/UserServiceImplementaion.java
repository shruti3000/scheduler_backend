package com.example.scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.scheduler.entity.User;
import com.example.scheduler.repository.UserRepository;
import com.songs.exceptions.ResourceNotFoundException;

@Service

public class UserServiceImplementaion implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public User saveMeet(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}


	@Override
	public List<User> getMeetByUsers(String username) throws java.util.NoSuchElementException  {
		List<User> meet =userRepo.findByUsername(username);
		if(!meet.isEmpty()) {
			return meet;
		}
		else {
			throw new ResourceNotFoundException("username not found");
		}
	
	}

	@Override
	public List<User> getMeetByUsersAndDate(String date) {
		
		return userRepo.findByDate(date);
	}

//	
//	@Override
//	public void deleteMeet(long meet_id) {
//		
//		userRepo.deleteById(meet_id);
//		
//	}

	@Override
	public User updateMeet(long meetid, User user) {
		Optional<User> findByMeetid=userRepo.findByMeetid(meetid);
		
		
		if(userRepo.findByMeetid(meetid).isPresent()) {
			User userEntity=findByMeetid.get();
			
			userEntity.setUsername(user.getUsername());
			userEntity.setUsername2(user.getUsername2());
			userEntity.setDate(user.getDate());
			userEntity.setTime(user.getTime());
			userEntity.setTitle(user.getTitle());
			userEntity.setDescription(user.getDescription());
			userEntity.setFlag(user.getFlag());
			return userRepo.save(userEntity);	
			
		  
		}
		return null;
	}

}
