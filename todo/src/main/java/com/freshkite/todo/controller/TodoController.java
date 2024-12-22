package com.freshkite.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.freshkite.todo.model.Todomodel;
import com.freshkite.todo.service.TodoService;


@RestController
public class TodoController {
    
    @Autowired
    TodoService tservice;

    @GetMapping("/todos")
    public List<Todomodel> getController(){
        
        return tservice.getService();
    }

    @PostMapping("/todos")
    public Todomodel createController(@RequestBody Todomodel todo_model) {
        
        return tservice.createService(todo_model);
    }

    @PutMapping("/todos/{id}")
    public Todomodel updateController(@RequestBody Todomodel todo_model, @PathVariable String id) {
        
        return tservice.updateService(todo_model,id);
    }

    @DeleteMapping("/todos/{id}")
    public String deleteController(@PathVariable String id ) {

        return tservice.deleteService(id);
    }
    
    
}
