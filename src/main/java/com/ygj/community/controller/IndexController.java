package com.ygj.community.controller;

import com.ygj.community.dto.QuestionDTO;
import com.ygj.community.entity.Question;
import com.ygj.community.entity.User;
import com.ygj.community.mapper.QuestionMapper;
import com.ygj.community.mapper.UserMapper;
import com.ygj.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 十一
 * @date 2020-03-17 19:58
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public String hello(HttpServletRequest request,
                        Model model
    ) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    break;
                }
            }
        }
        List<QuestionDTO> questionList= questionService.list();
        model.addAttribute("questions" ,questionList);
        return "index";
    }
}
