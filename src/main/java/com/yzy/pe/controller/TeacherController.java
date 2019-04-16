package com.yzy.pe.controller;

import com.github.pagehelper.PageInfo;
import com.yzy.pe.entity.User;
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
    public PageInfo<User> getDeletePoint(User user,@RequestParam(defaultValue = "1") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize) {
        List<User> list = userService.selectUserList(user,pageNum,pageSize);
        return new PageInfo<>(list);
    }

    /**
     * Description 打开学生详情页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ModelAndView getUser(@RequestParam String userId) {
        ModelAndView mv = new ModelAndView("/teacher/user_msg");
        mv.addObject("userId",userId);
        return mv;
    }

    /**
     * Description 获取学生详情
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping(value = "/getUserMsg", method = RequestMethod.GET)
    public User getUserMsg(String userId) {
        User user = new User();
        user.setUserId(userId);
        User user1 = userService.selectUser(user);
        return user1;
    }

}
