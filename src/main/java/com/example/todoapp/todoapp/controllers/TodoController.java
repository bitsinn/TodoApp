package com.example.todoapp.todoapp.controllers;

import com.example.todoapp.todoapp.modules.Todo;
import com.example.todoapp.todoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/")
    public String listTodos(@RequestParam(required = false) boolean finished, Todo todo, Model model){
        List<Todo> todos;
        if (finished){
            todos = todoService.finished(true);
        }else {
            todos = todoService.findAll();
        }
        model.addAttribute("todos", todos);
        return "todos";
    }
    @PostMapping("/todos/add")
    public String addTodoForm(Model model){
        model.addAttribute("todo", new Todo());
        return "todoEdit";
    }

    public String addTodo(@ModelAttribute Todo todo, Model model){
        todoService.save(todo);
        model.addAttribute("todos", todoService.findAll());
        return "todos";
    }

    public String deleteTodo(@ModelAttribute Todo todo, Model model){
        todoService.delete(todo);
        model.addAttribute("todos", todo);
        return "redirect:/";
    }
}
