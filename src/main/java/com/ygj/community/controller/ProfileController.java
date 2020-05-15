package com.ygj.community.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ygj.community.entity.Question;
import com.ygj.community.entity.User;
import com.ygj.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 十一
 * @date 2020-04-02 22:47
 */
@Controller
public class ProfileController {

    @Autowired(required = true)
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String doQuestion(HttpServletRequest request,
                             @RequestParam(name = "page", defaultValue="1") Integer page,
                             @RequestParam(name = "size", defaultValue = "9") Integer size,
                             @PathVariable(name = "action") String action,
                             Model model) {
        User user=(User)request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        if ("question".contains(action)) {
            model.addAttribute("section", "question");
            model.addAttribute("sectionName", "我的提问");
        } else if ("replies".contains(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }
        //PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
        PageInfo<Question> questionPage = questionService.list(page, size, user.getId());
        model.addAttribute("pageInfo",questionPage);
        return "profile";
    }
}
