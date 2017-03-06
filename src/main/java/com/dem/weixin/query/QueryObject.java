package com.dem.weixin.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 创建人: DEM .
 */
@Setter@Getter
public class QueryObject {
    Integer currentPage =1;
    Integer pageSize =20;
    public int getStart(){
        return (currentPage-1)*pageSize;
    }
    
    @Override
    public String toString() {
        return "QueryObject{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
