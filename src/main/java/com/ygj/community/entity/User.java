package com.ygj.community.entity;

import lombok.Data;

/**
 * @author 十一
 * @date 2020-03-24 19:12
 */
@Data
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private long gmtCreate;
    private long gmtModify;
    private String avatarUrl;
}
