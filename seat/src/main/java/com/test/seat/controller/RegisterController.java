package com.test.seat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.test.seat.dto.UserDto;
import com.test.seat.model.User;
import com.test.seat.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerForm() {
	return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserDto userDto) {
		User existing = userService.findByUserName(userDto.getUserName());
			if (existing != null) {
				return "register";
			}
		userService.save(userDto);
		return "login";
	}


}
