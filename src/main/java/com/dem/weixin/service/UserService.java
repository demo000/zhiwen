package com.dem.weixin.service;

import com.dem.weixin.domain.LoginUser;
import com.dem.weixin.domain.User;

/**
 * 创建人: DEM .
 */
public interface UserService {
    
    public boolean isExist(String checkName,int type);
    
    public int register(User user);
    
    public LoginUser login(LoginUser u);
    
}
