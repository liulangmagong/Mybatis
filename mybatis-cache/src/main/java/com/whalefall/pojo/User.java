package com.whalefall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wangshiyang
 * @since 2022/4/1
 **/
@Data
@AllArgsConstructor
public class User implements Serializable {
    // 跟数据库相关的，一律全部使用包装类型
    private Integer id;
    private String name;
    private String pwd;
}
