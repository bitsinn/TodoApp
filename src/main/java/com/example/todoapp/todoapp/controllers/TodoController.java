package com.example.todoapp.todoapp.controllers;

import com.example.todoapp.todoapp.modules.Todo;
import com.example.todoapp.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String listTodos(Model model) {
        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @GetMapping("/todos/add")
    public String addTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todoEdit";
    }

    @PostMapping("/todos/add")
    public String addTodo(@ModelAttribute Todo todo, Model model) {
        todoService.save(todo);
        model.addAttribute("todo", todoService.findAll());
        return "redirect:/";
    }

    @GetMapping("/todos/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model) {
        model.addAttribute("todo", todoService.findById(id));
        return "todoEdit";
    }

    @PostMapping("/todos/edit/{id}")
    public String editTodo(@PathVariable Long id, @ModelAttribute Todo todo) {
        todoService.save(todo);
        return "redirect:/";
    }

    @GetMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable Long id, @ModelAttribute Todo todo, Model model) {
        todoService.delete(todo);
        model.addAttribute("todos", todo);
        return "redirect:/";
    }
}
