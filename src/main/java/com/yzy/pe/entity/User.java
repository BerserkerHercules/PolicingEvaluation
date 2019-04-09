package com.yzy.pe.entity;


public class User {

  private String userId;
  private String userName;
  private String pwd;
  private long permissionDegree;
  private String qdbm;
  private double kpfs;
  private String phone;
  private String email;
  private String qshm;
  private String xb;


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


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public long getPermissionDegree() {
    return permissionDegree;
  }

  public void setPermissionDegree(long permissionDegree) {
    this.permissionDegree = permissionDegree;
  }


  public String getQdbm() {
    return qdbm;
  }

  public void setQdbm(String qdbm) {
    this.qdbm = qdbm;
  }


  public double getKpfs() {
    return kpfs;
  }

  public void setKpfs(double kpfs) {
    this.kpfs = kpfs;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getQshm() {
    return qshm;
  }

  public void setQshm(String qshm) {
    this.qshm = qshm;
  }


  public String getXb() {
    return xb;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

}
