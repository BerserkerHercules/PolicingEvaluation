package com.zjw.oa.entity.pojo;

import javax.validation.constraints.NotNull;
/**
 * 登录账号映射
 *
 * @author ZhengJiawei
 * @create 2019-03-20 16:48
 */
public class VueLoginInfoVo {

    @NotNull(message="学号/工号不允许为空")
    private String userId;

    @NotNull(message="密码不允许为空")
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
