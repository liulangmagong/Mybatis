package com.whalefall.mapper;

import com.whalefall.pojo.TeacherOneToMore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangshiyang
 * @since 2022/4/4
 **/
public interface TeacherOneToMoreMapper {

    /**
     * 查询老师
     * @return
     */
    List<TeacherOneToMore> getTeacher();

    /**
     * 获取指定老师及其下的所有学生信息
     */
    TeacherOneToMore getTeacher2(@Param("tid") int id);

    /**
     * 获取指定老师及其下的所有学生信息
     */
    TeacherOneToMore getTeacher3(@Param("tid") int id);
}
