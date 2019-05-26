package com.yzy.pe.service.impl;

import com.github.pagehelper.PageHelper;
import com.yzy.pe.entity.*;
import com.yzy.pe.mapper.TeacherMapper;
import com.yzy.pe.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YanZiyi
 * @create 2019-03-29 9:50
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public String haveId(String id) {
        String userId = teacherMapper.haveId(id);
        if (StringUtils.isEmpty(userId)) {
            return "false";
        }
        return "true";
    }

    @Override
    public void kpAdd(AddPoint addPoint) throws Exception {
        teacherMapper.addPoint(addPoint);
        teacherMapper.kpAdd(addPoint);
    }

    @Override
    public void kpDel(DeletePoint deletePoint) throws Exception {
        teacherMapper.delPoint(deletePoint);
        teacherMapper.kpDel(deletePoint);
    }

    @Override
    public void kpReward(Reward reward) throws Exception {
        teacherMapper.kpReward(reward);
    }

    @Override
    public void kpPunish(Punish punish) throws Exception {
        teacherMapper.kpPunish(punish);
    }

    @Override
    public List<UserWj> userWj() {
        return teacherMapper.userWj();
    }

    @Override
    public void addWjTj(UserWj userWj) {
        teacherMapper.addWjTj(userWj);
    }

    @Override
    public List<UserWj> userWjTj() {
        return teacherMapper.userWjTj();
    }

    @Override
    public void addWj(UserWj userWj) {
        DeletePoint deletePoint = new DeletePoint();
        deletePoint.setUserId(userWj.getUserId());
        deletePoint.setUserName(userWj.getUserName());
        deletePoint.setDeletePoint(userWj.getWjPoint());
        teacherMapper.delPoint(deletePoint);
        teacherMapper.addWj(userWj);
        teacherMapper.delWjTj(userWj);
    }

    @Override
    public void delWjTj(UserWj userWj) {
        teacherMapper.delWjTj(userWj);
    }

    @Override
    public List<DeletePoint> allDel(DeletePoint dp, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return teacherMapper.allDel(dp);
    }

    @Override
    public DeletePoint getDel(DeletePoint deletePoint) {
        return teacherMapper.getDel(deletePoint);
    }

    @Override
    public void upDel(DeletePoint deletePoint) {
        teacherMapper.upDel(deletePoint);
    }

    @Override
    public void delThis(DeletePoint deletePoint) {
        AddPoint addPoint = new AddPoint();
        addPoint.setUserId(deletePoint.getUserId());
        addPoint.setAddPoint(deletePoint.getDeletePoint());
        teacherMapper.addPoint(addPoint);
        teacherMapper.delThis(deletePoint);
    }

    @Override
    public List<WeakCheck> allCheck() {
        return teacherMapper.allCheck();
    }
}
