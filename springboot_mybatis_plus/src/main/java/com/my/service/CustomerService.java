package com.my.service;

import com.my.domain.Customer;

import java.util.List;

/**
 * @ClassName CustomerService
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 15:41
 * @Version 1.0
 **/
public interface CustomerService {
    List<Customer> listCustomers();
}
