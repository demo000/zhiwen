package com.dem.weixin.web.controller;

import com.dem.weixin.domain.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DEM on 2017/10/3.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/page")
    public String testPage(){
        return "testPage";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(User user){
        Gson gson = new Gson();
        System.out.println(user.getUserName());
        System.out.println(gson.toJson(user));
        return "sucess";
    }
    @RequestMapping("/t")
    public String t(String name, ModelMap model){
        model.put("name",name);
        return "t";
    }
    @RequestMapping("/load")
    @ResponseBody
    public String loadMsg(String name){
        return name;
    }

}

