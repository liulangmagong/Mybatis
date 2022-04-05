package com.whalefall.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author wangshiyang
 * @since 2022/4/4
 **/
@Data
public class TeacherOneToMore {
    private Integer id;
    private String name;

    // 一个老师拥有多个学生 对应的是一个 学生的集合
    private List<StudentOneToMore> students;
}
