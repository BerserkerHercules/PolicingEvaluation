package com.yzy.pe.controller;

import com.github.pagehelper.PageInfo;
import com.yzy.pe.entity.*;
import com.yzy.pe.service.StudentService;
import com.yzy.pe.service.UserService;
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

    @Resource
    private UserService userService;

    /**
     * Description 获取个人信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/getMyName", method = RequestMethod.POST)
    public User getMyMsg( HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        User user1 = userService.selectUser(user);
        return user1;
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
     * Description 打开修改个人信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/change_msg")
    public ModelAndView change_msg() {
        ModelAndView mv = new ModelAndView("change_msg");
        return mv;
    }

    /**
     * Description 打开区队信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/teamMsg")
    public ModelAndView teamMsg() {
        ModelAndView mv = new ModelAndView("team_msg");
        return mv;
    }

    /**
     * Description 修改个人信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/changeMyMsg")
    public ModelAndView changeMyMsg(User user, HttpServletRequest request) {
        User user1 = (User)request.getSession().getAttribute("user");
        user.setUserId(user1.getUserId());
        ModelAndView mv = new ModelAndView("my_msg");
        if(user.getPwd()!=null&&!"".equals(user.getPwd())){
            mv.setViewName("redirect:/");
        }
        userService.updateUserBySelf(user);
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
    public PageInfo<AddPoint> getAddPoint(AddPoint addPoint,HttpServletRequest request,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        addPoint.setUserId(user.getUserId());
        List<AddPoint> list = studentService.getAddPoint(addPoint, pageNum, pageSize);
        PageInfo<AddPoint> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * Description 个人扣分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getDeletePoint")
    @ResponseBody
    public PageInfo<DeletePoint> getDeletePoint(DeletePoint deletePoint,HttpServletRequest request,
                                            @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "5") int pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        deletePoint.setUserId(user.getUserId());
        List<DeletePoint> list = studentService.getDeletePoint(deletePoint, pageNum, pageSize);
        PageInfo<DeletePoint> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * Description 个人惩罚信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getPunishList")
    @ResponseBody
    public PageInfo<Punish> getPunishList(Punish punish,HttpServletRequest request,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        punish.setUserId(user.getUserId());
        List<Punish> list = studentService.getPunishList(punish, pageNum, pageSize);
        PageInfo<Punish> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * Description 个人奖励信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getRewardList")
    @ResponseBody
    public PageInfo<Reward> getRewardList(Reward reward,HttpServletRequest request,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        reward.setUserId(user.getUserId());
        List<Reward> list = studentService.getRewardList(reward, pageNum, pageSize);
        PageInfo<Reward> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * Description 我的区队信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getUserTeam")
    @ResponseBody
    public Team getUserTeam(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return studentService.getUserTeam(user.getUserId());
    }

    /**
     * Description 打开所有区队信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/team_list")
    public ModelAndView teamList() {
        ModelAndView mv = new ModelAndView("team_list");
        return mv;
    }

    /**
     * Description 所有区队信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getTeamList")
    @ResponseBody
    public PageInfo<Team> getTeamList(@RequestParam(defaultValue = "")String qdmc,
                                      @RequestParam(defaultValue = "")String qdbm,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10") int pageSize) {
        Team team = new Team();
        team.setQdmc(qdmc);
        team.setQdbm(qdbm);
        List<Team> list = studentService.getTeamList(team,pageNum, pageSize);
        PageInfo<Team> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * Description 打开所有人信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/user_list")
    public ModelAndView userList(String userName,String userId,String qdbm,String qdmc) {
        ModelAndView mv = new ModelAndView("team_list");
        return mv;
    }

}
