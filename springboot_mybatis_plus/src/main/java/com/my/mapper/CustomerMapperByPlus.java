package com.my.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.my.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName CustomerMapperByPlus
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 17:27
 * @Version 1.0
 **/
@Mapper
public interface CustomerMapperByPlus extends BaseMapper<Customer> {
    /**
     * mybatis-plus的使用流程
     * 导入依赖jar 包，
     * 自定义的mapper继承通用mapper
     * 自定义的serviceImpl继承通用 serviceImpl
     * @param id
     * @return
     */



    @Select("select id,username,password from t_customer where id=#{id}")
    @ResultType(value=Customer.class)
    Customer listCustomers2(Integer id);
}
