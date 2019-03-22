package com.yzy.pe.mapper;

import com.yzy.pe.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description
 *
 * @author YanZiyi
 * @date 2019-03-21 10:46:50
 */
@Mapper
public interface UserMapper {

    /**
     * Description 登录
     *
     * @param user 用户
     * @return User
     * @author YanZiyi
     * @date 2019-03-20 16:29:47
     */
    User userLogin(User user);

    /**
     * Description 获取用户列表
     *
     * @return List<User>
     * @author YanZiyi
     * @date 2019-03-22 09:24:53
     */
    List<User> getUserList();

}
