package com.dem.weixin.utils;

import org.springframework.stereotype.Component;

/**
 * 向用户发送模板信息
 */
@Component
public class SendMessageUtils {
    /*
   private MakeMenuJob makeMenuJob = new MakeMenuJob();
    */
    /**
     * 向用户发送模板1数据
     * @param title
     * @param content
     * @param touser
     */
    
    /*
    
    public  void sendMessageTemplate1(String title,String content,String touser){
    
        StringBuilder json = new StringBuilder(100);
        json.append("{" +
                "\"touser:\"" + "\" "+touser+"\""+
                "\"template_id\":" + "\" "+ WeixinConstant.TEMPALE_MESSAGE_CODE1 +"\""+
                "\"url\":" + "\"http://www.baidu.com\"" +
                "\"topcolor\":" + "\"#FF0000\"" +
                "\"data\":{" +
                "\"title\":{" +
                "\"value\":" + title +
                "\"color\":\"#173177\"" +
                "}," +
                "\"content\":{" +
                "\"value\":" + content +
                "}" +
                "}" +
            
                "}");
        String url = WeixinConstant.TEMPAPLE_URL + makeMenuJob.getToken(WeixinConstant.APPID, WeixinConstant.APPSECRET);
        System.out.println(url.toString());
        String temp = HttpUtils.post(url, json.toString());
        JSONObject object = JSON.parseObject(temp);
        System.out.println("errcode= " + object.getInteger("errcode"));
        
    }
    */
}
