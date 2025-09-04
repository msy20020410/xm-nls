package com.xm.nls.business.controller;

import com.xm.nls.business.exception.BusinessException;
import com.xm.nls.business.resp.CommonResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    // 系统异常
    @ExceptionHandler(value = Exception.class)
    public CommonResp<Object> handler(Exception e) {
        log.info("服务异常：", e);
        CommonResp<Object> commonResp = new CommonResp<>();
        commonResp.setSuccess(false);
        commonResp.setMessage("服务异常,请联系管理员!");
        return commonResp;
    }

    // 业务异常
    @ExceptionHandler(value = BusinessException.class)
    public CommonResp<Object> handler(BusinessException e) {
        log.info("业务异常：", e);
        CommonResp<Object> commonResp = new CommonResp<>();
        commonResp.setSuccess(false);
        commonResp.setMessage(e.getE().getDesc());
        return commonResp;
    }
}
