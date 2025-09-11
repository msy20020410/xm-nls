package com.xm.nls.business.service;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.xm.nls.business.domain.SmsCode;
import com.xm.nls.business.enums.BusinessExceptionEnum;
import com.xm.nls.business.enums.SmsCodeUseEnum;
import com.xm.nls.business.exception.BusinessException;
import com.xm.nls.business.mapper.SmsCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsCodeService {

    @Autowired
    private SmsCodeMapper smsCodeMapper;

    // 发送短信验证码
    public void sendSmsCode(String mobile, String use) {
        // 避免过于频繁的发送验证码问题（1分钟内）
        SmsCode oldSmsCode = smsCodeMapper.selectByMobileAndUse(mobile, use);
        if (oldSmsCode != null) {
            long gap = DateUtil.between(oldSmsCode.getCreatedAt(), DateUtil.date(), DateUnit.MINUTE);
            // 判断时间上是否为一分钟内
            if (gap < 1) {
                throw new BusinessException(BusinessExceptionEnum.SMS_CODE_TOO_FREQUENTLY);
            }
        }

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
