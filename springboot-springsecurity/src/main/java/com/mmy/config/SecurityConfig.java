package com.mmy.config;

import com.mmy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
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
    /**
     * @EnableWebSecurity和@Configuration注解一起使用在WebSecurityConfigurerAdapter
     * 类型上或继承了该类的子类上，由于@EnableWebSecurity已经集成了@Configuration,因此可以
     * 只使用@EnableWebSecurity一个注解
     * @EnableWebSecurity中的重要组成注解:@Import  @Configruation @EnableGlobalAuthentication
     * @EnableGlobalAuthentication 又由@Import注解导入了AuthenticationConfiguration类
     * AuthenticationConfiguration 可以创建一个AuthenticationManager，可以轻松的实现是以内存
     * 的方式or jdbc or userDetailsService的方式进行验证
     *
     */





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



        //jdbc验证
   /* @Autowired
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

    //使用userDetailService进行验证登录
    @Resource
    private UserService userService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        auth.userDetailsService(userService).passwordEncoder(encoder);
    }

    //自定义授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/login/**").permitAll()
            .antMatchers("/detail/common/**").hasRole("common")
            .antMatchers("/detail/vip/**").hasRole("vip")
            .anyRequest().authenticated();

            //自定义用户登录控制
            http.formLogin()
                .loginPage("/userlogin").permitAll()
                .usernameParameter("name").passwordParameter("pwd")
                .defaultSuccessUrl("/")
                .failureUrl("/userlogin?error");
            //自定义用户退出只需要定义路径，不需要额外编写控制器
            http.logout().logoutUrl("/mylogout")
                    .logoutSuccessUrl("/userlogin");
            /*定制Remember-me功能
            * security默认提供的记住我功能的name是remember-me
            * */
            http.rememberMe()
                    .rememberMeParameter("rememberme")
                    .tokenValiditySeconds(200);


    }
}
