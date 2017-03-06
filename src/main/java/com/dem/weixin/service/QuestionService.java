package com.dem.weixin.service;

import com.dem.weixin.domain.Question;
import com.dem.weixin.query.QuestionQuery;
import com.dem.weixin.utils.PageResult;

import java.util.List;

/**
 * 创建人: DEM .
 */
public interface QuestionService {
    
    int deleteByPrimaryKey(Long id);
    
    int insert(Question record);
    
    Question selectByPrimaryKey(Long id);
    
    List<Question> selectAll();
    
    int updateByPrimaryKey(Question record);
    
    PageResult query(QuestionQuery query);
    
    String getContent(QuestionQuery query);
}
