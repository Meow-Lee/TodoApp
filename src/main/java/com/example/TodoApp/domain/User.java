package com.example.TodoApp.domain;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Long id;

    @Column(name = "UserName")
    private String username;
    @Column(name = "Password")
    private String password;
}
