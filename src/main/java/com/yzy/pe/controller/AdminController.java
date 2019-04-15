package com.yzy.pe.controller;

import com.yzy.pe.entity.WeakCheck;
import com.yzy.pe.service.AdminService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Description user
 *
 * @author YanZiyi
 * @date 2019-03-21 10:49:24
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * Description 打开周信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/week")
    public ModelAndView week() {
        ModelAndView mv = new ModelAndView("/admin/week");
        return mv;
    }

    /**
     * Description 打开学期信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/term")
    public ModelAndView term() {
        ModelAndView mv = new ModelAndView("/admin/term");
        return mv;
    }

    /**
     * Description 打开年度信息页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/year")
    public ModelAndView year() {
        ModelAndView mv = new ModelAndView("/admin/year");
        return mv;
    }

    @RequestMapping("/getWeekCheck2")
    @ResponseBody
    public List<WeakCheck> getWeekCheck2(){
        return adminService.getWeek2();
    }

    @RequestMapping("/getWeekData")
    @ResponseBody
    public Map<String,List> getWeekData(){
        return adminService.getWeekData();
    }

    @RequestMapping("/getWeekData2")
    @ResponseBody
    public Map<String,List> getWeekData2(){
        return adminService.getWeekData2();
    }

    @RequestMapping("/getWeekData3")
    @ResponseBody
    public Map<String,List> getWeekData3(){
        return adminService.getWeekData2();
    }

}
