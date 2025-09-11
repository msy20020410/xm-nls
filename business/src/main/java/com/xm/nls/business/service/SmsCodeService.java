package com.xm.nls.business.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.xm.nls.business.domain.SmsCode;
import com.xm.nls.business.enums.SmsCodeUseEnum;
import com.xm.nls.business.mapper.SmsCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsCodeService {

    @Autowired
    private SmsCodeMapper smsCodeMapper;

    // 发送短信验证码
    public void sendSmsCode(String mobile, String use) {
        // 填充smsCode
        SmsCode smsCode = new SmsCode(
                IdUtil.getSnowflakeNextId(),
                mobile,
                RandomUtil.randomNumbers(6),
                SmsCodeUseEnum.REGISTER.getCode(),
                use,
                DateUtil.date(),
                DateUtil.date()
        );
        // 保存到持久层
        smsCodeMapper.insert(smsCode);
    }
}
