package com.authserver;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Martha on 2/26/2017.
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException)->response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .httpBasic().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("username")
                .password("adminpass")
                .authorities("admin")
                .and()
                .withUser("username")
                .password("questpass")
                .authorities("quest")
                .and()
                .withUser("username")
                .password("restaurantpass")
                .authorities("restaurant");
    }
}
