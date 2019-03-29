package com.yzy.pe.controller;

import com.yzy.pe.entity.AddPoint;
import com.yzy.pe.entity.DeletePoint;
import com.yzy.pe.entity.User;
import com.yzy.pe.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生controller
 *
 * @author YanZiyi
 * @create 2019-03-29 9:49
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * Description 个人加分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getAddPoint")
    @ResponseBody
    public List<AddPoint> getAddPoint(AddPoint addPoint){
        return studentService.getAddPoint(addPoint);
    }

    /**
     * Description 个人扣分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getDeletePoint")
    @ResponseBody
    public List<DeletePoint> getDeletePoint(DeletePoint deletePoint){
        return studentService.getDeletePoint(deletePoint);
    }

}
