package com.ygj.community.dto;

import lombok.Data;

/**
 * @author 十一
 * @date 2020-03-20 21:38
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
