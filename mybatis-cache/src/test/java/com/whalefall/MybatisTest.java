package com.whalefall;

import com.whalefall.mapper.UserMapper;
import com.whalefall.pojo.User;
import com.whalefall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author wangshiyang
 * @since 2022/4/5
 **/
public class MybatisTest {

    /**
     * 这部分缓存的周期就是从sqlSession创建到sqlSession关闭这段时间，是比较短的
     * 实现功能：
     *      在sqlSession创建到sqlSession关闭这段时间连续多次查询同一个数据
     *      只会执行一次sql查询，查完后会存在缓存中，下次查询会直接查询缓存
     *      Opening JDBC Connection
     *      Created connection 1661406123.
     *      ==>  Preparing: select * from user where id = ?
     *      ==> Parameters: 1(Integer)
     *      <==    Columns: id, name, pwd
     *      <==        Row: 1, 狂神, 123456
     *      <==      Total: 1
     *      User(id=1, name=狂神, pwd=123456)
     *      =============两次查询同一个用户==================
     *      User(id=1, name=狂神, pwd=123456)
     */
    @Test
    public void queryTest(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.queryUserById(2);
            System.out.println(user);
        }

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.queryUserById(2);
            System.out.println(user);
        }
    }
}
