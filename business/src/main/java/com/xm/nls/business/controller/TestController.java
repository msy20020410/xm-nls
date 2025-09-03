package com.xm.nls.business.controller;

import com.xm.nls.business.model.entity.Demo;
import com.xm.nls.business.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DemoService demoService;

    // 测试接口
    @GetMapping("/test")
    public String test() {
        return "hello world ";
    }

    // 测试根据姓名查询
    @GetMapping("/query")
    public List<Demo> query(@RequestParam(required = false) String name) {
        return demoService.query(name);
    }
}
