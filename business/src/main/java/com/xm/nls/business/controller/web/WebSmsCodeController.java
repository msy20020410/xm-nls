package com.xm.nls.business.controller.web;

import com.xm.nls.business.enums.SmsCodeUseEnum;
import com.xm.nls.business.req.RegisterSmsCodeReq;
import com.xm.nls.business.resp.CommonResp;
import com.xm.nls.business.service.SmsCodeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/sms-code")
public class WebSmsCodeController {

    @Autowired
    private SmsCodeService smsCodeService;

    // 发送短信验证码
    @PostMapping("/send-for-register")
    public CommonResp<Object> send(@Valid @RequestBody RegisterSmsCodeReq req) {
        smsCodeService.sendSmsCode(req.getMobile(), SmsCodeUseEnum.REGISTER.getCode());
        return new CommonResp<>();
    }
}
