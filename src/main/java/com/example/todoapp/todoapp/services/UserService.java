package com.example.todoapp.todoapp.services;

import com.example.todoapp.todoapp.DTO.UserDTO;
import com.example.todoapp.todoapp.modules.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User save(UserDTO userDTO);
}
