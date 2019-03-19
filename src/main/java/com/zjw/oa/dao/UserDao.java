package com.zjw.oa.dao;

import com.zjw.oa.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User userLogin(User user);

    User getOne();
}
