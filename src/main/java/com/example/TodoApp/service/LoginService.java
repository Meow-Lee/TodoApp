package com.example.TodoApp.service;

import com.example.TodoApp.repository.UserRepository;
import com.example.TodoApp.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final UserRepository userRepository;

    private UserDetails createAccount(LoginVO loginVO) {
        return User.builder()
                .username(loginVO.getUsername())
                .password(loginVO.getPassword())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
