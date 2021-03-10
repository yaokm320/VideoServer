package com.example.mapper;

import com.example.entity.Comment;
import com.example.entity.vo.CommentVo;
import com.example.utils.MyMapper;

import java.util.List;

/**
 * @author yaokm
 * @date 2020/2/6
 * @description 自定义评论Mapper
 */
public interface CommentMapperCustom extends MyMapper<Comment> {
    /**
     * 查询视频id对应的所有评论
     * @param videoId 视频id
     * @return 视频id对应的所有评论
     */
    List<CommentVo> queryComments(String videoId);
}
