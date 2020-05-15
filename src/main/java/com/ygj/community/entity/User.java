package com.ygj.community.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户id

     */
    private Integer id;

    /**
     * 用户名称
     */
    private String name;

    private String accountId;

    private String token;

    /**
     * 创建时间
     */
    private Long gmtCreate;

    /**
     * 修改时间
     */
    private Long gmtModify;

    /**
     * 头像
     */
    private String avatarUrl;

    private static final long serialVersionUID = 1L;
}