package com.dem.weixin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Question {
    private Long id;
    
    private String title;
    
    private String content;
    
    private Long userId;
    
    private String userName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date createDate;
    
    private Integer commentNumber;//评论数
    
    
}