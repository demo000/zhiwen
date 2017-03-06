package com.dem.weixin.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 创建人: DEM .
 */
@Getter@Setter
public class FocusUserQuery extends  QueryObject {
    
    //1表示关注 -1表示取消关注
    private Integer genre = 0;
    //关注的公众号
    private String appId;
    //用户ID
    private String userId;
    //查询开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date startDate;
    //查询结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date endDate;
    
    public String getAppId(){
        return StringUtils.hasLength(this.appId)?appId:null;
    }
    
    public String getUserId(){
        return StringUtils.hasLength(this.userId)?userId:null;
    }
    
    public Integer getGenre(){
        return  this.genre==0?null:this.genre;
    }
    
    
    @Override
    public String toString() {
        return "FocusUserQuery{" +
                "genre=" + genre +
                ", appId='" + appId + '\'' +
                ", userId='" + userId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                "} " + super.toString();
    }
}
