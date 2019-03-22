package com.yzy.pe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description
 *
 * @author YanZiyi
 * @date 2019-03-21 10:48:11
 */
@Controller
public class WebController {

    /**
     * Description 跳转登录
     *
     * @return String
     * @author YanZiyi
     * @date 2019-03-20 16:28:37
     */
    @RequestMapping(value = "/")
    public String index() {
        return "login";
    }

}
