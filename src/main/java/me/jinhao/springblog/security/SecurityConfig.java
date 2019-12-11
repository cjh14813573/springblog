package me.jinhao.springblog.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Service;

@Service
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    protected void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
        httpSecurity.csrf().disable();
    }
    
}