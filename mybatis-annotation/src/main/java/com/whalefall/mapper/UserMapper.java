package com.whalefall.mapper;

import com.whalefall.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wangshiyang
 * @since 2022/4/1
 **/
public interface UserMapper {

    /*如果多个方法都用到这个结果集映射，可以给这个结果集映射添加一个id 这样后边直接使用
    * ResultMap进行引用这个结果集映射即可*/
    @Results(id = "resultMap", value = {
            @Result(column = "pwd", property = "password")
    })

    /**
     * 获取全部用户
     * @return
     */
    @Select("select * from user")
    /*这里就是单独添加的样式*/
//    @Results({
//            @Result(property = "password", column = "pwd")
//    })
    List<User> getUserList();

    /**
     * 根据ID获取用户
     * 这里注意，当需要传递参数的时候，如果参数类型是基本类型，全部需要添加 @Param
     * 只要是基本类型的参数，有几个就加几个 @Param
     * 这里sql取的参数是从 @Param 中获取的
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id} and name = #{name}")
    /*这里就是使用定义好的结果集映射的方式*/
    @ResultMap(value = "resultMap")
    User getUserById(@Param("id") int id, @Param("name") String name);


    /**
     * 插入一个用户
     * 这里前边的 (id, name, pwd) 对应的是数据库的字段
     * 后边的  (#{id}, #{name}, #{password}) 对应的是实体类的属性
     */
    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{password})")
    void addUser(User user);


    /**
     * 更新用户
     */
    @Update("update user set name = #{name}, pwd = #{password} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);

}
