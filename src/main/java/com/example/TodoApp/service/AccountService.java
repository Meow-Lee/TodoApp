package com.example.TodoApp.service;

import com.example.TodoApp.domain.Account;
import com.example.TodoApp.repository.AccountRepository;
import com.example.TodoApp.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService{
    private final AccountRepository accountRepository;
    /**
     * account create
     */
    public void createAccount() {

    }

//    public void login(LoginVO loginVO) {
//        Optional<Account> account = accountRepository.findByName();
//    }
}
