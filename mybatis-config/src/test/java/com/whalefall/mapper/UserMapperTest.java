package com.whalefall.mapper;

import com.whalefall.pojo.User;
import com.whalefall.utils.MybatisUtils;
import com.whalefall.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshiyang
 * @since 2022/4/1
 **/
public class UserMapperTest {

    @Test
    public void test() {

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            userList.forEach(System.out::println);
        }
    }


}
