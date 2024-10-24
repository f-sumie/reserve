package com.test.seat.dto;

import java.util.Date;
import com.test.seat.model.Reserve2;

import jakarta.validation.constraints.NotEmpty;

public class Reserve2Dto {
	
	@NotEmpty
	private Integer reserveId;
	
	@NotEmpty
	private Integer userId;
	
	@NotEmpty
	private Integer seatId;
	
	@NotEmpty
	private Boolean reserve;
	
	@NotEmpty
	private Date startDateTime;
	
	@NotEmpty
	private Date endDateTime;
	
	
	public   Integer getReserveId() {
		return reserveId;
	}
	public void setReserveId(Integer reserveId) {
		this.reserveId = reserveId;
	}
	
	public   Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public   Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public Boolean getReserve() {
		return reserve;
	}
	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public  Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public  Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
}


