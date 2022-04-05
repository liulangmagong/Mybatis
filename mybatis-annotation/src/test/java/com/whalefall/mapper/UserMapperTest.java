package com.whalefall.mapper;

import com.whalefall.pojo.User;
import com.whalefall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author wangshiyang
 * @since 2022/4/1
 **/
public class UserMapperTest {

    /**
     * searchAllTest
     */
    @Test
    public void searchAllTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            userList.forEach(System.out::println);
        }
    }

    /**
     * searchOneByIdTest
     */
    @Test
    public void searchOneByIdTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1, "狂神");
            System.out.println(user);
        }
    }

    /**
     * 测试注解插入数据
     * 核心配置文件中设置了自动提交事务，这里不需要进行手动提交事务即可成功
     */
    @Test
    public void addUserTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.addUser(new User(6, "小lv", "12345"));
        }

    }

    /**
     * 测试注解更新数据
     * 核心配置文件中设置了自动提交事务，这里不需要进行手动提交事务即可成功
     */
    @Test
    public void updateUserTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(5, "小红", "12343335"));
        }

    }

    /**
     * 测试注解删除数据
     *
     */
    @Test
    public void deleteUserTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUser(6);
        }
    }
}
