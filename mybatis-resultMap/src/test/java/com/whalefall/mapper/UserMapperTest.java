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
     * 当数据库中的字段名和实体类的属性名不一致的时候
     * select * from user where id = #{id};
     * select id, name, pwd from user where id = #{id};
     * 得到的 pwd 是没有办法给 password 赋值的，所以得到的结果：
     * User{id=1, name='狂神', password='null'}
     *
     * 为了让 password 认识 pwd 并获取对应的值
     * 方法一：修改sql 起别名
     * select id, name, pwd as password  from user where id = #{id};
     */
    @Test
    public void test() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);
            System.out.println(user);
        }
    }


}
