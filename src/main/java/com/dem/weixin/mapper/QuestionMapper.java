package com.dem.weixin.mapper;

import com.dem.weixin.domain.Question;
import com.dem.weixin.query.QuestionQuery;

import java.util.List;

public interface QuestionMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(Question record);

    Question selectByPrimaryKey(Long id);

    List<Question> selectAll();

    int updateByPrimaryKey(Question record);
    
    int queryCount(QuestionQuery query);
    
    List<Question> query(QuestionQuery query);
    
    
    String getContent(QuestionQuery query);
}