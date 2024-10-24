//package com.test.seat.model;
//
//import java.util.Date;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.EmbeddedId;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//
//
//@Entity
//@Table(name = "sample")
//public class Sample {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "seatId")
//	private Integer seatId;
//
//	@Column(name = "userId")
//	private Integer userId;
//	
//	@Column(name = "userName", nullable = false, unique = true)
//	private String userName;
//	
//	
//	@Column(name = "startdatetime", nullable = false)
//	private Date startdatetime;
//	
//
//	
//	@Column(name = "reserve", nullable = false)
//	private Boolean reserve;
//
//	@Column(name = "reserve2", nullable = false)
//	private Boolean reserve2;
//	
//	public   Integer getUserId() {
//		return userId;
//	}
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	
//}
