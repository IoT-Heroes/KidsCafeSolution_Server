package com.heroes.vo;

import java.util.List;

public class ChildVo {

  private String id;
  private String parentId;
  private String userId;
  private String name;
  private String isBandWearing;
  private String sex;

  private int targetActivityFigure;
  private int age;
  private int height;
  private int weight;
  
  
  private List<FoodVo> eatableFoodList;
  private CafeVisitingRecordVo currentCafeVisitingRecord;
  private List<CafeVisitingRecordVo> cafeVisitingRecord;
  
  public List<FoodVo> getEatableFoodList() {
    return eatableFoodList;
  }

  public void setEatableFoodList(List<FoodVo> eatableFoodList) {
    this.eatableFoodList = eatableFoodList;
  }

  public CafeVisitingRecordVo getCurrentCafeVisitingRecord() {
    return currentCafeVisitingRecord;
  }

  public void setCurrentCafeVisitingRecord(CafeVisitingRecordVo currentCafeVisitingRecord) {
    this.currentCafeVisitingRecord = currentCafeVisitingRecord;
  }

  public List<CafeVisitingRecordVo> getCafeVisitingRecord() {
    return cafeVisitingRecord;
  }

  public void setCafeVisitingRecord(List<CafeVisitingRecordVo> cafeVisitingRecord) {
    this.cafeVisitingRecord = cafeVisitingRecord;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIsBandWearing() {
    return isBandWearing;
  }

  public void setIsBandWearing(String isBandWearing) {
    this.isBandWearing = isBandWearing;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public int getTargetActivityFigure() {
    return targetActivityFigure;
  }

  public void setTargetActivityFigure(int targetActivityFigure) {
    this.targetActivityFigure = targetActivityFigure;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }



}
