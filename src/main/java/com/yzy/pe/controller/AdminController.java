package com.yzy.pe.controller;

import com.yzy.pe.entity.WeakCheck;
import com.yzy.pe.entity.dto.NameValueDto;
import com.yzy.pe.service.AdminService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @RequestMapping("/initSelect")
    @ResponseBody
    public Map<String ,List> initSelect(){
        return adminService.initSelect();
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

    /**
     * Description 扣分占比
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getWeekData3")
    @ResponseBody
    public List<NameValueDto> getWeekData3(){
        return adminService.getWeekData3();
    }

    /**
     * Description 扣分占比
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getWeekData4")
    @ResponseBody
    public List<NameValueDto> getWeekData4(){
        return adminService.getWeekData4();
    }

    /**
     * Description 人数
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/stuCount")
    @ResponseBody
    public List<String> stuCount(){
        String qrrkCount = adminService.stuCount();
        List<String> countList = new ArrayList<>();
        if (!StringUtils.isEmpty(qrrkCount)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5 - qrrkCount.length(); i++) {
                sb.append("0");
            }
            sb.append(qrrkCount);
            String qrrkStr = sb.toString();
            countList.add(qrrkStr.substring(4, 5));
            countList.add(qrrkStr.substring(3, 4));
            countList.add(qrrkStr.substring(2, 3));
            countList.add(qrrkStr.substring(1, 2));
            countList.add(qrrkStr.substring(0, 1));
        }
        return countList;
    }

}
