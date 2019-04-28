package com.yzy.pe.entity.dto;

import java.util.Date;

/**
 * @author ZhengJiawei
 * @create 2019-04-15 16:01
 */
public class TeamDelDto {

    private long checkId;

    private String qdbm;

    private String qdmc;

    private String checkName;

    private Integer countTeam;

    private Date kfTime;

    public long getCheckId() {
        return checkId;
    }

    public void setCheckId(long checkId) {
        this.checkId = checkId;
    }

    public Integer getCountTeam() {
        return countTeam;
    }

    public void setCountTeam(Integer countTeam) {
        this.countTeam = countTeam;
    }

    public Date getKfTime() {
        return kfTime;
    }

    public void setKfTime(Date kfTime) {
        this.kfTime = kfTime;
    }

    public String getQdbm() {
        return qdbm;
    }

    public void setQdbm(String qdbm) {
        this.qdbm = qdbm;
    }

    public String getQdmc() {
        return qdmc;
    }

    public void setQdmc(String qdmc) {
        this.qdmc = qdmc;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }
}
