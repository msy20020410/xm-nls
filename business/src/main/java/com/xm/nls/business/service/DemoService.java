package com.xm.nls.business.service;

import com.xm.nls.business.domain.Demo;
import com.xm.nls.business.req.DemoQueryReq;

import java.util.List;

public interface DemoService {

    List<Demo> query(DemoQueryReq demoQueryReq);
}
