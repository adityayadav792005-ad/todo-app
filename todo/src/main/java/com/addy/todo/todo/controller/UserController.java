package com.addy.todo.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.addy.todo.todo.entity.Users;
import com.addy.todo.todo.service.UserService;

@RestController
@CrossOrigin("http://localhost:5173")
public class UserController {

@Autowired
private UserService userService;
     @GetMapping("/user")
    public List<Users> get(){
        return userService.getall();
    }
     @PostMapping("/user")
    public String add(@RequestBody Users user){
        return userService.add(user);
    }
    @PostMapping("/login")
    public String login (@RequestBody Users user){
         return  userService.login(user);
    }

}
