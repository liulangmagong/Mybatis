package com.whalefall.mapper;

import com.whalefall.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangshiyang
 * @since 2022/4/5
 **/
public interface UserMapper {

    /**
     * 根据id查询用户
     */
    User queryUserById(@Param("id") int id);

    /**
     * 更新用户信息
     */
    int updateUser(User user);
}
