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
    public Todomodel postMethodName(@RequestBody Todomodel Todoentry) {
        
        return tservice.createService(Todoentry);
    }

    @PutMapping("/todos/{id}")
    public Todomodel putMethodName(@RequestBody Todomodel Todoentry, @PathVariable String id) {
        
        return tservice.updateService(Todoentry,id);
    }

    @DeleteMapping("/todos/{id}")
    public String deleteMethodName(@PathVariable String id ) {

        return tservice.deleteService(id);
    }
    
    
}
