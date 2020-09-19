package com.mmy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

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
    @GetMapping("userlogin")
    public String toLoginPage(){
        return "login/login";
    }

    //使用session获取当前用户的信息
    @GetMapping("getUserBySession")
    @ResponseBody
    public void getUser(HttpSession session){
        Enumeration<String> attributeNames = session.getAttributeNames();

            SecurityContextImpl attribute= (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
            System.out.println("attribute:"+attribute);
            //获取用户相关信息
            Authentication authentication=attribute.getAuthentication();
            UserDetails userDetails= (UserDetails) authentication.getPrincipal();
            System.out.println(userDetails.getUsername());
            System.out.println(userDetails.getPassword());
            System.out.println(userDetails);

    }
    //使用securityContextHolder获取用户信息
    @GetMapping("getUserByContext")
    @ResponseBody
    public void user(){
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("userdetails:"+context);
        Authentication authentication = context.getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        System.out.println(principal);
    }
}
