package com.yzy.pe.service.impl;

import com.yzy.pe.entity.WeakCheck;
import com.yzy.pe.entity.dto.NameValueDto;
import com.yzy.pe.entity.dto.TeamDelDto;
import com.yzy.pe.mapper.AdminMapper;
import com.yzy.pe.service.AdminService;
import com.yzy.pe.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YanZiyi
 * @create 2019-03-29 9:50
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Map<String, List> initSelect() {
        Map<String, List> list = new HashMap<>(3);
        list.put("xqs", adminMapper.initSelect1());
        list.put("weekNum", adminMapper.initSelect2());
        list.put("qdList", adminMapper.allTeam());
        return list;
    }

    @Override
    public List<WeakCheck> getWeek2() {
        return adminMapper.getWeek2();
    }

    @Override
    public Map<String, List> getWeekData(String xqs, String weekNum, String qdbm) {

        List<TeamDelDto> dataList = adminMapper.getWeekData(xqs, weekNum, qdbm);
        List<WeakCheck> checkList = adminMapper.getWeek2();
        List<TeamDelDto> dtoList = new ArrayList<>();
        checkList.forEach(e -> {
            for (TeamDelDto t : dataList) {
                if (e.getCheckId() == t.getCheckId()) {
                    dtoList.add(t);
                    break;
                }
            }
        });
        Map<String, List> maps = new HashMap<>();
        maps.put("checkList", checkList);
        maps.put("dataList", dtoList);
        return maps;
    }

    @Override
    public Map<String, List> getWeekData2(String xqs, String weekNum) {

        List<String> weekList = adminMapper.weekList(xqs, weekNum);
        List<TeamDelDto> dataList = adminMapper.getWeekData2(xqs, weekNum);
        List<TeamDelDto> dtoList = new ArrayList<>();
        weekList.forEach(e -> {
            TeamDelDto dto = new TeamDelDto();
            java.sql.Date sqlDate = new java.sql.Date(DateUtil.stringToDate(e, "yyyy-MM-dd").getTime());
            dto.setKfTime(sqlDate);
            dto.setCountTeam(0);
            for (TeamDelDto t : dataList) {
                if (e.equals(DateUtil.dateToString(t.getKfTime(), "yyyy-MM-dd"))) {
                    dto.setCountTeam(t.getCountTeam());
                    break;
                }
            }
            dtoList.add(dto);
        });
        Map<String, List> maps = new HashMap<>();
        maps.put("checkList", weekList);
        maps.put("dataList", dtoList);
        return maps;
    }

    @Override
    public List<NameValueDto> getWeekData3(String xqs, String weekNum, String qdbm) {
        List<TeamDelDto> dataList = adminMapper.getWeekData(xqs, weekNum, qdbm);
        List<WeakCheck> checkList = adminMapper.getWeek2();
        List<NameValueDto> dtoList = new ArrayList<>();
        checkList.forEach(e -> {
            for (TeamDelDto t : dataList) {
                NameValueDto dto = new NameValueDto();
                if (e.getCheckId() == t.getCheckId()) {
                    dto.setName(e.getCheckName());
                    dto.setValue(t.getCountTeam().toString());
                    dtoList.add(dto);
                    break;
                }
            }
        });
        return dtoList;
    }

    @Override
    public List<NameValueDto> getWeekData4(String xqs, String weekNum) {
        List<String> weekList = adminMapper.weekList(xqs, weekNum);
        List<TeamDelDto> dataList = adminMapper.getWeekData2(xqs, weekNum);

        List<NameValueDto> dtoList = new ArrayList<>();
        weekList.forEach(e -> {
            for (TeamDelDto t : dataList) {
                NameValueDto dto = new NameValueDto();
                if (e.equals(DateUtil.dateToString(t.getKfTime(), "yyyy-MM-dd"))) {
                    dto.setName(e);
                    dto.setValue(t.getCountTeam().toString());
                    dtoList.add(dto);
                    break;
                }
            }
        });
        return dtoList;
    }

    @Override
    public String stuCount() {
        return adminMapper.stuCount();
    }
}
