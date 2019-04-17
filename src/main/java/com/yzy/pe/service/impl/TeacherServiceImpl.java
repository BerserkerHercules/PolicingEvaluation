package com.yzy.pe.service.impl;

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
}
