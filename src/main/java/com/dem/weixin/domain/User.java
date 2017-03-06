package com.dem.weixin.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter@Getter
public class User {
    private Long id;

    private String userName;

    private String passWord;

    private String email;
    //前台向后台发送时间格式指定 否则报400
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    private String sex;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", birthDay=" + birthDay +
                ", sex='" + sex + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}