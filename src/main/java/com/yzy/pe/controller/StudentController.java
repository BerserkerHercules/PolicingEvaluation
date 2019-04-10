package com.yzy.pe.controller;

import com.yzy.pe.entity.*;
import com.yzy.pe.service.StudentService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 学生controller
 *
 * @author YanZiyi
 * @create 2019-03-29 9:49
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * Description ajax获取名字
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/getMyName", method = RequestMethod.POST)
    public User getMyMsg( HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        return user;
    }

    /**
     * Description 打开我的个人信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getMyMsg")
    public ModelAndView getMyMsg() {
        ModelAndView mv = new ModelAndView("my_msg");
        return mv;
    }

    /**
     * Description 打开我的考评信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/myKp")
    public ModelAndView myKp() {
        ModelAndView mv = new ModelAndView("my_kp");
        return mv;
    }

    /**
     * Description 个人加分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getAddPoint")
    @ResponseBody
    public List<AddPoint> getAddPoint(AddPoint addPoint,HttpServletRequest request,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        addPoint.setUserId(user.getUserId());
        List<AddPoint> list = studentService.getAddPoint(addPoint, pageNum, pageSize);
        return list;
    }

    /**
     * Description 个人扣分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getDeletePoint")
    @ResponseBody
    public List<DeletePoint> getDeletePoint(DeletePoint deletePoint,HttpServletRequest request,
                                            @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "5") int pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        deletePoint.setUserId(user.getUserId());
        return studentService.getDeletePoint(deletePoint, pageNum, pageSize);
    }

    /**
     * Description 个人惩罚信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getPunishList")
    @ResponseBody
    public List<Punish> getPunishList(Punish punish,HttpServletRequest request,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        punish.setUserId(user.getUserId());
        return studentService.getPunishList(punish, pageNum, pageSize);
    }

    /**
     * Description 个人奖励信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getRewardList")
    @ResponseBody
    public List<Reward> getRewardList(Reward reward,HttpServletRequest request,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        reward.setUserId(user.getUserId());
        return studentService.getRewardList(reward, pageNum, pageSize);
    }

    /**
     * Description 我的区队信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getUserTeam")
    @ResponseBody
    public Team getUserTeam(String userId) {
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
    public List<DeletePoint> getTeamDeletePoint(DeletePoint deletePoint,
                                                @RequestParam(defaultValue = "1") int pageNum,
                                                @RequestParam(defaultValue = "10") int pageSize) {
        return studentService.getTeamDeletePoint(deletePoint, pageNum, pageSize);
    }

}
