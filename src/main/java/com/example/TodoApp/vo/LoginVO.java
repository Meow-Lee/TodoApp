package com.example.TodoApp.vo;

import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class LoginVO {
    private String username;
    private String password;
    private String userEmail;
}
