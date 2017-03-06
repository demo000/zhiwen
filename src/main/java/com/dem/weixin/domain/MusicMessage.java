package com.dem.weixin.domain;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by DEM
 */
@XmlRootElement(name = "Music")
//根据字段解析
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
public class MusicMessage {
    /**
     * 回复音乐
     * <Title><![CDATA[TITLE]]></Title>
     <Description><![CDATA[DESCRIPTION]]></Description>
     <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
     <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
     <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
     */
    @XmlElement(name = "Title")
    private String title;
    @XmlElement(name = "Description")
    private String description;
    @XmlElement(name = "MusicUrl")
    private String musicUrl;
    @XmlElement(name = "HQMusicUrl")
    private String HQMusicUrl;
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;
    
    @Override
    public String toString() {
        return "MusicMessage{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", musicUrl='" + musicUrl + '\'' +
                ", HQMusicUrl='" + HQMusicUrl + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                '}';
    }
}
