package com.yzy.pe.controller;

import com.yzy.pe.entity.*;
import com.yzy.pe.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<AddPoint> getAddPoint(AddPoint addPoint,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10")int pageSize){
        return studentService.getAddPoint(addPoint,pageNum,pageSize);
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

    /**
     * Description 个人惩罚信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getPunishList")
    @ResponseBody
    public List<Punish> getPunishList(Punish punish){
        return studentService.getPunishList(punish);
    }

    /**
     * Description 个人奖励信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getRewardList")
    @ResponseBody
    public List<Reward> getRewardList(Reward reward){
        return studentService.getRewardList(reward);
    }

    /**
     * Description 我的区队信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getUserTeam")
    @ResponseBody
    public Team getUserTeam(String userId){
        return studentService.getUserTeam(userId);
    }

    /**
     * Description 区队扣分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getTeamDeletePoint")
    @ResponseBody
    public List<DeletePoint> getTeamDeletePoint(DeletePoint deletePoint){
        return studentService.getTeamDeletePoint(deletePoint);
    }

}
