package com.zjw.oa.service.impl;

import com.zjw.oa.mapper.UserMapper;
import com.zjw.oa.entity.User;
import com.zjw.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:47:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User user1 = userMapper.userLogin(user);
        return user1;
    }

}
