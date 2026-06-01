package com.addy.todo.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addy.todo.todo.entity.Todo;
import com.addy.todo.todo.service.TodoService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // ADD TODO
    @PostMapping("/add/{email}")
    public Todo addTodo(
            @PathVariable String email,
            @RequestBody Todo todo){

        return todoService.addTodo(email, todo);
    }

    // GET USER TODOS
    @GetMapping("/{email}")
    public List<Todo> getTodos(
            @PathVariable String email){

        return todoService.getTodos(email);
    }
    @DeleteMapping("/delete/{id}")
public String deleteTodo(@PathVariable Integer id) {
    todoService.deleteTodo(id);
    return "Todo Deleted Successfully";
}

}