package com.yzy.pe.service;

import com.yzy.pe.entity.WeakCheck;
import com.yzy.pe.entity.dto.NameValueDto;

import java.util.List;
import java.util.Map;

/**
 * @author YanZiyi
 * @create 2019-03-29 9:50
 */
public interface AdminService {

    List<WeakCheck> getWeek2();

    Map<String,List> getWeekData();

    Map<String,List> getWeekData2();

    List<NameValueDto> getWeekData3();

    List<NameValueDto> getWeekData4();

}
