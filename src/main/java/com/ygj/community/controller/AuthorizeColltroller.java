package com.ygj.community.controller;

import com.ygj.community.dto.AccessTokenDTO;
import com.ygj.community.dto.GithubUser;
import com.ygj.community.entity.User;
import com.ygj.community.mapper.UserMapper;
import com.ygj.community.provider.GithubProvider;
import com.ygj.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 十一
 * @date 2020-03-20 21:25
 */
@Controller
public class AuthorizeColltroller {

    @Autowired(required=true)
    private GithubProvider githubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.Secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if (user != null && user.getId() != null) {
            User loginUser = new User();
            String token = UUID.randomUUID().toString();
            loginUser.setToken(token);
            loginUser.setAccountId(String.valueOf(user.getId()));
            loginUser.setName(user.getName());
            loginUser.setAvatarUrl(user.getAvatarUrl());
            userService.createOrUpdate(loginUser);
            //写入cookie
            response.addCookie(new Cookie("token", token));
            //登录成功写cookie和session

            return "redirect:/";
        } else {
            //登录失败,重新登录
            return "redirect:/";
        }
    }
    @GetMapping("/logout")
    @Transactional
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
