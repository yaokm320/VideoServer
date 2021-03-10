package com.example.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper配置接口
 * Mapper接口：（基本的增、删、改、查方法）
 * MySqlMapper：针对MySQL的额外补充接口，支持批量插入
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    // 该通用mapper类，不要和其他业务的mapper放在一起，不要被@MapperScan扫描到
}
