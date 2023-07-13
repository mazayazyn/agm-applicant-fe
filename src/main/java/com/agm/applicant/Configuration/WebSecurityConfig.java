package com.agm.applicant.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeRequests()
        .anyRequest().permitAll()
        .and().httpBasic();
  }
}
