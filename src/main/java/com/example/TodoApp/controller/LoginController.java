package com.example.TodoApp.controller;

import com.example.TodoApp.service.AccountService;
import com.example.TodoApp.vo.LoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

//@Controller
//public class LoginController {
//    private final AccountService accountService = new AccountService();
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

//    @PostMapping("/login")
//    public String loginSuccess(@ModelAttribute LoginVO loginVO) {
//        Optional<LoginVO> canLogin = accountService.login(loginVO);
//
//        return "home";
//    }
//}