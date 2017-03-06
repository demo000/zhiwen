package com.dem.weixin.mapper;

import com.dem.weixin.domain.Comment;
import com.dem.weixin.query.CommentQuery;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Long id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
    
    
    public int queryCount(CommentQuery query);
    
    public List<Comment> query(CommentQuery query);
}