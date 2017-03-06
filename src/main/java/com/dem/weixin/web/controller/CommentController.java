package com.dem.weixin.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.dem.weixin.domain.Comment;
import com.dem.weixin.query.CommentQuery;
import com.dem.weixin.service.CommentService;
import com.dem.weixin.utils.CookieUtils;
import com.dem.weixin.utils.JsonResult;
import com.dem.weixin.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 创建人: DEM .
 */
@Controller
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    @RequestMapping(value = "/add_comment", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addComment(Comment comment, HttpServletRequest request, HttpServletResponse response) {
        
        
        String userString = CookieUtils.getCookieValue(request, response, CookieUtils.COOKIED_USER_NAME);
        
        if (StringUtils.hasLength(userString)) {
            JSONObject jsonObject = JSONObject.parseObject(userString);
            Long id = jsonObject.getLong("id");
            String userName = jsonObject.getString("userName");
            comment.setUserName(userName);
            comment.setUserId(id);
            comment.setCreateDate(new Date());
            comment.setStar(0);
            try {
                commentService.insert(comment);
                return JsonResult.ok("评论成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                JsonResult.error("程序出错,请联系管理员!");
            }
        }
        
        return JsonResult.error("没有登录用户不能评论!");
    }
    
    @RequestMapping("/comment_list")
    public String commentList(CommentQuery query, Model model) {
        
        try {
            PageResult result = commentService.query(query);
            model.addAttribute("pageResult", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "comment_list";
    }
}
