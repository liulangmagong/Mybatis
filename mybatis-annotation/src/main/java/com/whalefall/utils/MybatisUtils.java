package com.whalefall.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangshiyang
 * @since 2022/4/1
 **/

// sqlSessionFactory --> sqlSession   工厂模式
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    // 这里定义为静态方法  在工具类加载的时候会自动的创建，并且只会创建一次
    static {
        try {
            // 这里的三句代码是写死的，所以这里写到工具类中
            // 主要的作用就是用来获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream =  Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 类加载的时候就会自动创建SqlSessionFactory,那么我们就可以通过创建好的SqlSessionFactory
     * 来获取SqlSession实例对象了
     * 在SqlSession中完全包含了面向数据库执行 SQL 命令所需的所有方法
     * 这里添加一个参数 true 后续的增删改都不需要手动提交事务了，会开启自动提交事务
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }
}
