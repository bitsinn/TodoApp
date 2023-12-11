package com.example.todoapp.todoapp.repositories;

import com.example.todoapp.todoapp.modules.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByFinished(boolean finished);
}
