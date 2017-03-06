package com.dem.weixin.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.dem.weixin.domain.Question;
import com.dem.weixin.query.QuestionQuery;
import com.dem.weixin.service.QuestionService;
import com.dem.weixin.utils.JsonResult;
import com.dem.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 创建人: DEM .
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    
    @RequestMapping(value = "/add_question", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addQuestion(Question question, HttpServletRequest request) {
        
        boolean flag = false;
        
        for (Cookie cookie : request.getCookies()) {
            if ("user".equals(cookie.getName())) {
                JSONObject parseObject = JSONObject.parseObject(cookie.getValue());
                Long id = parseObject.getLong("id");
                String name = parseObject.getString("userName");
                question.setUserId(id);
                question.setUserName(name);
                flag = true;
                break;
            }
        }
        if (flag) {
            try {
                questionService.insert(question);
                return JsonResult.ok("数据保存成功!", null);
                
            } catch (Exception e) {
                e.printStackTrace();
                return JsonResult.error("程序出错,请联系管理员!");
            }
        } else {
            return JsonResult.error("未登陆用户不能提交问题!");
        }
        
    }
    
    @RequestMapping(value = "/search_question", method = RequestMethod.POST)
    
    public String query(QuestionQuery ques, Model model) {
        try {
            ques.setPageSize(5);
            PageResult query = questionService.query(ques);
            model.addAttribute("pageResult", query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "content";
    }
    
    @RequestMapping(value = "/showContent/{questionId}/{type}", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String showContent(@PathVariable Long questionId, @PathVariable Integer type) {
        QuestionQuery questionQuery = new QuestionQuery();
        questionQuery.setType(type);
        questionQuery.setQuestionId(questionId);
        System.out.println(type);
        String content = questionService.getContent(questionQuery);
        return content;
    }
}
