package com.xm.nls.business.service.impl;

import cn.hutool.core.util.StrUtil;
import com.xm.nls.business.domain.Demo;
import com.xm.nls.business.exception.BusinessException;
import com.xm.nls.business.exception.BusinessExceptionEnum;
import com.xm.nls.business.mapper.DemoMapper;
import com.xm.nls.business.req.DemoQueryReq;
import com.xm.nls.business.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> query(DemoQueryReq demoQueryReq) {

        if (StrUtil.isBlank(demoQueryReq.getName())) {
            throw new BusinessException(BusinessExceptionEnum.DEMO_NAME_NOT_NULL);
        }

        return demoMapper.selectByNameOrderByAge(demoQueryReq.getName());
    }
}
