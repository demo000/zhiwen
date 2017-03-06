package com.dem.weixin.mapper;

import com.dem.weixin.domain.LoginUser;
import com.dem.weixin.domain.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    
    int isExist(User user);
    
    User login(LoginUser u);
}