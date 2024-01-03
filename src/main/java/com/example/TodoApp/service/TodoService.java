package com.example.TodoApp.service;

import com.example.TodoApp.aop.TimeLog;
import com.example.TodoApp.domain.Todo;
import com.example.TodoApp.repository.TodoRepository;
import com.example.TodoApp.vo.TodoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    @Autowired
    private final TodoRepository todoRepository;

    /**
     * find all todos
     */
    public List<Todo> findTodos() {
        return todoRepository.findAll();
    }

    /**
     * todo create
     */
    public Todo createTodo(String title, String desc, LocalDate date, boolean completed) {
        return Todo.builder().title(title)
                .desc(desc)
                .dueDate(date)
                .completed(completed)
                .build();
    }

    /**
     * todo add
     */
    @TimeLog
    public void addTodo(TodoVO todoVO) {
        String title = todoVO.getTitle();
        String desc = todoVO.getDesc();
        LocalDate dueDate = todoVO.getDueDate();

        Todo todo = createTodo(title, desc, dueDate, todoVO.isCompleted());

        todoRepository.save(todo);
    }

    /**
     * find old todo
     */
    public Todo findTodoById(Long id) {
        Optional<Todo> oldTodo = todoRepository.findById(id);

        return oldTodo.orElseThrow(() -> new IllegalArgumentException("No Data"));
    }

    /**
     * todo update
     */
    public void updateTodo(Todo oldTodo, TodoVO todoVO) {
        oldTodo.setTitle(todoVO.getTitle());
        oldTodo.setDesc(todoVO.getDesc());
        oldTodo.setDueDate(todoVO.getDueDate());
        oldTodo.setCompleted(todoVO.isCompleted());
        todoRepository.save(oldTodo);
    }

    /**
     * todo delete
     */
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
