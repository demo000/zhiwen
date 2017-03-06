package com.dem.weixin.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dem.weixin.utils.HttpUtils;
import com.dem.weixin.utils.WeixinConstant;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

import static com.dem.weixin.utils.WeixinConstant.MAKE_MENU;

/**
 * 定时刷新菜单作业类
 */
@Component
public class MakeMenuJob {
    /**
     * 用于接收微信后台返回的数据
     */
    public static String access_token;
    public static Long expires_in;
    
    /**
     * 获取token地址
     */
    
    public String getToken(String appid, String appsecret) {
        
        if (org.springframework.util.StringUtils.isEmpty(access_token)//不存在
                || (expires_in - 7200 * 1000) > new Date().getTime()
                ) {//token失效
            System.out.println("请求token");
            StringBuilder url = new StringBuilder(80);
            url.append(WeixinConstant.GET_TOKEN_URL).append(appid).append("&secret=").append(appsecret);
            System.out.println(url.toString());
            String temp = HttpUtils.get(url.toString());
            JSONObject jsonObject = JSON.parseObject(temp);
            if (StringUtils.hasLength(jsonObject.getString("errmsg"))) {
                System.out.println("连接出错,错误代码:"+jsonObject.getString("errcode"));
            }else{
                access_token = jsonObject.getString("access_token");
                expires_in = new Date().getTime() + jsonObject.getLong("expires_in") * 1000;
            }
            
            
        }
        
        return access_token;
    }
    
    public void makeMenu() {
        System.out.println("------------------------");
        System.out.println("------定时任务" + new Date().toLocaleString() + "--------");
        System.out.println("------------------------");
        String menu = " {\n" +
                "    \"button\": [\n" +
                "        {\n" +
                "            \"type\": \"click\", \n" +
                "            \"name\": \"今日歌曲\", \n" +
                "            \"key\": \"V1001_TODAY_MUSIC\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\": \"菜单\", \n" +
                "            \"sub_button\": [\n" +
                "                {\n" +
                "                    \"type\": \"view\", \n" +
                "                    \"name\": \"搜索\", \n" +
                "                    \"url\": \"http://www.soso.com/\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"type\": \"view\", \n" +
                "                    \"name\": \"视频\", \n" +
                "                    \"url\": \"http://v.qq.com/\"\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"type\": \"click\", \n" +
                "                    \"name\": \"赞一下我们\", \n" +
                "                    \"key\": \"V1001_GOOD\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        StringBuilder url = new StringBuilder(80);
        //创建连接
        url.append(MAKE_MENU).append(getToken(WeixinConstant.APPID, WeixinConstant.APPSECRET));
        //发送post请求
        String temp = HttpUtils.post(url.toString(), menu);
        //将请求对象转化成json
        JSONObject jsonObject = JSON.parseObject(temp);
        /* int errode = jsonObject.getInteger("errcode");
       String errmsg = jsonObject.getString("errmsg");
        System.out.println("errode = " + errode);
        System.out.println(errmsg);*/
    }
}
