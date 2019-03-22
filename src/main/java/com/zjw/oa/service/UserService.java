package com.zjw.oa.service;

import com.zjw.oa.entity.User;

import java.util.List;

/**
 * Description
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:47:26
 */
public interface UserService {

    User login(User user);

    List<User> getUserList();

}
