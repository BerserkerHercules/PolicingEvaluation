package com.yzy.pe.controller;

import com.yzy.pe.entity.User;
import com.yzy.pe.entity.WeakCheck;
import com.yzy.pe.entity.dto.NameValueDto;
import com.yzy.pe.service.AdminService;
import com.yzy.pe.service.UserService;
import com.yzy.pe.util.ImportExcelUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
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

    @Resource
    private UserService userService;

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
    public Map<String, List> initSelect() {
        return adminService.initSelect();
    }

    @RequestMapping("/getWeekCheck2")
    @ResponseBody
    public List<WeakCheck> getWeekCheck2() {
        return adminService.getWeek2();
    }

    @RequestMapping("/getWeekData")
    @ResponseBody
    public Map<String, List> getWeekData(String xqs, String weekNum, String qdbm) {
        return adminService.getWeekData(xqs, weekNum, qdbm);
    }

    @RequestMapping("/getWeekData2")
    @ResponseBody
    public Map<String, List> getWeekData2(String xqs, String weekNum) {
        return adminService.getWeekData2(xqs, weekNum);
    }

    /**
     * Description 扣分占比
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getWeekData3")
    @ResponseBody
    public List<NameValueDto> getWeekData3(String xqs, String weekNum, String qdbm) {
        return adminService.getWeekData3(xqs, weekNum, qdbm);
    }

    /**
     * Description 扣分占比
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/getWeekData4")
    @ResponseBody
    public List<NameValueDto> getWeekData4(String xqs, String weekNum) {
        return adminService.getWeekData4(xqs, weekNum);
    }

    /**
     * Description 人数
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/stuCount")
    @ResponseBody
    public List<String> stuCount() {
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

    /**
     * Description 打开批量导入页面
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    @RequestMapping("/initUpload")
    public ModelAndView initUpload() {
        ModelAndView mv = new ModelAndView("/admin/upload");
        return mv;
    }

    /**
     * 导入销售订单数据
     * @param myFile
     * @param respon
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method=RequestMethod.POST)
    public String importFile(@RequestParam(value="file",required=false)MultipartFile myFile, HttpServletResponse respon, RedirectAttributes redirectAttributes)
            throws IOException {
        try {
            //先删除数据库原有的数据
            //orderexcelService.deleteAll(order);
            ImportExcelUtil util = new ImportExcelUtil();
            InputStream input = null;
            List<List<Object>> lists = null;
            if (myFile.isEmpty()) {
                System.out.println("导入文件为空");
            } else {
                String fileName = myFile.getOriginalFilename();
                input = myFile.getInputStream();
                lists = util.getBankListByExcel(input, fileName);
                input.close();
                // 循环将excel中的数据存入库
                for (int i = 1; i < lists.size(); i++) {
                    List<Object> list = lists.get(i);
                    User users = new User();
                    users.setUserId(util.getFormat(String.valueOf(list.get(0))));
                    users.setUserName(util.getFormat(String.valueOf(list.get(1))));
                    users.setPwd(util.getFormat(String.valueOf(list.get(2))));
                    users.setPermissionDegree(Long.parseLong(util.getFormat(String.valueOf(list.get(3)))));
                    users.setQdbm(util.getFormat(String.valueOf(list.get(4))));
                    users.setKpfs(Double.parseDouble(util.getFormat(String.valueOf(list.get(5)))));
                    users.setPhone(util.getFormat(String.valueOf(list.get(6))));
                    users.setEmail(util.getFormat(String.valueOf(list.get(7))));
                    users.setQshm(util.getFormat(String.valueOf(list.get(8))));
                    users.setXb(util.getFormat(String.valueOf(list.get(9))));

                    userService.save(users);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("导入出错");
        }
        return "/teacher/all_user";
    }

}
