package com.freshkite.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.freshkite.todo.dal.TodoRepo;
import com.freshkite.todo.model.Todomodel;

@Service
public class TodoService {
    
    public TodoRepo trepo;

    public TodoService(@Qualifier("todoRepo") TodoRepo trepo){
        this.trepo=trepo;
    }

    public List<Todomodel> getService(){
        return trepo.getAllTodos();
    }

    public Todomodel createService(Todomodel todo_model){
        return trepo.createTodo(todo_model);
    }

    public Todomodel updateService(Todomodel todo_model, String id){
        return trepo.updateTodo(todo_model, id);
    }

    public String deleteService(String id){
        return trepo.deleteTodo(id);
    }
}
