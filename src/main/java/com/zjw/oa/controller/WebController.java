package com.zjw.oa.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class WebController {

    /**
     * Description 跳转登录
     *
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-20 16:28:37
     */
    @RequestMapping(value = "/")
    public String index() {
        return "login";
    }

}
