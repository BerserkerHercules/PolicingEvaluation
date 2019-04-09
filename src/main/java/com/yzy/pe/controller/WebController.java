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

    @RequestMapping(value = "/forms")
    public String forms() {
        return "forms";
    }

    @RequestMapping(value = "/tables")
    public String tables() {
        return "tables";
    }

    @RequestMapping(value = "/tabs")
    public String tabs() {
        return "tabs";
    }

    @RequestMapping(value = "/invoice")
    public String invoice() {
        return "invoice";
    }

    @RequestMapping(value = "/modals")
    public String modals() {
        return "modals";
    }

    @RequestMapping(value = "/widgets")
    public String widgets() {
        return "widgets";
    }

    @RequestMapping(value = "/buttons")
    public String buttons() {
        return "buttons";
    }

    @RequestMapping(value = "/alerts")
    public String alerts() {
        return "alerts";
    }

    @RequestMapping(value = "/settings")
    public String settings() {
        return "settings";
    }

    @RequestMapping(value = "/progressBars")
    public String progressBars() {
        return "progress-bars";
    }

    @RequestMapping(value = "/cards")
    public String cards() {
        return "cards";
    }

    @RequestMapping(value = "/layoutsFixedHeader")
    public String layoutsFixedHeader() {
        return "layouts-fixed-header";
    }

    @RequestMapping(value = "/layoutsFixedSidebar")
    public String layoutsFixedSidebar() {
        return "layouts-fixed-sidebar";
    }

    @RequestMapping(value = "/layoutsHiddenSidebar")
    public String layoutsHiddenSidebar() {
        return "layouts-hidden-sidebar";
    }

    @RequestMapping(value = "/layoutsNormal")
    public String layoutsNormal() {
        return "layouts-normal";
    }

}
