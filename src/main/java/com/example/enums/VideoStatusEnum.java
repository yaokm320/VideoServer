package com.example.enums;

/**
 * @author yaokm
 * @date 2020/2/6
 * @description 视频状态枚举
 */
public enum  VideoStatusEnum {
    SUCCESS(1), // 发布成功
    FORBID(2); // 禁止播放，观里操作

    public final int value;

    VideoStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
