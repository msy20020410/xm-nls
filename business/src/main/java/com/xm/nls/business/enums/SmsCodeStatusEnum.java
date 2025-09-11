package com.xm.nls.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SmsCodeStatusEnum {
    USED("1", "已使用"),

    UNUSED("0", "未使用");

    @Getter
    private String code;
    @Getter
    private String desc;
}
