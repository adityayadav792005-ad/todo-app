package com.addy.todo.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addy.todo.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List <Todo> findByUserEmail (String email);

}
