package com.yzy.pe.service.impl;

import com.github.pagehelper.PageHelper;
import com.yzy.pe.entity.Advice;
import com.yzy.pe.entity.Permission;
import com.yzy.pe.entity.User;
import com.yzy.pe.mapper.UserMapper;
import com.yzy.pe.service.UserService;
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
        return userMapper.userLogin(user);
    }

    @Override
    public List<User> getUserList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.getUserList();
    }

    @Override
    public List<Permission> getPerList(Long permissionDegree, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.getPerList(permissionDegree);
    }

    @Override
    public List<Advice> getAdviceList(Advice advice, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
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

    @Override
    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }

    @Override
    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }

    @Override
    public void updateUserBySelf(User user) {
        userMapper.updateUserBySelf(user);
    }

}
