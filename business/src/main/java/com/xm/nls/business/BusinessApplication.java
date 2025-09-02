package com.xm.nls.business;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@MapperScan("com.xm.nls.business.mapper")
public class BusinessApplication {

    private static final Logger log = LoggerFactory.getLogger(BusinessApplication.class);

    public static void main(String[] args) {
        ConfigurableEnvironment environment = SpringApplication
                .run(BusinessApplication.class, args)
                .getEnvironment();
        // 打印项目启动信息
        log.info("启动成功！！");
        log.info("测试地址: \thttp://localhost:{}{}/test",
                environment.getProperty("server.port"),
                environment.getProperty("server.servlet.context-path"));
    }
}
