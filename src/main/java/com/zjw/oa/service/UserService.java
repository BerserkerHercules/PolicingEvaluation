package com.zjw.oa.service;

import com.zjw.oa.entity.User;

public interface UserService {

    User login(User user);

    User getOne();
}
