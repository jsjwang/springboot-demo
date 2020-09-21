package com.my.controller;

import com.my.domian.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysUserController
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 13:55
 * @Version 1.0
 **/
@RestController
@Api(value="在线接口文档")
public class SysUserController {
    /**
     *  @APi标注该类是swagger资源
     * @ApiOperation表示一个http请求操作
     * @ApiParam 标明参数的信息
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    @ApiOperation(value="根据用户id查找用户信息")
    public SysUser getUserById(@PathVariable("id") @ApiParam(value="用户唯一标识符")
                                           Integer id){
        SysUser sysUser=new SysUser(1, "李白", "123",1);
        return sysUser;
    }
}
