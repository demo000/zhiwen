package com.dem.weixin.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by DEM on 2017/3/8.
 */
@Setter@Getter
public class BaseMessage implements Serializable {

    public  static final String TEXT = "text";//文本
    public  static final String IMAGE = "image";//图片
    public  static final String VOICE = "voice";//声音
    public  static final String MUSIC = "music";//音乐
    public  static final String VIDEO = "video";//视频
    public  static final String NEWS = "news";//图文
    public  static final String MPNEWS = "mpnews";//
    public  static final String WXCARD = "wxcard";//卡券



    private String touser;
    private String msgtype;

    private Customservice customservice;
}
