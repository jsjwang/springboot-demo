package com.mmy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName FilmController
 * @Description TODO
 * @Author wang
 * @Date 2020/9/19 10:39
 * @Version 1.0
 **/
@Controller
public class FilmController {
    @RequestMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type,
                           @PathVariable("path") String path){
            return "detail/"+type+"/"+path;
    }
}
