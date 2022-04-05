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
     * 根据ID获取用户
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 通过分页查询，查询用户
     * 这里使用的依旧使用万能的Map传入分页查询的参数
     * @param map
     * @return
     */
    List<User> getUserByLimit(Map<String, Integer> map);


}
