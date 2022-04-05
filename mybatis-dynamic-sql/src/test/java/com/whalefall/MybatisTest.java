package com.whalefall;

import com.whalefall.mapper.BlogMapper;
import com.whalefall.pojo.Blog;
import com.whalefall.utils.IDUtil;
import com.whalefall.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author wangshiyang
 * @since 2022/4/4
 **/
public class MybatisTest {

    /**
     * 插入数据
     */
    @Test
    public void addBlogTest(){

        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId(IDUtil.genId());
            blog.setTitle("java专业300年");
            blog.setAuthor("小花");
            blog.setCreateTime(new Date());
            blog.setViews(9998);
            mapper.addBlog(blog);

            blog.setId(IDUtil.genId());
            blog.setTitle("mybatis专业455年");
            mapper.addBlog(blog);

            blog.setId(IDUtil.genId());
            blog.setTitle("mybatis专业4666年");
            mapper.addBlog(blog);

            blog.setId(IDUtil.genId());
            blog.setTitle("mybatis专业788年");
            mapper.addBlog(blog);

            // 如果没有设置自动提交的话，进行增删改操作的时候一定要进行提交
            sqlSession.commit();
        }
    }

    /**
     * 动态sql If 的使用
     * 功能实现：
     *      传入title，那就查询指定title的blog
     *      传入author，那就查询指定作者名下有多少博客
     *      如果什么都没有传，那么就查询所有博客
     * 这里使用Map类型，可以传入任意类型的参数
     */
    @Test
    public void queryBlogIfTest(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
//            map.put("title", "mybatis专业300年");
            map.put("author", "小花");
            List<Blog> blogs = mapper.queryBlogIf(map);
            blogs.forEach(System.out::println);
        }
    }


    /**
     * 动态sql Choose的使用
     * 功能实现：
     */
    @Test
    public void queryBlogChooseTest(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
//            map.put("title", "mybatis专业300年");
//            map.put("author", "小花");
            map.put("views", 99);
            List<Blog> blogs = mapper.queryBlogChoose(map);
            blogs.forEach(System.out::println);
        }
    }

    /**
     * 动态sql set的使用
     * 功能实现：
     */
    @Test
    public void updateBlogSetTest(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("title", "mybatis专业300222年");
            map.put("author", "小花2");
            map.put("id", "c796058b58e347bd908234b21c0cb8cb");
            mapper.updateBlog(map);

            sqlSession.commit();
        }
    }

    /**
     * 动态sql foreach的使用
     * 功能实现：
     */
    @Test
    public void updateBlogForeachTest(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()){
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("ids", Arrays.asList(1, 2, 3));
            mapper.queryBlogForeach(map).forEach(System.out::println);

        }
    }
}
