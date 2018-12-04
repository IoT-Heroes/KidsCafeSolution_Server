package com.heroes.vo;

public class CafeVisitingRecordVo {

	private String childId;
	private String startTime;
	private String endTime;
	private String bandDeviceId;
	private int amountPrice;
	private int amountRest;
	private int usingTime; // default 2

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBandDeviceId() {
		return bandDeviceId;
	}

	public void setBandDeviceId(String bandDeviceId) {
		this.bandDeviceId = bandDeviceId;
	}

	public int getAmountPrice() {
		return amountPrice;
	}

	public void setAmountPrice(int amountPrice) {
		this.amountPrice = amountPrice;
	}

	public int getAmountRest() {
		return amountRest;
	}

	public void setAmountRest(int amountRest) {
		this.amountRest = amountRest;
	}

	public int getUsingTime() {
		return usingTime;
	}

	public void setUsingTime(int usingTime) {
		this.usingTime = usingTime;
	}

}
