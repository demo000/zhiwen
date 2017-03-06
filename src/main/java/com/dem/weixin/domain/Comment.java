package com.dem.weixin.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter@Getter
public class Comment {
    private Long id;

    private Long questionId;

    private Long userId;

    private String content;

    private String userName;

    private Date createDate;

    private Integer star;

   
}