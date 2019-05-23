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

    void kpAdd(AddPoint addPoint);

    void kpDel(DeletePoint deletePoint);

    void kpReward(Reward reward);

    void kpPunish(Punish punish);

    void addPoint(AddPoint addPoint);
    void delPoint(DeletePoint deletePoint);

    void addWjTj(UserWj userWj);

    void addWj(UserWj userWj);

    void delWjTj(UserWj userWj);

    List<UserWj> userWj();

    List<UserWj> userWjTj();

    List<DeletePoint> allDel(User user);

    DeletePoint getDel(DeletePoint deletePoint);

    void upDel(DeletePoint deletePoint);
    void delThis(DeletePoint deletePoint);

    List<WeakCheck> allCheck();

}
