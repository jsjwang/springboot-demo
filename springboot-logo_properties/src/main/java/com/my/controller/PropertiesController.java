package com.my.controller;

import com.my.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PropertiesController
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 11:30
 * @Version 1.0
 **/
@RestController
public class PropertiesController {
    @Value("${student1.name}")
    private String name;
    @Value("${student1.age}")
    private int age;

    @Autowired
    private Student student;

    /**
     * 获取配置文件中的少量属性时可以使用@Value
     * @return
     */
    @GetMapping("getStudent1")
    public String getSimpleProperties(){
        return name+":"+age;
    }

    /**
     * 如果从配置文件中获取大量属性时,
     * 可以将这些属性配置到一个实体类当中，
     * 然后在该类上标注@ConfigurationProperties及@Component即可
     * 使用的时候只需要将该实体类注入即可
     * @return
     */
    @GetMapping("getObject")
    public String getStudent1(){
        return student.toString();
    }
}
