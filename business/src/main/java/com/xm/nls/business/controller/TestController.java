package com.xm.nls.business.controller;

import com.xm.nls.business.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DemoMapper demoMapper;

    // 测试接口
    @GetMapping("/test")
    public String test() {
        return "hello world ";
    }

    // 测试demo
    @GetMapping("/count")
    public String count() {
        return demoMapper.count();
    }
}
