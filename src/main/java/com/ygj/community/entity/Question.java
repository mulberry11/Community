package com.ygj.community.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * question
 * @author 
 */
@Data
public class Question implements Serializable {
    private Integer id;

    private String title;

    private String description;

    private Long gmtCreate;

    private Long gmtModify;

    private Integer createor;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 阅读数
     */
    private Integer viewCount;

    /**
     * 点赞数

     */
    private Integer likeCount;

    /**
     * 内容
     */
    private String tag;

    private static final long serialVersionUID = 1L;
}