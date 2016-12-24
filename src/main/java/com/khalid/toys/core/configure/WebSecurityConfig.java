package com.khalid.toys.core.configure;

import com.khalid.toys.core.configure.handler.CustomAuthFailHandler;
import com.khalid.toys.core.configure.handler.CustomAuthSuccessHandler;
import com.khalid.toys.core.service.CustomAuthenticationProvider;
import com.khalid.toys.core.service.CustomPassWordEncoder;
import com.khalid.toys.core.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * Created by 费玥 on 2016/12/9.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private CustomPassWordEncoder customPassWordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(customPassWordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/error/**","/js/**","/css/**","/images/**","/user/existName","/user/existMobile","/getCsrfToken").permitAll()
                .and()
                .formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/login.html").loginProcessingUrl("/login")
                .successHandler(new CustomAuthSuccessHandler())
                .failureHandler(new CustomAuthFailHandler())
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository());
    }
}
