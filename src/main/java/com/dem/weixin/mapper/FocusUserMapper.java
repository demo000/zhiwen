package com.dem.weixin.mapper;

import com.dem.weixin.domain.FocusUser;
import com.dem.weixin.query.FocusUserQuery;

import java.util.List;

public interface FocusUserMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(FocusUser record);

    FocusUser selectByUserId(String useId);

    List<FocusUser> selectAll();

    int updateByPrimaryKey(FocusUser record);
    
    List<FocusUser> query(FocusUserQuery query);
    
    int queryCount(FocusUserQuery query);
    
    List<String> queryAppId(String keywords);
    
}