package com.dem.weixin.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 创建人: DEM .
 */
@Setter@Getter
public class LoginUser {
    private Long id;
    private String userName;
    private String passWord;
    private boolean expires;//是否一周有效
}
