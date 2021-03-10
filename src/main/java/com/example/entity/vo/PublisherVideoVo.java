package com.example.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author yaokm
 * @date 2020/2/6
 * @description 发布者与视频视图对象
 */
@Data
@ApiModel(value = "发布者与视频视图对象", description = "这是发布者与视频视图对象")
public class PublisherVideoVo implements Serializable {
    private UserVo publisher; // 视频发布者
    private boolean userLikeVideo; // 当前用户视频给该视频点赞
}
