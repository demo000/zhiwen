package com.dem.weixin.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * 创建人: DEM .
 */
@Setter@Getter
public class PageResult {
    private List<?> result;
    private Integer currentPage;
    private Integer pageSize;
    private Integer prePage;
    private Integer nextPage;
    private Integer totalPage;
    private Integer totalCount;
    
    public PageResult(List<?> result, Integer totalCount,Integer currentPage, Integer pageSize) {
        this.result = result;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = this.totalCount / this.pageSize + (this.totalCount % this.pageSize == 0 ? 0 : 1);
        this.prePage = this.currentPage - (this.currentPage > 1 ? 1 : 0);
        this.nextPage = this.currentPage + (this.currentPage < this.totalPage ? 1 : 0);
    }
    
    public PageResult() {
    }
    /*防止分页插件出现当前页大于总页数的情况*/
    public Integer getTotalPage(){
        return this.totalPage>1?this.totalPage:1;
    }
    
    public static PageResult EMTY(){
        return new PageResult(Collections.EMPTY_LIST,0,1,5);
    }
}
