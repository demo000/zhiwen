package com.dem.weixin.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

/**
 * 创建人: DEM .
 */
@Setter@Getter
public class QuestionQuery extends QueryObject {
    
    private Long questionId;
    private Long userId;
    
    private Integer type;//显示部分或者全部使用
    private String keywords;
    public String getKeywords(){
        return StringUtils.hasLength(keywords)?keywords:null;
    }
}
