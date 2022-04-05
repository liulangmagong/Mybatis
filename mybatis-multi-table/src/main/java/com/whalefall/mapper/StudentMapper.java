package com.whalefall.mapper;

import com.whalefall.pojo.Student;

import java.util.List;

/**
 * @author wangshiyang
 * @since 2022/4/4
 **/
public interface StudentMapper {

    /**
     * 查询所有学生的信息，以及对应的老师的信息
     * @return
     */
    public List<Student> getStudent();

    /**
     * 查询所有学生的信息，以及对应的老师的信息
     * @return
     */
    public List<Student> getStudent2();
}
