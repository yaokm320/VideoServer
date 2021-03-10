package com.example.service;

import com.example.entity.Bgm;

import java.util.List;

/**
 * @author yaokm
 * @date 2020/2/6
 * @description 背景乐服务接口
 */
public interface BgmService {
    /**
     * 查询背景音乐列表
     * @return 背景音乐列表
     */
    List<Bgm> queryBgmList();

    /**
     * 根据id查询背景音乐
     * @param bgmId 背景音乐id
     * @return 背景音乐
     */
    Bgm queryBgmById(String bgmId);
}
