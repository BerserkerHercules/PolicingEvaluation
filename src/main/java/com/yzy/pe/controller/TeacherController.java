package com.yzy.pe.controller;

import com.github.pagehelper.PageInfo;
import com.yzy.pe.entity.*;
import com.yzy.pe.service.TeacherService;
import com.yzy.pe.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description user
 *
 * @author YanZiyi
 * @date 2019-03-21 10:49:24
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @Resource
    private UserService userService;

    /**
     * Description 打开所有学生页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/all_user")
    public ModelAndView week() {
        ModelAndView mv = new ModelAndView("/teacher/all_user");
        return mv;
    }

    /**
     * Description 所有学生信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getUserList")
    @ResponseBody
    public PageInfo<User> getDeletePoint(User user, @RequestParam(defaultValue = "1") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize) {
        List<User> list = userService.selectUserList(user, pageNum, pageSize);
        return new PageInfo<>(list);
    }

    /**
     * Description 打开学生详情页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ModelAndView getUser(String userId) {
        ModelAndView mv = new ModelAndView("/teacher/user_msg");
        User user = new User();
        user.setUserId(userId);
        User user1 = userService.selectUser(user);
        mv.addObject("user",user1);
        return mv;
    }

    /**
     * Description 获取学生详情
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/getUserMsg")
    @ResponseBody
    public User getUserMsg(String userId) {
        User user = new User();
        user.setUserId(userId);
        User user1 = userService.selectUser(user);
        return user1;
    }

    /**
     * Description 打开添加学生页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/addUser")
    public ModelAndView addUser() {
        ModelAndView mv = new ModelAndView("/teacher/add_user");
        return mv;
    }

    /**
     * Description 添加
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/haveId")
    @ResponseBody
    public String haveId(String userId, String userName,
                         String phone, String qdbm,
                         String email, String qshm,
                         String xb, String permissionDegree) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setQdbm(qdbm);
        user.setQshm(qshm);
        user.setXb(xb);
        user.setPermissionDegree(Long.parseLong(permissionDegree));
        String haveId = teacherService.haveId(userId);
        if ("true".equals(haveId)) {
            return "false";
        } else {
            userService.addUser(user);
        }
        return "true";
    }

    /**
     * 打开录入考评页面
     */
    @RequestMapping(value = "/addUserKp", method = RequestMethod.GET)
    public ModelAndView addUserKp(String userId) {
        ModelAndView mv = new ModelAndView("/teacher/add_kp");
        User user = new User();
        user.setUserId(userId);
        User user1 = userService.selectUser(user);
        mv.addObject("user",user1);
        return mv;
    }

    /**
     * 录入学生加分
     */
    @RequestMapping(value = "/kpAdd")
    @ResponseBody
    public ModelAndView kpAdd(AddPoint addPoint) {

        try{
            teacherService.kpAdd(addPoint);
        }catch (Exception e){
            System.out.println(e);
        }
        ModelAndView mv = new ModelAndView("/teacher/add_kp");
        User user = new User();
        user.setUserId(addPoint.getUserId());
        User user1 = userService.selectUser(user);
        mv.addObject("user",user1);
        return mv;
    }

    /**
     * 录入扣分
     */
    @RequestMapping(value = "/kpDel")
    @ResponseBody
    public ModelAndView kpDel(DeletePoint deletePoint) {
        try{
            teacherService.kpDel(deletePoint);
        }catch (Exception e){
            System.out.println(e);
        }
        ModelAndView mv = new ModelAndView("/teacher/add_kp");
        User user = new User();
        user.setUserId(deletePoint.getUserId());
        User user1 = userService.selectUser(user);
        mv.addObject("user",user1);
        return mv;
    }

    /**
     * 录入惩罚
     */
    @RequestMapping(value = "/kpPunish")
    @ResponseBody
    public ModelAndView kpPunish(Punish punish) {
        try{
            teacherService.kpPunish(punish);
        }catch (Exception e){
            System.out.println(e);
        }
        ModelAndView mv = new ModelAndView("/teacher/add_kp");
        User user = new User();
        user.setUserId(punish.getUserId());
        User user1 = userService.selectUser(user);
        mv.addObject("user",user1);
        return mv;
    }

    /**
     * 录入奖励
     */
    @RequestMapping(value = "/kpReward")
    @ResponseBody
    public ModelAndView kpReward(Reward reward) {
        try{
            teacherService.kpReward(reward);
        }catch (Exception e){
            System.out.println(e);
        }
        ModelAndView mv = new ModelAndView("/teacher/add_kp");
        User user = new User();
        user.setUserId(reward.getUserId());
        User user1 = userService.selectUser(user);
        mv.addObject("user",user1);
        return mv;
    }

    /**
     * 提交重大违纪
     */

}
