package com.example.todoapp.todoapp.controllers;

import com.example.todoapp.todoapp.DTO.UserDTO;
import com.example.todoapp.todoapp.services.UserService;
import com.example.todoapp.todoapp.services.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserServiceImplementation service;

    @GetMapping("/register")
    public String registerUserForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registerForm";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDTO userDTO, Model model) {
        service.save(userDTO);
        model.addAttribute("user", service.findAll());
        return "redirect:/todos";
    }
}
