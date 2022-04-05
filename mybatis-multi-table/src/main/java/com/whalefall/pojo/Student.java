package com.whalefall.pojo;

import lombok.Data;

/**
 * @author wangshiyang
 * @since 2022/4/4
 **/
@Data
public class Student {
    private Integer id;
    private String name;

    // 学生需要关联老师,所以这里不能直接定义一个tid,需要关联一个老师
    private Teacher teacher;
}
