package com.dem.weixin.web.controller;

import com.dem.weixin.domain.User;
import com.dem.weixin.service.UserService;
import com.dem.weixin.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建人: DEM .
 */
@RestController
public class RegriterController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/checkUserName")
    public boolean checkUserName(String name) {
        
        boolean exist = userService.isExist(name, 1);
        
        return !exist;
    }
    @RequestMapping("/checkEmail")
    public boolean checkEmail(String email){
        boolean exist = userService.isExist(email,2);
        return  !exist;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult register(User user) throws InterruptedException {
        try {
            int register = userService.register(user);
            return JsonResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResult.error();
    }
}
