package com.mmy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SecurityApplication
 * @Description TODO
 * @Author wang
 * @Date 2020/9/18 11:17
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.mmy.service")
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
