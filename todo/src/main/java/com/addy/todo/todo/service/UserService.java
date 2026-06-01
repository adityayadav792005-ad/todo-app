package com.addy.todo.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addy.todo.todo.entity.Users;
import com.addy.todo.todo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepopsitory;

    public List<Users> getall() {
        return userRepopsitory.findAll();
    }

    public String add(Users user) {
        
        Users existingUsers = userRepopsitory.findByEmail(user.getEmail());
        if (existingUsers != null) {
            return "Email already Exists";
        }

         userRepopsitory.save(user);

    return "Registration Successful";
    }

    public String login(Users user) {

        Users existingUsers = userRepopsitory.findByEmail(user.getEmail());

        if (existingUsers == null) {
            return "user not find";
        }
        if (!existingUsers.getPassword().equals(user.getPassword())) {
            return "wrong password";
        }

        return "login successfully";
    }

}
