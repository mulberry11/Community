package com.ygj.community.dto;

import com.ygj.community.entity.User;
import lombok.Data;

/**
 * @author 十一
 * @date 2020-03-30 09:19
 */
@Data
public class QuestionDTO {
    private Integer id;
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String description;

    private Long gmtCreate;

    private Long gmtModify;

    /**
     * 创建者
     */
    private Integer creator;

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
     * 标签
     */
    private String tag;
    private User user;
}
