package com.dem.weixin.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 创建人: DEM .
 */
@Setter
@Getter
public class CommentQuery extends QueryObject {
    private Long questionId;
    private Long userId;
    private Integer star;
    
}
