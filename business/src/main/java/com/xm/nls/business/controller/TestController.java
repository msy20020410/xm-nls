package com.xm.nls.business.controller;

import cn.hutool.core.bean.BeanUtil;
import com.xm.nls.business.domain.Demo;
import com.xm.nls.business.req.DemoQueryReq;
import com.xm.nls.business.resp.CommonResp;
import com.xm.nls.business.resp.DemoQueryResp;
import com.xm.nls.business.service.DemoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DemoService demoService;

    // 测试接口
    @GetMapping("/test")
    public CommonResp<String> test() {
        return new CommonResp<>("hello world ");
    }

    // 测试根据姓名查询
    @GetMapping("/query")
    public CommonResp<List<DemoQueryResp>> query(@Valid DemoQueryReq demoQueryReq) {
        List<Demo> demoList = demoService.query(demoQueryReq);
        // 避免返回直接的实体对象,将数据转换成DemoQueryResp
        return new CommonResp<>(BeanUtil.copyToList(demoList, DemoQueryResp.class));
    }
}
