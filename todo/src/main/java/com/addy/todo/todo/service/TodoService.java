
package com.addy.todo.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addy.todo.todo.entity.Todo;
import com.addy.todo.todo.entity.Users;
import com.addy.todo.todo.repository.TodoRepository;
import com.addy.todo.todo.repository.UserRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    // ADD TODO USING EMAIL
    public Todo addTodo(String email, Todo todo){

        Users user = userRepository.findByEmail(email);

        if(user == null){
            return null;
        }

        todo.setUser(user);

        return todoRepository.save(todo);
    }

    // GET TODOS BY EMAIL
    public List<Todo> getTodos(String email){

        return todoRepository.findByUserEmail(email);
    }

 public void deleteTodo(Integer id) {
    todoRepository.deleteById(id);
}
}