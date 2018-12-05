package com.heroes.vo;

import java.util.ArrayList;

public class UserVo {
	private String id;
	private String name;
	private String password;
	private String phoneNumber;
	private String isAuthor;
	private String token;

	private ArrayList<ChildVo> child;
	

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


	public ArrayList<ChildVo> getChild() {
		return child;
	}

	public void setChild(ArrayList<ChildVo> child) {
		this.child = child;
	}

}