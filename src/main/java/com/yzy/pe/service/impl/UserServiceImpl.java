package com.yzy.pe.service.impl;

import com.yzy.pe.entity.Advice;
import com.yzy.pe.entity.Permission;
import com.yzy.pe.mapper.UserMapper;
import com.yzy.pe.entity.User;
import com.yzy.pe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 *
 * @author YanZiyi
 * @date 2019-03-21 10:47:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User user1 = userMapper.userLogin(user);
        return user1;
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public List<Permission> getPerList(String permissionDegree) {
        return userMapper.getPerList(permissionDegree);
    }

    @Override
    public List<Advice> getAdviceList(Advice advice) {
        return userMapper.getAdviceList(advice);
    }

    @Override
    public void orderAdvice(Advice advice) {
        userMapper.orderAdvice(advice);
    }

    @Override
    public void reviewAdvice(Advice advice) {
        userMapper.reviewAdvice(advice);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}
