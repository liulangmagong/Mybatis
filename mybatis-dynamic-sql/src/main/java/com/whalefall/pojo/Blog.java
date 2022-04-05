package com.whalefall.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author wangshiyang
 * @since 2022/4/4
 **/
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private Integer views;
}
