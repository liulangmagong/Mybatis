package com.whalefall.mapper;

import com.whalefall.pojo.User;

import java.util.List;

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
}
