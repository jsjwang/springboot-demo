package com.my.domain;

import lombok.*;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author wang
 * @Date 2020/9/21 15:41
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private Integer id;
    private String userName;
    private String password;

}
