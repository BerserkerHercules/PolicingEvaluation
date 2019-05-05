package com.yzy.pe.service;

import com.yzy.pe.entity.AddPoint;
import com.yzy.pe.entity.DeletePoint;
import com.yzy.pe.entity.Punish;
import com.yzy.pe.entity.Reward;

/**
 * @author YanZiyi
 * @create 2019-03-29 9:50
 */
public interface TeacherService {

    String haveId(String id);

    void kpAdd(AddPoint addPoint)throws Exception;

    void kpDel(DeletePoint deletePoint)throws Exception;

    void kpReward(Reward reward)throws Exception;

    void kpPunish(Punish punish)throws Exception;

}
