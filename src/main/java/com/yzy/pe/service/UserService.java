package com.yzy.pe.service;

import com.yzy.pe.entity.Advice;
import com.yzy.pe.entity.Permission;
import com.yzy.pe.entity.User;

import java.util.List;

/**
 * Description 用户service层
 *
 * @author YanZiyi
 * @date 2019-03-21 10:47:26
 */
public interface UserService {

    /**
     * Description 登录
     *
     * @param user 用户输入数据
     * @return User
     * @author YanZiyi
     * @date 2019-03-22 14:14:27
     */
    User login(User user);

    /**
     * Description 用户列表
     *
     * @return List<User>
     * @author YanZiyi
     * @date 2019-03-22 14:15:14
     */
    List<User> getUserList();

    /**
     * Description 权限列表
     *
     * @author YanZiyi
     * @date 2019-03-28 11:02:17
     */
    List<Permission> getPerList(String permissionDegree);

    /**
     * Description 建议列表
     *
     * @author YanZiyi
     * @date 2019-03-28 11:02:17
     */
    List<Advice> getAdviceList(Advice advice);

    /**
     * Description 提交建议
     *
     * @author YanZiyi
     * @date 2019-03-28 11:02:17
     */
    void orderAdvice(Advice advice);

    /**
     * Description 审阅建议
     *
     * @author YanZiyi
     * @date 2019-03-28 11:02:17
     */
    void reviewAdvice(Advice advice);

    /**
     * Description 添加用户
     *
     * @author YanZiyi
     * @date 2019-03-28 11:02:17
     */
    void addUser(User user);

    /**
     * Description 修改用户
     *
     * @author YanZiyi
     * @date 2019-03-28 11:02:17
     */
    void updateUser(User user);

    /**
     * Description 删除用户
     *
     * @author YanZiyi
     * @date 2019-03-28 11:02:17
     */
    void deleteUser(User user);

    /**
     * Description 获取个人信息
     *
     * @author ZhengJiawei
     * @date 2019-03-28 16:29:17
     */
    User getUserMsg(User user);
}
