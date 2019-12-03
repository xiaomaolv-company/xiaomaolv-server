package com.xiaobo.smartmonkey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaobo.smartmonkey.dao")
public class SmartmonkeyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartmonkeyApplication.class, args);
    }

}
