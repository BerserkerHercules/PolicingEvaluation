package com.yzy.pe.mapper;

import com.yzy.pe.entity.AddPoint;
import com.yzy.pe.entity.DeletePoint;
import com.yzy.pe.entity.Punish;
import com.yzy.pe.entity.Reward;

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

    /**
     * Description 个人惩罚信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    List<Punish> getPunishList(Punish punish);

    /**
     * Description 个人奖励信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    List<Reward> getRewardList(Reward reward);

}
