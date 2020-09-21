package com.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 12:04
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //访问路径 http://localhost:8080/swagger-ui.html
    //swagger的版本与springboot的版本息息相关，如果不对应将会报错
   @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                //指定构建api文档详细信息的方法
                .apiInfo(apiInfo())
                .select()
                //指定要生成api接口的路径
                .apis(RequestHandlerSelectors.basePackage("com.my.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("接口预览")
                //接口描述
                .description("springboot-demo")
                .version("1.0")
                //联系人
                .contact("wang")
                .build();
    }
}
