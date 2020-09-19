package com.mmy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author wang
 * @Date 2020/9/19 10:48
 * @Version 1.0
 **/
@EnableWebSecurity  //开启mvc security安全支持
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*使用内存进行身份验证

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("admin").password(encoder.encode("123"))
                .roles("common")
                .and()
                .withUser("user").password(encoder.encode("123"))
                .roles("vip");

    }*/


    /*
        jdbc验证
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String userSql="select username,password,valid from t_customer where username=?";
        String authoritySQL="select c.username,a.authority from t_customer c, "+
                                                    "t_authority a,t_customer_authority ca where "+
                                              "ca.customer_id=c.id and ca.authority_id=a.id and c.username =?";
        auth.jdbcAuthentication().passwordEncoder(encoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(userSql)
                .authoritiesByUsernameQuery(authoritySQL);
    }*/
}
