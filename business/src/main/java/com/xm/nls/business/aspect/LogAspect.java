package com.xm.nls.business.aspect;


import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    // 定义切入点,切入该项目所有的controller
    @Pointcut("execution(public * com.xm.nls.business.controller..*.*(..))")
    public void pointCut() {
    }

    // 环绕通知,使用该类记录接口的日志
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 利用雪花算法,生成唯一的日志跟踪号id，方便查询不同线程的日志
        MDC.put("LOG_ID", IdUtil.getSnowflakeNextIdStr());

        log.info("---------------环绕通知开始--------------------------------");
        long startTime = System.currentTimeMillis();

        // 获取请求属性
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // 获取请求对象
        HttpServletRequest request = attributes.getRequest();
        // 获取方法签名
        String name = joinPoint.getSignature().getName();

        // 打印请求信息
        log.info("请求地址:{} {} ", request.getRequestURL().toString(), request.getMethod());
        log.info("类名方法:{}.{} ", joinPoint.getSignature().getDeclaringTypeName(), name);
        log.info("远程地址:{}", request.getRemoteAddr());

        Object[] args = joinPoint.getArgs();
        // 过滤掉BindingResult 或 Exception
        args = Arrays.stream(args)
                .filter(arg -> !(arg instanceof BindingResult || arg instanceof Exception))
                .toArray();

        log.info("请求参数: {}", JSONObject.toJSONString(args));

        // 排除特殊类型参数, 如文件类型
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                continue;
            }
            arguments[i] = args[i];
        }

        // 排除字段,敏感的、太长的（身份证、手机号、邮箱、密码等）
        String[] excludeProperties = {"cbb2", "idCard"};
        // 创建属性过滤器
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludeFilter = filters.addFilter();
        // 增加排除字段
        excludeFilter.addExcludes(excludeProperties);
        log.info("请求参数: {}", JSONObject.toJSONString(arguments, excludeFilter));

        // 打印被切方法执行结果
        Object result = joinPoint.proceed();

        // 返回值如果是异常也别进行序列化
        if (!(result instanceof Exception)) {
            log.info("返回结果: {}", JSONObject.toJSONString(result, excludeFilter));
        }

        log.info("---------------环绕通知结束 耗时: {} ms ---------------------", System.currentTimeMillis() - startTime);

        return result;
    }


    // 前置通知
//    @Before("pointCut()")
//    public void before() {
//        log.info("前置通知发生...");
//    }

    // 后置通知
//    @After("pointCut()")
//    public void after() {
//        log.info("后置通知发生...");
//    }
}
