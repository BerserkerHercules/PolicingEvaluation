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

    Map<String, List> initSelect();

    List<WeakCheck> getWeek2();

    Map<String, List> getWeekData(String xqs, String weekNum, String qdbm);

    Map<String, List> getWeekData2(String xqs, String weekNum);

    List<NameValueDto> getWeekData3(String xqs, String weekNum, String qdbm);

    List<NameValueDto> getWeekData4(String xqs, String weekNum);

    String stuCount();

}
