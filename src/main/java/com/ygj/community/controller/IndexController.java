package com.ygj.community.controller;

import com.ygj.community.dto.PaginationDTO;
import com.ygj.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired(required = true)
    private QuestionService questionService;

    @GetMapping("/")
    public String hello(Model model,
                        @RequestParam(name = "page", defaultValue="1") Integer page,
                        @RequestParam(name = "size", defaultValue = "7") Integer size) {
        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
