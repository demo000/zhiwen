package com.dem.weixin.domain;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <xml>
     <ToUserName><![CDATA[toUser]]></ToUserName>
     <FromUserName><![CDATA[fromUser]]></FromUserName>
     <CreateTime>1348831860</CreateTime>
     <MsgType><![CDATA[text]]></MsgType>
     <Content><![CDATA[this is a test]]></Content>
     <MsgId>1234567890123456</MsgId>
 </xml>
 */

//名称必须跟传进来的根元素一样
@XmlRootElement(name="xml")
//根据字段解析
@XmlAccessorType(XmlAccessType.FIELD)
@Setter@Getter
public class XmlMessage {
    //保证属性名跟xml标签名一样
    @XmlElement(name = "ToUserName")
    private String toUserName;
    @XmlElement(name="FromUserName")
    private String fromUserName;
    @XmlElement(name="CreateTime")
    private Long createTime;
    @XmlElement(name="MsgType")
    private String msgType;
    @XmlElement(name="Content")
    private String content;
    @XmlElement(name="MsgId")
    private Long msgId;
    @XmlElement(name = "Event")
    private String event;
    
    @XmlElement(name = "EventKey")
    private String eventKey;
    //响应音乐
    @XmlElement(name="Music")
    private MusicMessage music;
    @XmlElement(name = "Type")
    private String type;
    
    
    @Override
    public String  toString() {
        StringBuilder temp = new StringBuilder(200);
        temp.append("发送给 ="+this.getToUserName())
                .append("\n 创建事件 ="+this.getCreateTime())
                .append("\n 来自="+this.getFromUserName())
                .append("\n 消息类型 = " + this.getMsgType())
                .append("\n 类型 ="+this.getType())
                .append("\n 事件 = " + this.getEvent())
                .append("\n 内容 = " + this.getContent())
                .append("\n 事件id = " + this.getEventKey())
        .append("\n 音乐 = "+this.getMusic());
        return temp.toString();
    }
}
