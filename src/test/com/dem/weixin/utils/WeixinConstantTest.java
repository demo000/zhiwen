package com.dem.weixin.utils;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by DEM on 2016/12/31.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration()
public class WeixinConstantTest {
    
   /* @Autowired(required = false)
    private MakeMenuJob makeMenuJob;
   
    @Test
    public void testTempMessage() {
        StringBuilder json = new StringBuilder(100);
        json.append("{" +
                "\"touser:\"" + "\" "+WeixinConstant.TOUSER_ID +"\""+
                "\"template_id\":" + "\" "+ WeixinConstant.TEMPALE_MESSAGE_CODE1 +"\""+
                "\"url\":" + "\"http://www.baidu.com\"" +
                "\"topcolor\":" + "\"#FF0000\"" +
                "\"data\":{" +
                    "\"title\":{" +
                    "\"value\":" + "\"测试模板1\"" +
                    "\"color\":\"#173177\"" +
                    "}," +
                    "\"content\":{" +
                    "\"value\":" + "\"测试使用呵呵呵呵\"" +
                    "}" +
                "}" +
                
                "}");
        String url = WeixinConstant.TEMPAPLE_URL + makeMenuJob.getToken(WeixinConstant.APPID, WeixinConstant.APPSECRET);
        System.out.println(url.toString());
        String temp = HttpUtils.post(url, json.toString());
        JSONObject object = JSON.parseObject(temp);
        System.out.println("errcode= " + object.getInteger("errcode"));
    }*/
}