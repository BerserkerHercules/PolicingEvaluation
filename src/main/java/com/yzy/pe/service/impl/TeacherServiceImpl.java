package com.yzy.pe.service.impl;

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
        teacherMapper.addWj(userWj);
        teacherMapper.delWjTj(userWj);
    }

    @Override
    public void delWjTj(UserWj userWj) {
        teacherMapper.delWjTj(userWj);
    }
}
