package com.zjw.oa.service.impl;

import com.zjw.oa.dao.UserDao;
import com.zjw.oa.entity.User;
import com.zjw.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        User user1 = userDao.userLogin(user);
        return user1;
    }

    @Override
    public User getOne() {
        User user1 = userDao.getOne();
        return user1;
    }
}
