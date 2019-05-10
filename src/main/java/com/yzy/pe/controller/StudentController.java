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
    @RequestMapping(value = "/getMyName")
    public User getMyName(String userId) {
        User user = new User();
        user.setUserId(userId);
        User user1 = userService.selectUser(user);
        return user1;
    }

    /**
     * Description 打开我的个人信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/getMyMsg",method = RequestMethod.GET)
    public ModelAndView getMyMsg(String userId) {
        ModelAndView mv = new ModelAndView("my_msg");
        User user = new User();
        user.setUserId(userId);
        User user1 = userService.selectUser(user);
        mv.addObject("user",user1);
        return mv;
    }

    /**
     * Description 打开我的考评信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/myKp",method = RequestMethod.GET)
    public ModelAndView myKp(String userId) {
        ModelAndView mv = new ModelAndView("my_kp");
        mv.addObject("userId",userId);
        return mv;
    }

    /**
     * Description 打开修改个人信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/change_msg")
    public ModelAndView change_msg(String userId,String userName) {
        ModelAndView mv = new ModelAndView("change_msg");
        mv.addObject("userId",userId);
        mv.addObject("userName",userName);
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
    public ModelAndView changeMyMsg(User user) {
        ModelAndView mv = new ModelAndView("redirect:/student/getMyMsg?userId="+user.getUserId());
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
    public PageInfo<AddPoint> getAddPoint(String addDesc,String userId,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        AddPoint addPoint = new AddPoint();
        addPoint.setAddDesc(addDesc);
        addPoint.setUserId(userId);
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
    public PageInfo<DeletePoint> getDeletePoint(String deleteDesc,String userId,
                                            @RequestParam(defaultValue = "1") int pageNum,
                                            @RequestParam(defaultValue = "5") int pageSize) {

        DeletePoint deletePoint = new DeletePoint();
        deletePoint.setUserId(userId);
        deletePoint.setDeleteDesc(deleteDesc);
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
    public PageInfo<Punish> getPunishList(String punishReason,String userId,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        Punish punish = new Punish();
        punish.setPunishReason(punishReason);
        punish.setUserId(userId);
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
    public PageInfo<Reward> getRewardList(String rewardReason,String userId,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "5") int pageSize) {
        Reward reward = new Reward();
        reward.setRewardReason(rewardReason);
        reward.setUserId(userId);
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
