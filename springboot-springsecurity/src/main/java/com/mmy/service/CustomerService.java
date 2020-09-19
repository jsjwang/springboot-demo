package com.mmy.service;

/**
 * @ClassName CustomerService
 * @Description TODO
 * @Author wang
 * @Date 2020/9/19 13:08
 * @Version 1.0
 **/

import com.mmy.domain.Authority;
import com.mmy.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerService {
    @Select("select id,username,password,valid from t_customer where username=#{username}")
    Customer getCustomer(String username);

    @Select("select a.id,a.authority from\n" +
            "t_authority a,t_customer_authority ca\n" +
            "where a.id=ca.authority_id and ca.customer_id=#{id}" )
    List<Authority> listAuthoritys(Integer id);

}
