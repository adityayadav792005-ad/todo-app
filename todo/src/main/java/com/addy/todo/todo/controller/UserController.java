package com.addy.todo.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.addy.todo.todo.entity.Users;
import com.addy.todo.todo.service.UserService;

import jakarta.validation.Valid;

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
    public String add(@Valid @RequestBody Users user ,BindingResult result){
        if(result.hasErrors()){
            return result.getFieldError().getDefaultMessage();
        }
        return userService.add(user);
    }
    @PostMapping("/login")
    public String login ( @RequestBody Users user){
    
         return  userService.login(user);
    }

}
