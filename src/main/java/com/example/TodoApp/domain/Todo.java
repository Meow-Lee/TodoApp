package com.example.TodoApp.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * Todo App 엔티티
 * <p>
 * id -> Todo 목록 id (PK)
 * title -> 제목
 * desc -> 내용
 * dueDate -> 기한
 * completed -> 달성 여부
 * category -> 카테고리
 */

@Entity
@Data
@RequiredArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TodoId")
    private Long id;

    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String desc;
    @Column(name = "DueDate")
    private LocalDate dueDate;
    @Column(name = "Completed")
    private boolean completed;
    @Column(name = "Category")
    private String category;

    @Builder
    public Todo(Long id, String title, String desc, LocalDate dueDate, boolean completed, String category) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.dueDate = dueDate;
        this.completed = completed;
        this.category = category;
    }
}
