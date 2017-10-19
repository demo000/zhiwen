package com.dem.weixin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DEM on 2017/3/30.
 */
@Controller
@RequestMapping("/lodop")
public class LodopController {

    @RequestMapping("pageLodop")
    public String pageLodop() {
        return "lodop";
    }

    @RequestMapping("/getLodopContent")
    public String getLodopContent(){
        return "lodopContent";
    }
}
