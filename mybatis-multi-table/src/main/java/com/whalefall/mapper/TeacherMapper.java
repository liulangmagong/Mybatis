package com.whalefall.mapper;

import com.whalefall.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wangshiyang
 * @since 2022/4/4
 **/
public interface TeacherMapper {

    /**
     * 查询老师
     * @return
     */
    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacher(@Param("tid") Integer id);
}
