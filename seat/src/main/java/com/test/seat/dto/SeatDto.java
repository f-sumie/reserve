package com.test.seat.dto;

import java.util.Date;

import com.test.seat.model.User;

import jakarta.validation.constraints.NotEmpty;

public class SeatDto {
	

	@NotEmpty
	private  Integer seatId;
		
	@NotEmpty
	private Integer seatNum;
		
	@NotEmpty
	private boolean reserve;
	
	@NotEmpty
	private Integer userId;
	
	@NotEmpty
	private String datetime;
	
	public   Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public Integer getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}
	public Boolean getReserve() {
		return reserve;
	}
	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}
	
	public Integer  getUserId() {
		return userId;
	}
	public void setUserId(Integer  userId) {
		this.userId = userId;
	}
    public String getDateTime() {
        return datetime;
     }
     public void setDateTime(String datetime) {
         this.datetime = datetime;
     }
	
}
