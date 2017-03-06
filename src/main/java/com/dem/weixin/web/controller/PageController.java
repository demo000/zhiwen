package com.dem.weixin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建人: DEM .
 */
@Controller
public class PageController {
    
   
    @RequestMapping("/")
    public String index(){
        return "redirect:/index.jsp";
    }
    @RequestMapping("/page/{page}")
    public String page(@PathVariable String page){
        return page;
    }
}
