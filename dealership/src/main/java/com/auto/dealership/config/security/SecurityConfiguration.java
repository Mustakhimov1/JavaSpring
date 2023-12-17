package com.auto.dealership.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.http.HttpServletResponse;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain authSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()

                .antMatchers(HttpMethod.GET, "/auth/registration").not().authenticated()
                .antMatchers(HttpMethod.POST, "/auth/registration").not().authenticated()
                .anyRequest().authenticated();


        http.formLogin()
                .permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/auth/login")
                .successHandler((request, response, authentication) -> response.sendRedirect("/"))
                .failureHandler((request, response, exception) -> response.sendRedirect("/login"));

        http.logout()
                .permitAll()
                .logoutUrl("/auth/logout")
                .logoutSuccessHandler((request, response, authentication) -> response.sendRedirect("/login"));

        return http.build();
    }

}

