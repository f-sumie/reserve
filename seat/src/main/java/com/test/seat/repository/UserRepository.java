package com.test.seat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.seat.model.Seat;
import com.test.seat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);
	List<User> findAll();
	User findByUserId(Integer userId);
}
