package com.yzy.pe.entity;


import java.util.Date;

public class AddPoint {

  private long addId;
  private String userId;
  private String userName;
  private long addPoint;
  private String addDesc;
  private Date time;


  public long getAddId() {
    return addId;
  }

  public void setAddId(long addId) {
    this.addId = addId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public long getAddPoint() {
    return addPoint;
  }

  public void setAddPoint(long addPoint) {
    this.addPoint = addPoint;
  }


  public String getAddDesc() {
    return addDesc;
  }

  public void setAddDesc(String addDesc) {
    this.addDesc = addDesc;
  }


  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
}
