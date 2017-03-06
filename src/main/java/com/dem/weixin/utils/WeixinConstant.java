package com.dem.weixin.utils;

/**
 * 定义常量
 */
public class WeixinConstant {
    /**
     * 微信公众号接口配置的token
     */
    public static final String TOKEN = "demo";
    /**
     * 微信公众号信息
     */
    //测试号
    public static final String APPID = "wxfb8c98d49bc45cfc";
    
    public static final String APPSECRET = "0dbf0c1abadb1334f02f20cba917b372";
    /**
     * 公众号
     */
    public static final String APPID1 = "wx0156b093d151aecb";
   
    public static final String APPSECRET1 = "f4e161529e17cd16e6732e37a4b55335";
  
    /**
     * 测试关注id
     */
    public static final String TOUSER_ID = "o4gR-xCQ7AoWJGVl5GO_Aig2Ls3E";
    
   
    /**
     * 获取token地址
     */
    public static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=";
    /**
     * 创建菜单地址
     */
    public static final String MAKE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
    /**
     * 发送模板连接
     */
    public static final String TEMPAPLE_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
    /**
     * 模板1id
     */
    public static final String TEMPALE_MESSAGE_CODE1 = "4SHWgHSbNq4oE1AahjlFou6iR4rVu1NvubGJRRT6rhM";
    
    public static final String LOGIN_URL ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    
    public static final String USER_INFO_URL="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    
}
