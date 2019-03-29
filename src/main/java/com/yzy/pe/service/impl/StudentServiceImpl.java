package com.yzy.pe.service.impl;

import com.github.pagehelper.PageHelper;
import com.yzy.pe.entity.*;
import com.yzy.pe.mapper.StudentMapper;
import com.yzy.pe.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YanZiyi
 * @create 2019-03-29 9:50
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<AddPoint> getAddPoint(AddPoint addPoint, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AddPoint> list = studentMapper.getAddPoint(addPoint);
        return list;
    }

    @Override
    public List<DeletePoint> getDeletePoint(DeletePoint deletePoint, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return studentMapper.getDeletePoint(deletePoint);
    }

    @Override
    public List<Punish> getPunishList(Punish punish, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return studentMapper.getPunishList(punish);
    }

    @Override
    public List<Reward> getRewardList(Reward reward, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return studentMapper.getRewardList(reward);
    }

    @Override
    public Team getUserTeam(String userId) {
        return studentMapper.getUserTeam(userId);
    }

    @Override
    public List<DeletePoint> getTeamDeletePoint(DeletePoint deletePoint, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return studentMapper.getTeamDeletePoint(deletePoint);
    }
}
