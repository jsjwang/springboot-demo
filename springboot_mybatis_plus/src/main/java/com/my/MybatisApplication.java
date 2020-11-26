package com.my;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName MybatisApplication
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 15:37
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.my.mapper")
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class,args);
    }
}
