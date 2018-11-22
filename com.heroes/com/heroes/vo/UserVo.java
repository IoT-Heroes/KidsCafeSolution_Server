package com.heroes.vo;

public class UserVo {
	private String id;
	private String name;
	private String phoneNumber;
	private int visitCounter;

	private String token; // push를 보내기 위해.. 필요한가 생각해보고 결정
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getVisitCounter() {
		return visitCounter;
	}

	public void setVisitCounter(int visitCounter) {
		this.visitCounter = visitCounter;
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
