package com.dem.weixin.service.impl;

import com.dem.weixin.domain.LoginUser;
import com.dem.weixin.domain.User;
import com.dem.weixin.mapper.UserMapper;
import com.dem.weixin.service.UserService;
import com.dem.weixin.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 创建人: DEM .
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    private String appiKey = "demo";
    
    @Override
    public boolean isExist(String checkName, int type) {
        User user = new User();
        if (type == 1) {//验证用户名
            user.setUserName(checkName);
        } else if (type == 2) {//验证邮箱
            user.setEmail(checkName);
        }
        int count = userMapper.isExist(user);
        return count > 0;
    }
    
    @Override
    public int register(User user) {
        user.setCreateDate(new Date());
        user.setPassWord(MD5.encode(user.getPassWord() + appiKey));
        return userMapper.insert(user);
    }
    
    @Override
    public LoginUser login(LoginUser u) {
        u.setPassWord(MD5.encode(u.getPassWord() + appiKey));
        User user = userMapper.login(u);
        LoginUser loginUser = null;
        if(user!=null){
            loginUser =new LoginUser();
            loginUser.setId(user.getId());
            loginUser.setUserName(user.getUserName());
        }
        
        return loginUser;
    }
}
