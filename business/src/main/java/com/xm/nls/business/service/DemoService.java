package com.xm.nls.business.service;

import com.xm.nls.business.model.entity.Demo;

import java.util.List;

public interface DemoService {

    List<Demo> query(String name);
}
