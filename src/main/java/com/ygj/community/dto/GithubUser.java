package com.ygj.community.dto;

import lombok.Data;

/**
 * @author 十一
 * @date 2020-03-21 13:02
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
