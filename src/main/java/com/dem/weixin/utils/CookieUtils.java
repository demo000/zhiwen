package com.dem.weixin.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建人: DEM .
 */
public class CookieUtils {
    public static   final  String COOKIED_USER_NAME="user";
    
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int time) {
        
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(time);
        response.addCookie(cookie);
    }
    
    
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value) {
        setCookie(request, response, name, value, 30 * 60);
    }
    
    public static String getCookieValue(HttpServletRequest request, HttpServletResponse response, String name) {
        
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
    
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, "");
        response.addCookie(cookie);
        
    }
}
