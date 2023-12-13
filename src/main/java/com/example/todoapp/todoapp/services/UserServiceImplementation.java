package com.example.todoapp.todoapp.services;

import com.example.todoapp.todoapp.DTO.UserDTO;
import com.example.todoapp.todoapp.modules.Role;
import com.example.todoapp.todoapp.modules.User;
import com.example.todoapp.todoapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository repository;

    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail(), List.of(new Role("ROLE_USER")));
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
