package com.zjw.oa.controller;

import com.zjw.oa.dao.UserDao;
import com.zjw.oa.entity.User;
import com.zjw.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Description 用户登录
     *
     * @param model model
     * @return
     * @throws Exception
     * @author ZhengJiawei
     * @date 2019-03-20 15:53:42
     */
    @RequestMapping(value = "/login")
    public User hello(Model model) {
        User user1 = userService.getOne();
        model.addAttribute("user", user1);
        return user1;
    }
}
