package com.test.seat.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
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

import com.test.seat.dto.SeatDto;
import com.test.seat.dto.UserDto;
import com.test.seat.repository.SeatRepository;
import com.test.seat.repository.UserRepository;
import com.test.seat.service.SeatService;
import com.test.seat.service.UserService;

import jakarta.servlet.http.HttpSession;

import com.test.seat.model.Seat;
import com.test.seat.model.User;

@Controller
public class ReserveContoller {
	

	@Autowired
	private UserService userService;
	  
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SeatService seatService;
	  
	@Autowired
	private SeatRepository seatRepository;
	
	@GetMapping("/reserve")
	public String displayList(HttpSession session, Date datetime,Model model) {
	System.out.println("AA");
	    User loginUser = (User) session.getAttribute("loginUser");
	    model.addAttribute("loginUser", loginUser);
	    
		List<Seat> seats = seatService.searchAll();
		model.addAttribute("seats", seats);
		
		System.out.println("AAA");
		List<User> users = userService.searchAll();
		model.addAttribute("users", users);
		
		return "reserve.html";
	}

	
	@GetMapping("/check/{seatId}")
	public String displayCheck(@PathVariable Integer seatId, Integer userId, HttpSession session, String datetime, Model model) {
	System.out.println("DD");
	    User loginUser = (User) session.getAttribute("loginUser");
	    model.addAttribute("loginUser", loginUser);
	    
        Seat seat = seatService.findBySeatId(seatId);
        System.out.println("DD");

		Date date = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HHmm");
		String GHiduke = sdf1.format(date);
		model.addAttribute("GHiduke",GHiduke);
		System.out.println(GHiduke);
        
    System.out.println("FF");
        SeatDto seatDto = new SeatDto();
        seatDto.setSeatId(seat.getSeatId());
        seatDto.setSeatNum(seat.getSeatNum());
        seatDto.setReserve(seat.getReserve());
        seatDto.setUserId(loginUser.getUserId());
        seatDto.setDateTime(GHiduke);

        model.addAttribute("SeatDto", seatDto);
        model.addAttribute("Seat", seat);
	        
    System.out.println("GG");
    System.out.println(seatDto.getDateTime());
    System.out.println(seatDto.getUserId());
        
        return "check.html";
	}

	
	@PostMapping("/result/{seatId}")
	public String reserved(@ModelAttribute SeatDto seatDto) {
		System.out.println("HH");
		System.out.println(seatDto.getDateTime());
		seatService.reserved(seatDto, seatDto.getSeatId(), seatDto.getSeatNum(), seatDto.getDateTime());
		System.out.println("KK");
		System.out.println(seatDto.getDateTime());
		return "result.html";
	}
	
	@GetMapping("/check2/{seatId}")
	public String displayCheck2(@PathVariable Integer seatId, Model model) {
	System.out.println("DD2");
        Seat seat = seatService.findBySeatId(seatId);
    System.out.println("FF2");
        SeatDto seatDto = new SeatDto();
        seatDto.setSeatId(seat.getSeatId());
        seatDto.setSeatNum(seat.getSeatNum());
        seatDto.setReserve(seat.getReserve());
        model.addAttribute("SeatDto", seatDto);
        model.addAttribute("Seat", seat);
    System.out.println("GG2");
        
        return "check2.html";
	}
	@PostMapping("/cansel/{seatId}")
	public String cansel(@ModelAttribute SeatDto seatDto,Integer seatId) {
		System.out.println("PP");
		seatService.cansel(seatDto, seatId);
		System.out.println("QQ");
		return "result2.html";	
	}
}