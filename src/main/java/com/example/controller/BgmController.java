package com.example.controller;

import com.example.service.BgmService;
import com.example.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// @Api注解对接口进行描述
@Api(value = "背景音乐业务的接口", tags = {"背景音乐业务的Controller"})
@RestController
@RequestMapping("/bgm")
public class BgmController extends BaseController {

    @Autowired
    private BgmService bgmService;

    // @ApiOperation注解对接口中的方法进行描述
    @ApiOperation(value = "获取背景音乐列表", notes = "获取背景音乐列表的接口")
    @PostMapping("/list")
    public JsonResult list() {
        return JsonResult.ok(bgmService.queryBgmList());
    }

}
