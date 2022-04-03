package com.liulang.mapper;

import com.liulang.pojo.User;
import com.liulang.utils.MybatisUtils;
import org.apache.ibatis.annotations.Param;
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
        // 第一步 获取sqlSession对象 这样的写法，可以确保每次写完后sqlSession的关闭
        // 官方要求写法
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            // 执行sql  对应的就是注解注入接口的过程
            // 方式一：获取到对应的mapper，然后使用mapper调用方法即可
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 根据注入的接口调用方法
            List<User> userList = userMapper.getUserList();
            userList.forEach(System.out::println);
        }
    }

    @Test
    public void test2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);
            System.out.println(user);
        }
    }

    @Test
    public void test3() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            String name = userMapper.getUserNameById(1);
            System.out.println(name);
        }
    }

    /**
     * 查询所有的名字
     */
    @Test
    public void test4() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<String> names = userMapper.getUserName();
            System.out.println(names);
        }
    }

    /**
     * 插入用户
     * 增删改需要提交事务!!!
     * 这里的sqlSession基本上可以做任何相关的事情
     */
    @Test
    public void addUserTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(5);
            user.setName("哈哈5");
            user.setPwd("123335");
            int res = mapper.addUser(user);
            if (res > 0) {
                System.out.println("插入成功！");
            }
            sqlSession.commit();
        }
    }

    /**
     * 使用万能map添加数据
     */
    @Test
    public void addUserTest2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("userId", 5);
            map.put("userName", "huhu");
            map.put("userPwd", "123455");
            int res = mapper.addUser2(map);
            if (res > 0){
                System.out.println("插入成功！！");
            }

            sqlSession.commit();
        }
    }


    /**
     * 更新用户数据
     */
    @Test
    public void updateTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res = mapper.updateUser(new User(4, "xiao", "12222"));
            if (res > 0) {
                System.out.println("更新成功！！");
            }
            // 增删改务必提交数据
            sqlSession.commit();
        }
    }

    /**
     * 测试删除用户
     */
    @Test
    public void deleteTest() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res = mapper.deleteUser(4);
            if (res > 0) {
                System.out.println("删除成功！");
            }
            // 增删改必须要提交事务
            sqlSession.commit();
        }
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void getUserLikeTest(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.getUserLike("%李%");
            users.forEach(System.out::println);
        }
    }
}
