package com.yzy.pe.service.impl;

import com.yzy.pe.entity.AddPoint;
import com.yzy.pe.entity.DeletePoint;
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
    public List<AddPoint> getAddPoint(AddPoint addPoint) {
        return studentMapper.getAddPoint(addPoint);
    }

    @Override
    public List<DeletePoint> getDeletePoint(DeletePoint deletePoint) {
        return studentMapper.getDeletePoint(deletePoint);
    }
}
