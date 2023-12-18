package com.example.TodoApp.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * TodoVO
 */

@Data
public class TodoVO {
    private Long id;
    private String title;
    private String desc;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dueDate;
    private boolean completed;
}
