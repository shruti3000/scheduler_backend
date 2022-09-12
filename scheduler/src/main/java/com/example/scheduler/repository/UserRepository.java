package com.example.scheduler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.scheduler.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
	
	public List<User> findByUsername(String username);
	public List<User> findByDate(String date);
	public Optional<User> findByMeetid(long meetid);
}
