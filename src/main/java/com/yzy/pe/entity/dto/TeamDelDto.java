package com.yzy.pe.entity.dto;

import java.sql.Date;

/**
 * @author ZhengJiawei
 * @create 2019-04-15 16:01
 */
public class TeamDelDto {

    private long checkId;

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

}
