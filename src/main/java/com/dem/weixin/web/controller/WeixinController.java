package com.dem.weixin.web.controller;

import com.dem.weixin.domain.MusicMessage;
import com.dem.weixin.domain.XmlMessage;
import com.dem.weixin.utils.SHA1Utils;
import com.dem.weixin.utils.WeixinConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by DEM
 */
@Controller
public class WeixinController {
    
    
    /**
     * 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：
     * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * timestamp	时间戳
     * nonce	随机数
     * echostr	随机字符串
     *
     * @param signature
     * @return
     */
    @RequestMapping(value = "/weixin", method = RequestMethod.GET)
    @ResponseBody
    public String login(String signature, String timestamp, String nonce, String echostr) {
//
//     *1）将token、timestamp、nonce三个参数进行字典序排序
//
//     *2）将三个参数字符串拼接成一个字符串进行sha1加密
//
//     *3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        
        System.out.println(new Date().toLocaleString() + "接入...");
        String[] arr = new String[]{WeixinConstant.TOKEN, timestamp, nonce};
        
        Arrays.sort(arr);
        StringBuilder temp = new StringBuilder(80);
        for (String s : arr) {
            temp.append(s);
        }
        if (SHA1Utils.getSha1(temp.toString()).equals(signature)) {
            System.out.println("接入成功");
            return echostr;
        }
        return null;
    }
    
    /**
     * 消息回复
     *
     * @param textMessage
     * @return
     */
    @RequestMapping(value = "/weixin", method = RequestMethod.POST)
    @ResponseBody
    public XmlMessage getMessage(@RequestBody XmlMessage textMessage) {
    
        System.out.println(textMessage);
       
        XmlMessage xmlMessage = new XmlMessage();
        //设置接收用户
        xmlMessage.setToUserName(textMessage.getFromUserName());
        //设置发送公众号
        xmlMessage.setFromUserName(textMessage.getToUserName());
        xmlMessage.setCreateTime(new Date().getTime());
        
        //处理文本
        if ("text".equals(textMessage.getMsgType())) {
            System.out.println("接收文本消息" + textMessage.getContent());
            xmlMessage.setMsgType("text");
            xmlMessage.setContent("你好!" + textMessage.getContent());
            System.out.println("记录中...");
            
            //处理事件类型
        } else if ("event".equals(textMessage.getMsgType())) {
            /**
             *
             */
            if("V1001_TODAY_MUSIC".equals(textMessage.getEventKey())){
                System.out.println("回复音乐");
                xmlMessage.setMsgType("music");
                
                MusicMessage music = new MusicMessage();
                music.setTitle("每日音乐分享");
                music.setDescription("今日推荐");
                music.setMusicUrl("http://www.cy1001.net/goodtime.mp3");
                music.setHQMusicUrl("http://www.cy1001.net/goodtime.mp3");
                music.setThumbMediaId("123");
                xmlMessage.setMusic(music);
            }
            if("V1001_GOOD".equals(textMessage.getEventKey())){
                System.out.println("点赞");
                xmlMessage.setMsgType("text");
                xmlMessage.setContent("感谢你的认同");
            }
           
        }
        
        
        //订阅
        if ("subscribe".equals(textMessage.getEvent())) {
            
            
            System.out.println("新增关注" + textMessage.getToUserName());
            
            xmlMessage.setMsgType("text");
            xmlMessage.setContent("欢迎关注:回复相应关键字即可获得响应资源");
            
            //取消关注
        } else if ("unsubscribe".equals(textMessage.getEvent())) {
            System.out.println("取消关注" + textMessage.getToUserName());
            return null;
        }
        System.out.println(xmlMessage);
        return xmlMessage;
        
        
    }
    
}
