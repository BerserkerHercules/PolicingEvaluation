package com.yzy.pe.service.impl;

import com.yzy.pe.entity.WeakCheck;
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
    public List<WeakCheck> getWeek2() {
        return adminMapper.getWeek2();
    }

    @Override
    public Map<String, List> getWeekData() {
        List<String> weekList = DateUtil.getLastWeekDays();
        List<TeamDelDto> dataList = adminMapper.getWeekData(weekList.get(0), weekList.get(weekList.size() - 1));
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
    public Map<String, List> getWeekData2() {
        List<String> weekList = DateUtil.getLastWeekDays();
        List<TeamDelDto> dataList = adminMapper.getWeekData2(weekList.get(0), weekList.get(weekList.size() - 1));
        //List<WeakCheck> checkList = adminMapper.getWeek2();
        List<TeamDelDto> dtoList = new ArrayList<>();
        weekList.forEach(e -> {
            for (TeamDelDto t : dataList) {
                if (e.equals(DateUtil.dateToString(t.getKfTime(),"yyyy-MM-dd"))) {
                    dtoList.add(t);
                    break;
                }
            }
        });
        Map<String, List> maps = new HashMap<>();
        maps.put("checkList", weekList);
        maps.put("dataList", dtoList);
        return maps;
    }

}
