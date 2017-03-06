package com.dem.weixin.service.impl;

import com.dem.weixin.domain.Comment;
import com.dem.weixin.mapper.CommentMapper;
import com.dem.weixin.query.CommentQuery;
import com.dem.weixin.service.CommentService;
import com.dem.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建人: DEM .
 */
@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentMapper commentMapper;
    
    @Override
    public int deleteByPrimaryKey(Long id) {
        return commentMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int insert(Comment record) {
      
        return commentMapper.insert(record);
    }
    
    @Override
    public Comment selectByPrimaryKey(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }
    
    @Override
    public int updateByPrimaryKey(Comment record) {
        
        return commentMapper.updateByPrimaryKey(record);
    }
    
    @Override
    public PageResult query(CommentQuery query) {
        
        int  totalCount = commentMapper.queryCount(query);
        if(totalCount==0){
            return PageResult.EMTY();
        }
        List<Comment> result = commentMapper.query(query);
        
        
        return new PageResult(result,totalCount,query.getCurrentPage(),query.getPageSize());
    }
}
