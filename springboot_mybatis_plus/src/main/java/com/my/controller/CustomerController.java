package com.my.controller;

import com.my.domain.Customer;
import com.my.service.CustomerService;
import com.my.service.impl.CustomerServiceimplByPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CustomerController
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 15:56
 * @Version 1.0
 **/
@Controller
public class CustomerController {
    //springboot会自动去templates/error下面去寻找错误页面

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerServiceimplByPlus customerServiceimplByPlus;

    @GetMapping("/list")
    public String listCustomers(Model model){

        List<Customer> customers = customerService.listCustomers();
        model.addAttribute("customers", customers);
        return "index";
    }
    @GetMapping("/listPlus")
    public String listCustomers2(Model model){
        Customer customer = customerServiceimplByPlus.listCustomers2(1);
        model.addAttribute("customers", customer);
        return "index";
    }
}
