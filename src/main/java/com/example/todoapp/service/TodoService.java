package com.example.todoapp.service;

import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public void saveTodo(String title) {
        repository.save(new Todo(title));
    }

    public void toggleTodo(Long id) {
        Todo todo = repository.findById(id).orElseThrow();
        todo.setCompleted(!todo.isCompleted());
        repository.save(todo);
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }
}
