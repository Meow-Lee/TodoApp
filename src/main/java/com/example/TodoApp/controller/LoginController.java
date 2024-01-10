package com.example.TodoApp.controller;

import com.example.TodoApp.service.LoginService;
import com.example.TodoApp.vo.LoginVO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 로그인 버튼을 누르고 DB에 회원 정보가 있으면 /home으로 redirect
     * 정보가 없다면 null을 반환받음으로서 다시 /login 페이지로 redirect
     */
    @PostMapping("/login")
    public String login(@ModelAttribute LoginVO loginVO) {
        if (loginService.loadUserByUsername(loginVO.getUsername()) == null) {
            return "redirect:/login";
        }
        return "redirect:/home";
    }

//    @PostMapping("/login")
//    public String loginSuccess(@ModelAttribute LoginVO loginVO) {
//        Optional<LoginVO> canLogin = accountService.login(loginVO);
//
//        return "home";
//    }
}