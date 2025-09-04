package com.xm.nls.business.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义业务异常枚举
 */
@AllArgsConstructor
public enum BusinessExceptionEnum {

    DEMO_NAME_NOT_NULL("姓名不能为空!");

    @Getter
    private final String desc;


}
