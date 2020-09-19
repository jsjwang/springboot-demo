package com.mmy.domain;

import java.util.List;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author wang
 * @Date 2020/9/19 13:09
 * @Version 1.0
 **/
public class Customer {
    private Integer id;
    private String username;
    private String password;
    private Integer valid;
   private List<Authority> authoritys;

    public Customer(Integer id, String username, String password, Integer valid, List<Authority> authoritys) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.valid = valid;
        this.authoritys = authoritys;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public List<Authority> getAuthoritys() {
        return authoritys;
    }

    public void setAuthoritys(List<Authority> authoritys) {
        this.authoritys = authoritys;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", valid=" + valid +
                ", authoritys=" + authoritys +
                '}';
    }
}
