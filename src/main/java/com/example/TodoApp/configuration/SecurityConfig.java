package com.example.TodoApp.configuration;

import com.example.TodoApp.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final PasswordEncoder pwEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    UserDetailsService authentication(){
        UserDetails peter = User.builder()
                .username("peter")
                .password(pwEncoder.encode("ppassword"))
                .roles("USER")
                .build();

        UserDetails jodie = User.builder()
                .username("jodie")
                .password(pwEncoder.encode("jpassword"))
                .roles("ADMIN")
                .build();

        System.out.println(">>> Peter's password: " + peter.getPassword());
        System.out.println(">>> Jodie's password: " + jodie.getPassword());

        return new InMemoryUserDetailsManager(peter, jodie);
    }

    /**
     * request 들어오는 것에 대해서 /login으로 매칭되는 url들은 요청을 받아들이고, 다른 요청들은 인가가 필요하도록 함
     * 폼 로그인 페이지는 /login으로 설저앟고 성공하면 이동하는 url은 /home으로 이동하게 함
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                        request -> request.requestMatchers("/").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        form -> form.loginPage("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                );
        return httpSecurity.build();
    }

//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(
//                request -> request.requestMatchers("/home").hasRole("ADMIN")
//                        .anyRequest().permitAll()
//        ).formLogin(
//                form -> form.loginPage("/login").permitAll()
//        ).logout(
//                logout -> logout.permitAll()
//        );
//
//        return http.build();
//    }
}
