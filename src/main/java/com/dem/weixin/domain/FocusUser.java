package com.dem.weixin.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter@Getter
public class FocusUser {
    private Long id;

    private String userId;

    private String appId;
   
    
    private Date createDate;

    private Integer genre;
    
    private String ip;

}