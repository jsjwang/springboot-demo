package com.my.service.impl;

import com.my.domain.Customer;
import com.my.mapper.CustomerMapper;
import com.my.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CustomerServiceImpl
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 15:43
 * @Version 1.0
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> listCustomers() {
        return null;
    }
   /* @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> listCustomers() {
        return customerMapper.listCustomers();
    }*/
}
