package com.test.seat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.seat.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
	
	List<Seat> findAll();
	Seat findBySeatId(Integer SeatId);
		
}
