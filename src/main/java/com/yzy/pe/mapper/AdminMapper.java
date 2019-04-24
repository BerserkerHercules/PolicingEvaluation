package com.yzy.pe.mapper;

import com.yzy.pe.entity.WeakCheck;
import com.yzy.pe.entity.dto.TeamDelDto;

import java.util.List;

/**
 * 学生mapper
 *
 * @author YanZiyi
 * @create 2019-03-29 9:43
 */
public interface AdminMapper {

    List<String> initSelect1();

    List<String> initSelect2();

    List<WeakCheck> getWeek2();

    List<String> weekList(String date1, String date2);

    List<TeamDelDto> getWeekData(String date1, String date2);

    List<TeamDelDto> getWeekData2(String date1, String date2);

    String stuCount();

}
