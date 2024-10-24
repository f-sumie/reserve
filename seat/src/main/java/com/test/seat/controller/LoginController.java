package com.test.seat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.seat.dto.UserDto;
import com.test.seat.repository.SeatRepository;
import com.test.seat.repository.UserRepository;
import com.test.seat.service.SeatService;
//import com.test.seat.service.SeatService;
import com.test.seat.service.UserService;

import jakarta.servlet.http.HttpSession;

import com.test.seat.model.Seat;
import com.test.seat.model.User;

	@Controller
	public class LoginController {
	@GetMapping("/login")
		public String login() {
		return "login";
	}
	@Autowired
	private UserService userService;
	  
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String redirectToIReserve(HttpSession session, Integer userId) {
		// 現在のユーザーの認証情報を取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
	if (authentication != null && authentication.isAuthenticated()) {
		System.out.println("A");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		User user = userService.findByUserName(auth.getName());
		session.setAttribute("loginUser", user);
		System.out.println(userId);
		
		return "redirect:/reserve";
	}
		return "redirect:/login";
	}

	
}
