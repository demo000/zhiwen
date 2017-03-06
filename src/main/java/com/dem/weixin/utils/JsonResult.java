package com.dem.weixin.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * 创建人: DEM .
 */
@Setter
@Getter
public class JsonResult {
    private int state;
    private String msg;
    
    public Object data;
    
    public JsonResult() {
        
    }
    
    public JsonResult(int state, String msg, Object object) {
        this.msg = msg;
        this.state = state;
        this.data = object;
    }
    
    public static JsonResult ok(Object object) {
        return new JsonResult(200, "操作正确", object);
    }
    
    public static JsonResult ok(String msg,Object object){
        return  new JsonResult(200,msg,object);
    }
    public static JsonResult ok() {
        return new JsonResult(200, "操作正确", null);
    }
    
    public static JsonResult error() {
        return new JsonResult(400, "操作有误", null);
    }
    
    public static JsonResult error(String msg){
        return  new JsonResult(400,msg,null);
    }
}
