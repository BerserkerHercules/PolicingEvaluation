package com.yzy.pe.entity;

public class Advice {

  private long adviceId;
  private String title;
  private String content;
  private long isCross;
  private java.sql.Timestamp orderTime;


  public long getAdviceId() {
    return adviceId;
  }

  public void setAdviceId(long adviceId) {
    this.adviceId = adviceId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getIsCross() {
    return isCross;
  }

  public void setIsCross(long isCross) {
    this.isCross = isCross;
  }


  public java.sql.Timestamp getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(java.sql.Timestamp orderTime) {
    this.orderTime = orderTime;
  }

}
