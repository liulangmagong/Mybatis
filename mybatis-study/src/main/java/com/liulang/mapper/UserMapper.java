package com.liulang.mapper;

import com.liulang.pojo.User;

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
     * 根据ID获取用户名
     * 这里传入的是一个参数
     * @param id
     * @return
     */
    String getUserNameById(int id);

    /**
     * 根据ID获取用户名
     * @return
     */
    List<String> getUserName();

    /**
     * 插入一个用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 功能依旧插入一个用户
     * 特点是：使用万能Map
     * 为什么要使用万能的map:
     *      主要是如果一个实体类的字段非常多，那么在更新或者插入的时候，总不能把每一个字段
     *      都在sql中罗列出来。
     *      好处是，我不需要知道数据库中有什么，要操作哪些字段，我们只需要去map查对应字段的值
     *      在sql中进行赋值即可
     * @param map
     * @return
     */
    int addUser2(Map<String, Object> map);

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

    /**
     * 模糊查询
     * @return
     */
    List<User> getUserLike(String value);
}
