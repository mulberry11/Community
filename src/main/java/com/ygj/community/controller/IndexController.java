package com.ygj.community.controller;

import com.ygj.community.entity.User;
import com.ygj.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 十一
 * @date 2020-03-17 19:58
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String hello(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String token = cookie.getValue();
            User user = userMapper.findByToken(token);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                System.out.println(user);
                break;
            }
        }
        return "index";
    }
}
