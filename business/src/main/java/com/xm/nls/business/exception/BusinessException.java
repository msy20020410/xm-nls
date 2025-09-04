package com.xm.nls.business.exception;

import lombok.Data;

/**
 * 自定义业务异常
 */
@Data
public class BusinessException extends RuntimeException {

    private BusinessExceptionEnum e;

    // 新增带有枚举对象的构造
    public BusinessException(BusinessExceptionEnum e) {
        super(e.getDesc());     // 将枚举对象中的描述信息赋给父类
        this.e = e;
    }

    // 重写fillInStackTrace方法,减少堆栈追踪信息
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
