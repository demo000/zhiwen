package com.dem.weixin.service;

import com.dem.weixin.domain.FocusUser;
import com.dem.weixin.query.FocusUserQuery;
import com.dem.weixin.utils.PageResult;

import java.util.List;

/**
 * 创建人: DEM .
 */
public interface FocusUserService {
    
    int insert(FocusUser record);
    
    FocusUser selectByUserId(String userId);
    
    List<FocusUser> selectAll();
    
    int updateByUserId(FocusUser record);
    
    List<FocusUser> queryForList(FocusUserQuery query);
    
    PageResult query(FocusUserQuery query);
    
    public List<String> queryAppId(String keywords);
    
    
}
