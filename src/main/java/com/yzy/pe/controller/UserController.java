package com.yzy.pe.controller;

import com.yzy.pe.entity.Permission;
import com.yzy.pe.entity.User;
import com.yzy.pe.service.UserService;
import org.apache.catalina.connector.Request;
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
    public ModelAndView login(User user) {
        User user1 = userService.login(user);
        ModelAndView mv = new ModelAndView("login");
        if (user1 == null) {
            return mv;
        }else if(user1.getPermissionDegree()==3){
            mv.setViewName("index");
            mv.addObject("user",user1);
            return mv;
        }else if (user1.getPermissionDegree()==1){
            mv.setViewName("/admin/admin");
            mv.addObject("user",user1);
            return mv;
        }else if(user1.getPermissionDegree()==2){
            mv.setViewName("/teacher/teacher");
            mv.addObject("user",user1);
            return mv;
        }else{
            return mv;
        }
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
    public List<Permission> getPerList(Request request,
                                       @RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        User user = (User) request.getSession().getAttribute("user");
        return userService.getPerList(user.getPermissionDegree(), pageNum, pageSize);
    }

}
