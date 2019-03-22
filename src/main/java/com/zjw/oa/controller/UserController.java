package com.zjw.oa.controller;

import com.zjw.oa.entity.User;
import com.zjw.oa.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:49:24
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * Description 登录控制器，前后端分离用的不同协议和端口，可以加入@CrossOrigin支持跨域。
     *
     * @param user   user
     * @param bindingResult 在参数中加入BindingResult来获取错误信息，判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
     * @return Result
     * @author ZhengJiawei
     * @date 2019-03-21 09:06:08
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(User user, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("login");
        if (bindingResult.hasErrors()) {
            return mav;
        }

        User user1 =  userService.login(user);
        if(user1==null){
            mav.setViewName("login");
            return mav;
        }
        mav.setViewName("index");
        mav.addObject("user",user1);

        return mav;
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView getUserList() {
        ModelAndView mav = new ModelAndView("index1");

        mav.addObject("userList",userService.getUserList());

        return mav;
    }

}
