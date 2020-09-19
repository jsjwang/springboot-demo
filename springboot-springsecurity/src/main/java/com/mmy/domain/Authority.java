package com.mmy.domain;

/**
 * @ClassName Authority
 * @Description TODO
 * @Author wang
 * @Date 2020/9/19 13:17
 * @Version 1.0
 **/
public class Authority {
    private Integer id;
    private String authority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Authority() {
    }

    public Authority(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
