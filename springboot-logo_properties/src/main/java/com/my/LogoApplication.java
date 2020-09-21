package com.my;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName LogoApplication
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 11:06
 * @Version 1.0
 **/
@SpringBootApplication
public class LogoApplication {
    /**
     * springboot内部已经集成了sl4j日志框架
     * @param args
     */
    public static void main(String[] args) {
         /*使用默认的sl4j
         final Logger logger= LoggerFactory.getLogger(LogoApplication.class);
          logger.info("hello");*/
        /*
        使用自定义的日志打印
        final Logger logger=LoggerFactory.getLogger(LogoApplication.class);
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");
        */

        SpringApplication.run(LogoApplication.class, args);
    }

}
