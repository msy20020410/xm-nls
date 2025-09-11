package com.xm.nls.business.mapper;

import com.xm.nls.business.domain.SmsCode;
import org.apache.ibatis.annotations.Param;

public interface SmsCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsCode record);

    int insertSelective(SmsCode record);

    SmsCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsCode record);

    int updateByPrimaryKey(SmsCode record);

    SmsCode selectByMobileAndUse(@Param("mobile") String mobile, @Param("use") String use);
}