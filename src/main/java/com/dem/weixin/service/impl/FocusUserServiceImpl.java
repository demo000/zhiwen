package com.dem.weixin.service.impl;

import com.dem.weixin.domain.FocusUser;
import com.dem.weixin.mapper.FocusUserMapper;
import com.dem.weixin.query.FocusUserQuery;
import com.dem.weixin.service.FocusUserService;
import com.dem.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建人: DEM .
 */
@Service
public class FocusUserServiceImpl implements FocusUserService {
    
    @Autowired
    private FocusUserMapper focusUserMapper;
    
    
    @Override
    public int insert(FocusUser record) {
        return focusUserMapper.insert(record);
    }
    
    @Override
    public FocusUser selectByUserId(String userId) {
        return focusUserMapper.selectByUserId(userId);
    }
    
    @Override
    public List<FocusUser> selectAll() {
        return focusUserMapper.selectAll();
    }
    
    @Override
    public int updateByUserId(FocusUser record) {
        
        return focusUserMapper.updateByPrimaryKey(record);
    }
    
    @Override
    public List<FocusUser> queryForList(FocusUserQuery query) {
        query.setPageSize(-1);
        return focusUserMapper.query(query);
    }
    
    @Override
    public PageResult query(FocusUserQuery query) {
        
        int totalCount = focusUserMapper.queryCount(query);
        
        if(totalCount<0){
           return PageResult.EMTY();
        }
        List<FocusUser> result = focusUserMapper.query(query);
        
        return new PageResult(result,totalCount,query.getCurrentPage(),query.getPageSize());
    }
    
    @Override
    public List<String> queryAppId(String keywords) {
        return focusUserMapper.queryAppId(keywords);
    }
}
