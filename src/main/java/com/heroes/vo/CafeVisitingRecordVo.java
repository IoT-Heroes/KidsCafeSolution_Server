package com.heroes.vo;

import java.sql.Date;

public class CafeVisitingRecordVo {

  private String childId;
  private String childName;
  private String startDate;
  private String endDate;
  private String bandDeviceId;
  private int amountPrice;
  private int amountRest;
  private int usingTime; // default 2

  public String getChildName() {
    return childName;
  }

  public void setChildName(String childName) {
    this.childName = childName;
  }

  public String getChildId() {
    return childId;
  }

  public void setChildId(String childId) {
    this.childId = childId;
  }



  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
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
