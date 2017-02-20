package com.qin.isys.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Q on 2017/2/20.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final UserDetailsService userDetailsService = new SimpleUserDetailService();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("vip1").and()
//                .withUser("qin").password("123456").roles("svip").and()
//                .withUser("visitor123").password("123123").authorities("visitor");
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")/*设置登录页面*/
                .and()
                .logout().logoutUrl("/logout")/*设置注销请求链接*/
                .logoutSuccessUrl("/login")/*设置注销成功后跳转的页面*/
                .and()
                .authorizeRequests()
                .mvcMatchers("/center").hasAnyRole("user")
                .mvcMatchers("/profile").hasAnyRole("user")
                .and()
                .requiresChannel()
                .mvcMatchers(HttpMethod.POST,"/pay","signin","signup").requiresSecure()
                .and()
                .authorizeRequests()
                .antMatchers("/setting").authenticated()
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .rememberMe().tokenValiditySeconds(60*60*24*30);
    }
}
