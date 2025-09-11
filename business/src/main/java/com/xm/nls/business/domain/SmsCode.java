package com.xm.nls.business.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信验证码表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsCode {
    /**
    * id
    */
    private Long id;

    /**
    * 手机号
    */
    private String mobile;

    /**
    * 验证码
    */
    private String code;

    /**
    * 用途|枚举值
    */
    private String use;

    /**
    * 状态|枚举值
    */
    private String status;

    /**
    * 修改时间
    */
    private Date updatedAt;

    /**
    * 创建时间
    */
    private Date createdAt;
}