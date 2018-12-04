package com.heroes.vo;

public class ZoneVo {

	private String id;
	private String name;
	private String maxCapacity;
	private String currentUsingCount;
	private String limitAge;
	private String stateCode;

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

	public String getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(String maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getCurrentUsingCount() {
		return currentUsingCount;
	}

	public void setCurrentUsingCount(String currentUsingCount) {
		this.currentUsingCount = currentUsingCount;
	}

	public String getLimitAge() {
		return limitAge;
	}

	public void setLimitAge(String limitAge) {
		this.limitAge = limitAge;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

}
