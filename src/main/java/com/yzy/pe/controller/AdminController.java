package com.yzy.pe.controller;

import com.yzy.pe.entity.User;
import com.yzy.pe.entity.WeakCheck;
import com.yzy.pe.entity.dto.NameValueDto;
import com.yzy.pe.service.AdminService;
import com.yzy.pe.service.UserService;
import com.yzy.pe.util.DateUtil;
import com.yzy.pe.util.ImportExcelUtil;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
     * 导入
     * @param myFile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method=RequestMethod.POST)
    public ModelAndView importFile(@RequestParam(value="file",required=false)MultipartFile myFile) throws IOException {
        try {
            ImportExcelUtil util = new ImportExcelUtil();
            InputStream input;
            List<List<Object>> lists;
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
        return new ModelAndView("/teacher/all_user");
    }


    /**
     * 导出
     */
    @RequestMapping(value = "/export")
    public void exportallDocumentaryExcel(HttpServletResponse response) throws IOException {
        try {
                List<User> userList = userService.selectUserList();
                // 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
                // 内存中保留 10000 条数据，以免内存溢出，其余写入 硬盘
                SXSSFWorkbook workbook = new SXSSFWorkbook(10000);
                CellStyle style = workbook.createCellStyle();
                style.setAlignment(XSSFCellStyle.ALIGN_CENTER);//SXSSFWorkbook方式的居中
                // 创建一个sheet页
                SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet("销售订单");
                // 分别设置Excel列的宽度

                for(int i=0;i<10;i++){
                    sheet.setColumnWidth(i, 4000);
                }
                // 创建标题
                SXSSFRow headRow = (SXSSFRow) sheet.createRow(0);
                headRow.createCell(0).setCellValue("学号");
                headRow.createCell(1).setCellValue("姓名");
                headRow.createCell(2).setCellValue("密码");
                headRow.createCell(3).setCellValue("权限");
                headRow.createCell(4).setCellValue("区队编码");
                headRow.createCell(5).setCellValue("考评分数");
                headRow.createCell(6).setCellValue("手机号码");
                headRow.createCell(7).setCellValue("邮箱");
                headRow.createCell(8).setCellValue("寝室号码");
                headRow.createCell(9).setCellValue("性别");

                for (User user : userList) {
                    // 创建行
                    SXSSFRow dataRow = (SXSSFRow) sheet.createRow(sheet.getLastRowNum() + 1);

                    dataRow.createCell(0).setCellValue(user.getUserId());
                    dataRow.createCell(1).setCellValue(user.getUserName());
                    dataRow.createCell(2).setCellValue(user.getPwd());
                    dataRow.createCell(3).setCellValue(user.getPermissionDegree());
                    dataRow.createCell(4).setCellValue(user.getQdbm());
                    dataRow.createCell(5).setCellValue(user.getKpfs());
                    dataRow.createCell(6).setCellValue(user.getPhone());
                    dataRow.createCell(7).setCellValue(user.getEmail());
                    dataRow.createCell(8).setCellValue(user.getQshm());
                    dataRow.createCell(9).setCellValue(user.getXb());
                }

                // 设置Excel文件名，并以中文进行编码
                String codedFileName = new String("学生列表".getBytes("gbk"), "iso-8859-1");
                response.setHeader("Content-Disposition", "attachment;filename="
                        + codedFileName + DateUtil.getCurrentTime2()
                        +".xlsx");
                // 响应类型,编码
                response.setContentType("application/octet-stream;charset=UTF-8");
                // 形成输出流
                OutputStream osOut = response.getOutputStream();
                // 将指定的字节写入此输出流
                workbook.write(osOut);
                // 刷新此输出流并强制将所有缓冲的输出字节被写出
                osOut.flush();
                // 关闭流
                osOut.close();
                /*
                 * dispose of temporary files backing this workbook on disk
                 * 处理在磁盘上备份此工作簿的临时文件 SXSSF分配临时文件，必须始终清除显式，通过调用dispose方法
                 */
                workbook.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println( "导出用户失败！失败信息："+e.getMessage());
        }
    }

}
