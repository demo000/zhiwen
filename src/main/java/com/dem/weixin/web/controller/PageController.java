package com.dem.weixin.web.controller;

import com.dem.weixin.domain.CountyNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: DEM .
 */
@Controller
public class PageController {


    @RequestMapping("/")
    public String index() {
        return "redirect:/index.jsp";
    }

    @RequestMapping("/page/{page}")
    public String page(@PathVariable String page) {
        return page;
    }


    @RequestMapping("jsonPage")
    public String jsonPage(ModelMap model) {

        model.put("selectP","44");
        CountyNode countyNode = new CountyNode();
        countyNode.setName("天河区");
        countyNode.getStreet().add("沙河街道");
        countyNode.getStreet().add("五山街道");
        CountyNode node2 = new CountyNode();
        node2.setName("荔湾区");
        node2.getStreet().add("沙面街道");
        node2.getStreet().add("华林街道");
        List<CountyNode> nodeList = new ArrayList<>();
        nodeList.add(countyNode);
        nodeList.add(node2);
        Gson gson = new Gson();
        String json = gson.toJson(nodeList);
        model.put("gsonList", json);
        model.put("selectStr", "沙面街道,华林街道,沙河街道,五山街道");
        model.put("city","2");
        model.put("p", "44");
        return "jsonPage";
    }

    @RequestMapping(value = "getCity",method = RequestMethod.POST)
    @ResponseBody
    public String getCity(String datas){
        Gson gson = new GsonBuilder().create();
        System.out.println(datas);
        return datas;
        //return "";
    }

    @RequestMapping(value = "city/{cityid}")
    public String pageCity(@PathVariable String cityid, HttpServletRequest request) {

        try {
            String reapath = request.getSession().getServletContext().getRealPath("/street.json");
            Reader fileReader = new FileReader(reapath);
            JsonReader jsonReader = new JsonReader(fileReader);
            next(jsonReader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "city";
    }

    public void next(JsonReader jsonReader) {
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jsonReader.beginObject();
                String id = jsonReader.nextString();
                String name = jsonReader.nextString();
                next(jsonReader);
                System.out.println(id + name);

                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception e) {

        }
    }


}
