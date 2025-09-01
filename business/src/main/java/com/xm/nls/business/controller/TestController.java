package com.xm.nls.business.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 测试接口
    @GetMapping("/test")
    public String test() {
        return "hello world";
    }
}
