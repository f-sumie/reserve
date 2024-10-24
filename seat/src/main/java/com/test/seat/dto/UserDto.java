package com.test.seat.dto;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	
	@NotEmpty
	private  Integer userId;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String password;
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId =userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}