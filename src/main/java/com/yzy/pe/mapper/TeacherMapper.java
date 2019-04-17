package com.yzy.pe.mapper;

import com.yzy.pe.entity.User;

import java.util.List;

/**
 * 学生mapper
 *
 * @author YanZiyi
 * @create 2019-03-29 9:43
 */
public interface TeacherMapper {

    List<User> getStuMsg(User user);

    String haveId(String id);

}
