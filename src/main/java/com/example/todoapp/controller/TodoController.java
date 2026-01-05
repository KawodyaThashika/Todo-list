package com.example.todoapp.controller;

import com.example.todoapp.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", service.getAllTodos());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String title) {
        service.saveTodo(title);
        return "redirect:/";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTodo(@PathVariable Long id) {
        service.toggleTodo(id);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
        return "redirect:/";
    }
}
