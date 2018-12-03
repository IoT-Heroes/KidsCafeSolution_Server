package com.heroes.vo;

public class UserVo {
	private String id;
	private String name;
	private String password;
	private String phoneNumber;
	private String isAuthor;
	private String token;
	private String role; // 일반사용자인지, 관리자인지 구분하기 위해 사용

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIsAuthor() {
		return isAuthor;
	}

	public void setIsAuthor(String isAuthor) {
		this.isAuthor = isAuthor;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}