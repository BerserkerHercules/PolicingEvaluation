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
     * @return Result
     * @author YanZiyi
     * @date 2019-03-21 09:06:08
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user, HttpServletRequest request) {

        User user1 = userService.login(user);
        if (user1 == null) {
            return "login";
        }

        List<Permission> permissionList = userService.getPerList(user1.getPermissionDegree());

        request.getSession().setAttribute("user",user1);
        return "index";
    }

    /**
     * Description 获取用户列表
     *
     * @author YanZiyi
     * @date 2019-03-22 10:50:47
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView getUserList() {
        ModelAndView mav = new ModelAndView("index1");

        mav.addObject("userList", userService.getUserList());

        return mav;
    }

}