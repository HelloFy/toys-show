package com.khalid.toys.core.configure;

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
import org.springframework.security.web.csrf.CsrfFilter;
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
        auth.authenticationProvider(customAuthenticationProvider).userDetailsService(customUserDetailService).passwordEncoder(customPassWordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index","/error/**","/js/**","/css/**","/images/**","/user/existName","/user/existMobile").permitAll()
                .and()
                .formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/login.html").loginProcessingUrl("/login").successForwardUrl("/index").failureForwardUrl("/login.html")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .addFilter(new CsrfFilter(new HttpSessionCsrfTokenRepository()));
    }
}
