package com.yzy.pe.service;

import com.yzy.pe.entity.*;

import java.util.List;

/**
 * @author YanZiyi
 * @create 2019-03-29 9:50
 */
public interface StudentService {

    /**
     * Description 个人加分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    List<AddPoint> getAddPoint(AddPoint addPoint, int pageNum, int pageSize);

    /**
     * Description 个人扣分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    List<DeletePoint> getDeletePoint(DeletePoint deletePoint, int pageNum, int pageSize);

    /**
     * Description 个人惩罚信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    List<Punish> getPunishList(Punish punish, int pageNum, int pageSize);

    /**
     * Description 个人奖励信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    List<Reward> getRewardList(Reward reward, int pageNum, int pageSize);

    /**
     * Description 我的区队信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    Team getUserTeam(String userId);

    /**
     * Description 区队扣分信息
     *
     * @author YanZiyi
     * @date 2019-03-29 09:43:49
     */
    List<DeletePoint> getTeamDeletePoint(DeletePoint deletePoint, int pageNum, int pageSize);

}
