package com.whalefall.mapper;

import com.whalefall.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author wangshiyang
 * @since 2022/4/4
 **/
public interface BlogMapper {

    /**
     * 插入数据
     * @param blog
     */
    void addBlog(Blog blog);

    /**
     * 动态sql If 的使用
     * 功能实现：
     *      传入title，那就查询指定title的blog
     *      传入author，那就查询指定作者名下有多少博客
     *      如果什么都没有传，那么就查询所有博客
     * 这里使用Map类型，可以传入任意类型的参数
     * @param map
     * @return
     */
    List<Blog> queryBlogIf(Map map);

    /**
     * 动态sql Choose 的使用
     * 功能实现：
     * 根据传入的条件进行匹配，匹配上哪个就拼接哪个
     * 这里使用Map类型，可以传入任意类型的参数
     * @param map
     * @return
     */
    List<Blog> queryBlogChoose(Map map);

    /**
     * 动态更新sql Set 的使用
     * @param map
     * @return
     */
    int updateBlog(Map map);

    /**
     * for each的使用
     */
    List<Blog> queryBlogForeach(Map map);
}
