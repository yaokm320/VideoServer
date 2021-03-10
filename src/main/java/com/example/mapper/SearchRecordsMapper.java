package com.example.mapper;

import com.example.entity.SearchRecords;
import com.example.utils.MyMapper;

import java.util.List;

public interface SearchRecordsMapper extends MyMapper<SearchRecords> {
    /**
     * 获取热搜词
     * @return 热搜词列表
     */
    List<String> getHotWords();
}