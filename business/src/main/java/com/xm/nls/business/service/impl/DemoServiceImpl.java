package com.xm.nls.business.service.impl;

import com.xm.nls.business.mapper.DemoMapper;
import com.xm.nls.business.domain.Demo;
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

        return demoMapper.selectByNameOrderByAge(demoQueryReq.getName());
    }
}
