package com.heroes.vo;

import java.util.ArrayList;

public class ZoneVo {

  private String id;
  private String name;
  private String maxCapacity;
  private String currentUsingCount;
  private String limitAge;
  private String codeId;
  private String deviceId;

  private ArrayList<ZoneCoordinateVo> coordinates;

  public void setId(String id) {
    this.id = id;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getId() {
    return id;
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


  public String getCodeId() {
    return codeId;
  }

  public void setCodeId(String codeId) {
    this.codeId = codeId;
  }

  public ArrayList<ZoneCoordinateVo> getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(ArrayList<ZoneCoordinateVo> coordinates) {
    this.coordinates = coordinates;
  }

}
