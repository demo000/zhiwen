package com.dem.weixin.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.dem.weixin.domain.LoginUser;
import com.dem.weixin.service.UserService;
import com.dem.weixin.utils.CookieUtils;
import com.dem.weixin.utils.JsonResult;
import com.dem.weixin.utils.WeixinConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 创建人: DEM .
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/logout")
    @ResponseBody
    public JsonResult logout(HttpServletRequest request, HttpServletResponse response) {
        
        CookieUtils.deleteCookie(request, response, "user");
        return JsonResult.ok();
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(LoginUser user, HttpServletRequest request, HttpServletResponse response) {
        
        try {
            LoginUser login = userService.login(user);
            if (login != null) {
                Object json = JSONObject.toJSON(login);
                if (user.isExpires()) {
                    CookieUtils.setCookie(request, response, "user", json.toString(), 7 * 24 * 3600);
                } else {
                    CookieUtils.setCookie(request, response, "user", json.toString());
                }
                
                return JsonResult.ok("登陆成功!", null);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("程序出错,请联系管理员!");
        }
        return JsonResult.error("密码错误");
    }
    
    
    @RequestMapping(value = "/weixin_login", method = RequestMethod.GET)
    @ResponseBody
    public void weixinLogin(HttpServletRequest request, HttpServletResponse response) {
        
        String login_url = WeixinConstant.LOGIN_URL.replace("APPID", WeixinConstant.APPID1).replace("REDIRECT_URI", "http://16y2975f32.iask.in/user").replace("SCOPE", "snsapi_base");
        System.out.println(login_url);
        try {
        
            response.sendRedirect(login_url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
