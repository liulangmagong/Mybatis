package com.whalefall.mapper;

import com.whalefall.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author wangshiyang
 * @since 2022/4/1
 **/
public interface UserMapper {

    /**
     * 获取全部用户
     * @return
     */
    List<User> getUserList();

    /**
     * 根据ID获取用户
     * @param id
     * @return
     */
    User getUserById(int id);


    /**
     * 插入一个用户
     * @param user
     * @return
     */
    int addUser(User user);


    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(int id);

}
