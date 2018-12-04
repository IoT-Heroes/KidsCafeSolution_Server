package com.heroes.vo;

public class ZoneVo {

	private String id;
	private String name;
	private int maxCapacity;
	private int currentUsingCount;
	private int limitAge;
	private int stateCode;

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

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getCurrentUsingCount() {
		return currentUsingCount;
	}

	public void setCurrentUsingCount(int currentUsingCount) {
		this.currentUsingCount = currentUsingCount;
	}

	public int getLimitAge() {
		return limitAge;
	}

	public void setLimitAge(int limitAge) {
		this.limitAge = limitAge;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

}
