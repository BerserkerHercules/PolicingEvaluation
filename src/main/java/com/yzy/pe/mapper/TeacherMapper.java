package com.yzy.pe.mapper;

import com.yzy.pe.entity.*;

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

    void kpAdd(AddPoint addPoint)throws Exception;

    void kpDel(DeletePoint deletePoint)throws Exception;

    void kpReward(Reward reward)throws Exception;

    void kpPunish(Punish punish)throws Exception;

    void addPoint(AddPoint addPoint)throws Exception;

    void delPoint(DeletePoint deletePoint)throws Exception;

    List<UserWj> userWj();
}
