package com.dem.weixin.utils;

import com.dem.weixin.domain.TextContent;
import com.dem.weixin.domain.TextMessage;
import com.dem.weixin.domain.VideoMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

/**
 * Created by DEM on 2016/12/31.
 */


public class WeixinConstantTest {


    @Test
    public void testTempMessage() {
        Gson gson = new GsonBuilder().create();
        TextMessage textMessage = new TextMessage();
        textMessage.setTouser("xxxxx");
        TextContent content = new TextContent();
        content.setContent("12121");
        textMessage.setText(content);
        System.out.println(gson.toJson(textMessage));
    }

    @Test
    public void testImageJson() {
        Gson gson = new GsonBuilder().create();
        VideoMessage message = new VideoMessage();

        System.out.println(gson.toJson(message));
    }
}