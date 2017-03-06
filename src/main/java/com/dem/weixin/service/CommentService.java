package com.dem.weixin.service;

import com.dem.weixin.domain.Comment;
import com.dem.weixin.query.CommentQuery;
import com.dem.weixin.utils.PageResult;

import java.util.List;

/**
 * 创建人: DEM .
 */
public interface CommentService {
    int deleteByPrimaryKey(Long id);
    
    int insert(Comment record);
    
    Comment selectByPrimaryKey(Long id);
    
    List<Comment> selectAll();
    
    int updateByPrimaryKey(Comment record);
    
    public PageResult query(CommentQuery query);
}
