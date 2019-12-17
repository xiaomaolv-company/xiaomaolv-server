package com.xiaobo.xiaomaolv.config;

import com.xiaobo.xiaomaolv.util.OperationLogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    @Bean
    public OperationLogUtil operationLogUtil(){
        OperationLogUtil operationLogUtil = new OperationLogUtil();
        logger.info("初始化OperationLogUtil成功");
        return operationLogUtil;
    }
}
