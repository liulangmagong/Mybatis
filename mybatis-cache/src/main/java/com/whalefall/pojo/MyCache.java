package com.whalefall.pojo;

import org.apache.ibatis.cache.Cache;

/**
 * @author wangshiyang
 * @since 2022/4/5
 * 这里可以自定义一些缓存策略，需要比较懂数据库
 **/
public class MyCache implements Cache {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object o, Object o1) {

    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
