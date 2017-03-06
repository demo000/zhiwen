package com.dem.weixin.service.impl;

import com.dem.weixin.domain.Question;
import com.dem.weixin.mapper.QuestionMapper;
import com.dem.weixin.query.QuestionQuery;
import com.dem.weixin.service.QuestionService;
import com.dem.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 创建人: DEM .
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }
    
    @Override
    public int insert(Question record) {
        
        record.setCreateDate(new Date());
        return questionMapper.insert(record);
    }
    
    @Override
    public Question selectByPrimaryKey(Long id) {
        return null;
    }
    
    @Override
    public List<Question> selectAll() {
        return null;
    }
    
    @Override
    public int updateByPrimaryKey(Question record) {
        return 0;
    }
    
    @Override
    public PageResult query(QuestionQuery query) {
        int totalCount = questionMapper.queryCount(query);
        if(totalCount==0){
            return PageResult.EMTY();
        }
        List<Question> list = questionMapper.query(query);
        
        return new PageResult(list,totalCount,query.getCurrentPage(),query.getPageSize());
    }
    
    @Override
    public String getContent(QuestionQuery query) {
        
        return questionMapper.getContent(query);
    }
}
