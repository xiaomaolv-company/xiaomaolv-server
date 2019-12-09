package com.xiaobo.xiaomaolv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaobo.xiaomaolv.dao")
public class SmartmonkeyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartmonkeyApplication.class, args);
    }

}
