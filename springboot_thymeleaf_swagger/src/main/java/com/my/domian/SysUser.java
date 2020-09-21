package com.my.domian;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 13:52
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@ApiModel("用户实体类")
public class SysUser {
    private Integer id;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("用户状态")
    private int status;
}
