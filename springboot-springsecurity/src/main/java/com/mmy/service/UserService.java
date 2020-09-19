package com.mmy.service;

import com.mmy.domain.Authority;
import com.mmy.domain.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author wang
 * @Date 2020/9/19 13:30
 * @Version 1.0
 **/
@Service
public class UserService implements UserDetailsService {
    @Resource
    private CustomerService customerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.getCustomer(username);
        List<Authority> roles = customerService.listAuthoritys(customer.getId());
        customer.setAuthoritys(roles);
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for (Authority role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return new User(customer.getUsername(), customer.getPassword(),authorities);
    }
}
