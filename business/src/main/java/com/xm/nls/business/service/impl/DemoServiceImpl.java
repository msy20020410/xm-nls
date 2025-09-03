package com.xm.nls.business.service.impl;

import com.xm.nls.business.mapper.DemoMapper;
import com.xm.nls.business.model.entity.Demo;
import com.xm.nls.business.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> query(String name) {

        return demoMapper.selectByNameOrderByAge(name);
    }
}
