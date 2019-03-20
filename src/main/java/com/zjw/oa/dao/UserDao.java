package com.zjw.oa.dao;

import com.zjw.oa.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    /**
     * Description 登录
     *
     * @param user 用户
     * @return User
     * @author ZhengJiawei
     * @date 2019-03-20 16:29:47
     */
    User userLogin(User user);

    User getOne();
}
