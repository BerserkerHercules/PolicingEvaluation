package com.yzy.pe.controller;

import com.github.pagehelper.PageInfo;
import com.yzy.pe.entity.*;
import com.yzy.pe.service.TeacherService;
import com.yzy.pe.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public PageInfo<User> getDeletePoint(String userId, @RequestParam(defaultValue = "1") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize) {
        User user = new User();
        user.setUserId(userId);
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
        mv.addObject("checkList",teacherService.allCheck());
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
     * 打开提交违纪页面
     */
    @RequestMapping(value = "/addWj", method = RequestMethod.GET)
    public ModelAndView addWj(String userId) {
        ModelAndView mv = new ModelAndView("/teacher/add_wj");
        User user = new User();
        user.setUserId(userId);
        User user1 = userService.selectUser(user);
        mv.addObject("user",user1);
        return mv;
    }

    /**
     * 打开违纪信息页面
     */
    @RequestMapping(value = "/allWj")
    public ModelAndView allWj() {
        ModelAndView mv = new ModelAndView("/teacher/all_wj");
        List<UserWj> list = teacherService.userWj();
        mv.addObject("list",list);
        return mv;
    }

    /**
     * 所有违纪
     * @return
     */
    @RequestMapping("/get_all_wj")
    @ResponseBody
    public List<UserWj> getAllWj(){
        return teacherService.userWj();
    }

    /**
     * 提交重大违纪
     */
    @RequestMapping("/add_wj")
    public ModelAndView addWj(UserWj userWj){
        String wjdj = userWj.getWjdj()+"";
        Map<String,String> wjMap = new HashMap<>(5);
        wjMap.put("1","口头警告");
        wjMap.put("2","警告");
        wjMap.put("3","严重警告");
        wjMap.put("4","记过");
        wjMap.put("5","记大过");
        userWj.setWjdjms(wjMap.get(wjdj));
        teacherService.addWjTj(userWj);
        ModelAndView mv = new ModelAndView("/teacher/all_user");
        return mv;
    }

    /**
     * Description 打开近期扣分
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/all_del")
    public ModelAndView allDel() {
        ModelAndView mv = new ModelAndView("/teacher/all_del");
        return mv;
    }

    /**
     * 扣分学生
     */
    @RequestMapping("/del_list")
    @ResponseBody
    public PageInfo<DeletePoint> delList(String userId, @RequestParam(defaultValue = "1") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize) {
        List<DeletePoint> list = teacherService.allDel(userId, pageNum, pageSize);
        return new PageInfo<>(list);
    }

    /**
     * 编辑此次扣分
     */
    @RequestMapping("/del_del")
    @ResponseBody
    public ModelAndView delDel(String userName,String userId,String deleteId) {
        ModelAndView mv = new ModelAndView("/teacher/update_del");
        DeletePoint deletePoint1 = new DeletePoint();
        deletePoint1.setDeleteId(Long.parseLong(deleteId));
        DeletePoint deletePoint = teacherService.getDel(deletePoint1);
        mv.addObject("userId",userId);
        mv.addObject("deletePoint",deletePoint);
        mv.addObject("userName",userName);
        return mv;
    }

    /**
     * 录入扣分
     */
    @RequestMapping(value = "/upDel")
    @ResponseBody
    public ModelAndView upDel(DeletePoint deletePoint) {
        ModelAndView mv = new ModelAndView("/teacher/all_del");
        teacherService.upDel(deletePoint);
        return mv;
    }

    /**
     * 编辑此次扣分
     */
    @RequestMapping(value = "/del_this")
    @ResponseBody
    public ModelAndView delThis(String deleteId) {
        ModelAndView mv = new ModelAndView("/teacher/all_del");
        DeletePoint deletePoint1 = new DeletePoint();
        deletePoint1.setDeleteId(Long.parseLong(deleteId));
        DeletePoint deletePoint = teacherService.getDel(deletePoint1);
        teacherService.delThis(deletePoint);
        return mv;
    }




}