package com.example.todoapp.todoapp.repositories;

import com.example.todoapp.todoapp.modules.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByFinished (boolean finished);
}
