package com.addy.todo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addy.todo.todo.entity.Users;



public interface UserRepository extends JpaRepository<Users, Integer> {
     Users findByEmail(String email);
}
