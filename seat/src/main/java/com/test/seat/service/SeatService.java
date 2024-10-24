package com.test.seat.service;

import java.util.Date;
import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;

	import com.test.seat.dto.SeatDto;
	import com.test.seat.dto.UserDto;
	import com.test.seat.model.Seat;
	import com.test.seat.model.User;
	import com.test.seat.repository.SeatRepository;
	import com.test.seat.repository.UserRepository;

	@Service
	public class SeatService {

	    @Autowired
		private SeatRepository seatRepository;
		
		@Transactional
		public List<Seat> searchAll() {
			System.out.println("BB");
		    return seatRepository.findAll();
		}
		
		@Transactional
		public void save(SeatDto seatDto) {
			Seat seat = new Seat();
			seat.setSeatId(seatDto.getSeatId());
			seat.setSeatNum(seatDto.getSeatNum());
			seat.setReserve(false);
			seat.setUserId(seatDto.getUserId());
			seat.setDateTime(seatDto.getDateTime());
			seatRepository.save(seat);
		}
		
		public Seat findBySeatId(Integer seatId) {
		System.out.println("EE");
			return seatRepository.findBySeatId(seatId);
		}
	 
		public void reserved(SeatDto seatDto, Integer seatId, Integer userId, String datetime ) {
		System.out.println("II");
		System.out.println(seatDto.getUserId());
			Seat seat = new Seat();
			seat.setSeatId(seatDto.getSeatId());
			seat.setSeatNum(seatDto.getSeatNum());
			seat.setReserve(true);
			seat.setUserId(seatDto.getUserId());
			seat.setDateTime(seatDto.getDateTime());
			System.out.println(seat.getDateTime());
		System.out.println("JJ");
			seatRepository.save(seat);
		System.out.println("KK");
		}
		
		public void cansel(SeatDto seatDto, Integer seatId) {
			System.out.println("LL");
				Seat seat = new Seat();
				seat.setSeatId(seatId);
				seat.setSeatNum(seatId);
				seat.setReserve(false);
				seat.setDateTime(seatDto.getDateTime());
			System.out.println("NN");
				seatRepository.save(seat);
			System.out.println("OO");
			}
	}
		


		
