package com.heroes.vo;

import java.sql.Date;

public class CafeVisitingRecordVo {

  private String childId;
  private Date startTime;
  private Date endTime;
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

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
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
