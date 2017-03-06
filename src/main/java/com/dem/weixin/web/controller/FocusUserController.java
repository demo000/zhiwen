package com.dem.weixin.web.controller;

import com.dem.weixin.query.FocusUserQuery;
import com.dem.weixin.service.FocusUserService;
import com.dem.weixin.utils.JsonResult;
import com.dem.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 创建人: DEM .
 */
@Controller
public class FocusUserController {
    @Autowired
    private FocusUserService focusUserService;
    
    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public String page( Model model) {
       
        return "user";
    }
    
    @RequestMapping(value = "/user/query", method = RequestMethod.POST)
    public String query(FocusUserQuery focusUserQuery, Model model) {
        System.out.println("-----------------");
       
        System.out.println(focusUserQuery);
        PageResult result = focusUserService.query(focusUserQuery);
        System.out.println("-----------------");
        
        model.addAttribute("pageResult", result);
        
        return "user_list";
    }
    @RequestMapping("/user/queryAppId/{keywords}")
    @ResponseBody
    public JsonResult queryAppId(@PathVariable String keywords){
        List<String> strings = focusUserService.queryAppId(keywords);
        if(strings!=null){
            return JsonResult.ok(strings);
        }
        return JsonResult.error();
    }
}
