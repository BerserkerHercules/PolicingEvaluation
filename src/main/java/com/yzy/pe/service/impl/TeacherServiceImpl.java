package com.yzy.pe.service.impl;

import com.yzy.pe.entity.AddPoint;
import com.yzy.pe.entity.DeletePoint;
import com.yzy.pe.entity.Punish;
import com.yzy.pe.entity.Reward;
import com.yzy.pe.mapper.TeacherMapper;
import com.yzy.pe.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

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
}
