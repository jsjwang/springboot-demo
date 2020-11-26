package com.my.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.my.domain.Customer;
import com.my.mapper.CustomerMapperByPlus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CustomerServiceimplByPlus
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 17:32
 * @Version 1.0
 **/

@Service
public class CustomerServiceimplByPlus extends ServiceImpl<CustomerMapperByPlus, Customer> {
        public Customer listCustomers2(Integer id){
            return baseMapper.listCustomers2(id);
        }
}
