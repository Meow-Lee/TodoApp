package com.example.TodoApp.controller;

import com.example.TodoApp.domain.Todo;
import com.example.TodoApp.service.TodoService;
import com.example.TodoApp.vo.TodoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final TodoService todoService;


    /**
     * todo home controller
     */
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("newTodo", new Todo());
        model.addAttribute("todos", todoService.findTodos());
        return "home";
    }

    /**
     * todo add controller
     */
    @PostMapping("/add")
    public String add(@ModelAttribute TodoVO todoVO, Model model) {
        logger.info("Data added");
        logger.info("Title: " + todoVO.getTitle() + "\n Description: " + todoVO.getDesc() + "\n DueDate: " + todoVO.getDueDate());
        logger.info("Completed: " + todoVO.isCompleted());
        todoService.addTodo(todoVO);
        return "redirect:/home";
    }

    /**
     * todo update controller
     */
    @GetMapping("/updateForm/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model) {
        logger.info("ID : " + id);

        Todo todo = todoService.findTodoById(id);
        model.addAttribute("updateTodo", todo);
        return "updateForm";
    }

    @PostMapping("/updateForm/{id}")
    public String update(@PathVariable(name = "id") Long id, @ModelAttribute TodoVO todoVO) {
        Todo updateTodo = todoService.findTodoById(id);
        todoService.updateTodo(updateTodo, todoVO);
        return "redirect:/home";
    }

    /**
     * todo delete controller
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        todoService.deleteTodo(id);
        return "redirect:/home";
    }

    /**
     * todo detail controller
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id") Long id, Model model) {
        Todo detailTodo = todoService.findTodoById(id);
        model.addAttribute("detailTodo", detailTodo);
        return "detail";
    }

}
