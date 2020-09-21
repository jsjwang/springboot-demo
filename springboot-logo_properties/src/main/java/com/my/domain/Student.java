package com.my.domain;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

/**
 * @ClassName Student1
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 11:37
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "student1")
public class Student {
    private String name;
    private Integer age;
    private Integer grade;
    private String className;
}
