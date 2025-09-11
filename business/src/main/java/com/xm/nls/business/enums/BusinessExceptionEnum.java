package com.xm.nls.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义业务异常枚举
 */
@AllArgsConstructor
public enum BusinessExceptionEnum {

    DEMO_NAME_NOT_NULL("姓名不能为空!"),
    SMS_CODE_TOO_FREQUENTLY("发送短信验证码过于频繁,请一分钟后再试!");

    @Getter
    private final String desc;


}
