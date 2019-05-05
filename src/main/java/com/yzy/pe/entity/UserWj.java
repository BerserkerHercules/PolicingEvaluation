package com.yzy.pe.entity;


import java.sql.Date;

public class UserWj {

  private long wjId;
  private String wjMs;
  private String userName;
  private String userId;
  private long wjPoint;
  private Date wjTime;
  private String wjcl;
  private int wjdj;


  public long getWjId() {
    return wjId;
  }

  public void setWjId(long wjId) {
    this.wjId = wjId;
  }


  public String getWjMs() {
    return wjMs;
  }

  public void setWjMs(String wjMs) {
    this.wjMs = wjMs;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public long getWjPoint() {
    return wjPoint;
  }

  public void setWjPoint(long wjPoint) {
    this.wjPoint = wjPoint;
  }


  public Date getWjTime() {
    return wjTime;
  }

  public void setWjTime(Date wjTime) {
    this.wjTime = wjTime;
  }


  public String getWjcl() {
    return wjcl;
  }

  public void setWjcl(String wjcl) {
    this.wjcl = wjcl;
  }

  public int getWjdj() {
    return wjdj;
  }

  public void setWjdj(int wjdj) {
    this.wjdj = wjdj;
  }
}
