package com.example.TodoApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /**
     * request 들어오는 것에 대해서 /login으로 매칭되는 url들은 요청을 받아들이고, 다른 요청들은 인가가 필요하도록 함
     * 폼 로그인 페이지는 /login으로 설저앟고 성공하면 이동하는 url은 /home으로 이동하게 함
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                        request -> request.requestMatchers("/home").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        form -> form.loginPage("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                );
        return httpSecurity.build();
    }
}
