package com.heroes.vo;

import java.util.List;

public class IoTMakersResultVo {
  private String responseCode;
  private List<Data> data;

  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public List<Data> getData() {
    return data;
  }

  public void setData(List<Data> data) {
    this.data = data;
  }

  



}


class Data {

  private String occDt;
  private List<DeviceData> attributes;

  public String getOccDt() {
    return occDt;
  }

  public void setOccDt(String occDt) {
    this.occDt = occDt;
  }

  public List<DeviceData> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<DeviceData> attributes) {
    this.attributes = attributes;
  }


}


class DeviceData {
  private String Temp;
  private String Humi;

  public String getTemp() {
    return Temp;
  }

  public void setTemp(String temp) {
    Temp = temp;
  }

  public String getHumi() {
    return Humi;
  }

  public void setHumi(String humi) {
    Humi = humi;
  }



}
