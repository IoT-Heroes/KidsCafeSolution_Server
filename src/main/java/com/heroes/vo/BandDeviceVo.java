package com.heroes.vo;

public class BandDeviceVo {

	private String id;
	private boolean isRent;
	private String isCurrentLocation;
	private String isBeforeLocation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getIsRent() {
		return isRent;
	}

	public void setIsRent(boolean isRent) {
		this.isRent = isRent;
	}

	public String getIsCurrentLocation() {
		return isCurrentLocation;
	}

	public void setIsCurrentLocation(String isCurrentLocation) {
		this.isCurrentLocation = isCurrentLocation;
	}

	public String getIsBeforeLocation() {
		return isBeforeLocation;
	}

	public void setIsBeforeLocation(String isBeforeLocation) {
		this.isBeforeLocation = isBeforeLocation;
	}

}
