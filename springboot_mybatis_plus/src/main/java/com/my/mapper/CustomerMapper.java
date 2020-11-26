package com.my.mapper;

import com.my.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName CustomerMapper
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 15:44
 * @Version 1.0
 **/
@Mapper
public interface CustomerMapper {
    List<Customer> listCustomers();
    /**
     * 第二种使用mybatis注解的方式
     * 常用注解的含义:@Result 在列和属性之间单独映射，常用属性:id column property
     * one many
     * @Results结果集映射
     * @Options 配置选项的附加值
     * @One @Many @Param
     * 结果集映射
     * @Results{
     *   @Result(id="true",property="",column="")
     *   @Result(property="",column="")
     * }
     * 一对一映射
     * @Results{
     *      @Result(id="true",property="",column="")
     *      @Result(property="",column="")
     *      @Result(property="",column="关联的id",one=@One(select="com.my.mapper.接口名.方法名"))
     * }
     * 一对多映射
     * @Results{
     *      @Result(id="true",property="",column="")
     *      @Result(property="",column="" many=@Many(select=""))
     * }
     */
}
