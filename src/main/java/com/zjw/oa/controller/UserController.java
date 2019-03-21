package com.zjw.oa.controller;

import com.zjw.oa.entity.User;
import com.zjw.oa.entity.pojo.VueLoginInfoVo;
import com.zjw.oa.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
     * Description 登录控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。
     *
     * @param loginInfoVo   给VueLoginInfoVo对象加入@Valid注解
     * @param bindingResult 在参数中加入BindingResult来获取错误信息，判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
     * @return Result
     * @author ZhengJiawei
     * @date 2019-03-21 09:06:08
     */
    //@CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("test");
        if (bindingResult.hasErrors()) {
            return mav;
        }

        User user = new User();
        user.setUserId(loginInfoVo.getUserId());
        user.setPwd(loginInfoVo.getPassword());
        User user1 = userService.login(user);
        mav.addObject("user",user1);

        return mav;
    }
}
