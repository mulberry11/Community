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
    private String account_id;
    private String token;
    private long gmt_create;
    private long gmt_modify;
}
