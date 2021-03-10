package com.example.controller;

import com.example.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BaseController {

    // Redis操作工具
    @Autowired
    protected RedisOperator redis;

    // 用户Redis Session名
    protected static final String USER_REDIS_SESSION = "user-redis-session";

    // 静态资源所在路径
    protected static final String FILE_BASE = "/Users/yaokaiming/IdeaProjects/AwesomeVideo/AwesomeVideoUpload/";

    // ffmpeg所在路径
    protected static final String FFMPEG_EXE = "/usr/local/bin/ffmpeg";

    // 每页分页的记录数
    protected static final Integer PAGE_SIZE = 5;

}
