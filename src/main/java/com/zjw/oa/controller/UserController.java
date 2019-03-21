package com.zjw.oa.controller;

import com.zjw.oa.entity.User;
import com.zjw.oa.entity.pojo.VueLoginInfoVo;
import com.zjw.oa.result.Result;
import com.zjw.oa.result.ResultFactory;
import com.zjw.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @Autowired
    private UserService userService;

    /**
     * Description 登录控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。
     *
     * @param loginInfoVo   给VueLoginInfoVo对象加入@Valid注解
     * @param bindingResult 在参数中加入BindingResult来获取错误信息，判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
     * @return Result
     * @throws Exception
     * @author ZhengJiawei
     * @date 2019-03-21 09:06:08
     */
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }

        User user = new User();
        user.setUserId(loginInfoVo.getUserId());
        user.setPwd(loginInfoVo.getPassword());
        User user1 = userService.login(user);


        if (user1 == null) {
            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
            return ResultFactory.buildFailResult(message);
        }
        return ResultFactory.buildSuccessResult("登陆成功。");
    }
}
