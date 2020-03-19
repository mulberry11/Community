package com.ygj.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 十一
 * @date 2020-03-17 19:58
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
