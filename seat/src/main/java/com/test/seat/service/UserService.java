package com.test.seat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.test.seat.dto.UserDto;
import com.test.seat.model.Seat;
import com.test.seat.model.User;
import com.test.seat.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (user == null) {
		throw new UsernameNotFoundException("User not found");
		}
		return new UserPrincipalService(user);
		}
		public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
		}
	
	@Transactional
	public void save(UserDto userDto) {
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userRepository.save(user);
	}

	@Transactional
	public List<User> searchAll() {
	    return userRepository.findAll();
	}
	//
	public User findByUserId(Integer userId) {
		System.out.println("CCCCC");	
		return userRepository.findByUserId(userId);
	}
	
	/*
	public void update(UserDto userDto, Integer id) {
		User user = new User();
		user.setUser_id(id);		
		user.setUser_name(userDto.getUser_name());
		user.setPassword(userDto.getPassword());		

		
		userRepository.save(user);
	}
	
	public void delete(Integer id) {
		User user = new User();
		user.setUser_id(id);
		
		userRepository.delete(user);
	}
	*/
}
