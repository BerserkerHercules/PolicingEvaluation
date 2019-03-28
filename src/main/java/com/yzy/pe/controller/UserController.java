package com.yzy.pe.controller;

import com.yzy.pe.entity.Permission;
import com.yzy.pe.entity.User;
import com.yzy.pe.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Description user
 *
 * @author YanZiyi
 * @date 2019-03-21 10:49:24
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * Description 登录，可以加入 @CrossOrigin 支持跨域。
     *
     * @param user 用户输入的学号和密码
     * @return String
     * @author YanZiyi
     * @date 2019-03-21 09:06:08
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        User user1 = userService.login(user);
        if (user1 == null) {
            return "login";
        }
        request.getSession().setAttribute("user", user1);
        return "index";
    }

    /**
     * Description 权限列表
     *
     * @param request 请求
     * @return List<Permission>
     * @author YanZiyi
     * @date 2019-03-21 09:06:08
     */
    @RequestMapping(value = "/getPerList", method = RequestMethod.POST)
    @ResponseBody
    public List<Permission> getPerList(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Permission> permissionList = userService.getPerList(user.getPermissionDegree());
        return permissionList;
    }

    /**
     * Description 获取学生列表
     *
     * @author YanZiyi
     * @date 2019-03-22 10:50:47
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public List<User> getUserList() {
        return userService.getUserList();
    }

    /**
     * Description 获取个人信息
     *
     * @author ZhengJiawei
     * @date 2019-03-28 16:29:17
     */
    @RequestMapping(value = "/getUserMsg", method = RequestMethod.POST)
    @ResponseBody
    public User getUserMsg(User user) {
        return userService.getUserMsg(user);
    }

}
