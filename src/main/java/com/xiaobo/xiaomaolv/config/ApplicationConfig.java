package com.xiaobo.xiaomaolv.config;

import com.xiaobo.xiaomaolv.Service.SysOperationService;
import com.xiaobo.xiaomaolv.Service.VisitLogService;
import com.xiaobo.xiaomaolv.util.OperationLogUtil;
import com.xiaobo.xiaomaolv.util.Redis.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class ApplicationConfig implements WebMvcConfigurer, BeanPostProcessor {

    Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private SysOperationService sysOperationService;
    @Autowired
    private VisitLogService visitLogService;
    @Autowired
    private LoginInterceptor loginInterceptor;



    @Bean
    public OperationLogUtil operationLogUtil(){
        OperationLogUtil operationLogUtil = new OperationLogUtil();
        operationLogUtil.setVisitLogService(visitLogService);
        operationLogUtil.setSysOperationService(sysOperationService);
        operationLogUtil.setJedisUtil(jedisUtil);
        logger.info("初始化OperationLogUtil成功");
        return operationLogUtil;
    }



    /**
     *注册登录拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor);
        logger.info("登录拦截器注册成功");
    }


}
