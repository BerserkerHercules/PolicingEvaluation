package com.yzy.pe.mapper;

import com.yzy.pe.entity.AddPoint;
import com.yzy.pe.entity.DeletePoint;

import java.util.List;

/**
 * 学生mapper
 *
 * @author YanZiyi
 * @create 2019-03-29 9:43
 */
public interface StudentMapper {

    /**
     * Description 个人加分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    List<AddPoint> getAddPoint(AddPoint addPoint);

    /**
     * Description 个人扣分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    List<DeletePoint> getDeletePoint(DeletePoint deletePoint);
}
