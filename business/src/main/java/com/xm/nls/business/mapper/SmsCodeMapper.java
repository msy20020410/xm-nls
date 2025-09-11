package com.xm.nls.business.mapper;

import com.xm.nls.business.domain.SmsCode;

public interface SmsCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCode record);

    int insertSelective(SmsCode record);

    SmsCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCode record);

    int updateByPrimaryKey(SmsCode record);
}