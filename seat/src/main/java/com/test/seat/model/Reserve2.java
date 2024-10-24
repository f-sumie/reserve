package com.test.seat.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserve2")
public class Reserve2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserveId")
	private Integer reserveId;
	
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "seatId")
	private Integer seatId;
	
	@Column(name = "seatId2")
	private Integer seatId2;
	
	@Column(name = "seatId3")
	private Integer seatId3;
	
	@Column(name = "reserve", nullable = false)
	private Boolean reserve;
	
	@Column(name = "StartDateTime", nullable = false)
	private Date startDateTime;
	
	@Column(name = "StartDateTime2", nullable = false)
	private Date startDateTime2;
	
	@Column(name = "EndDateTime", nullable = false)
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
