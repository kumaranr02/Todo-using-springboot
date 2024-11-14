package com.freshkite.todo.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.freshkite.todo.model.Todomodel;
@Repository
public class InMemory implements TodoRepo {
    
    private final Map<String,Todomodel> todomap = new HashMap<>();
    
    private Integer currentId = 0; 

    @Override
    public List<Todomodel> getAllTodos(){
        return new ArrayList<>(todomap.values());
    }

    @Override
    public Todomodel createTodo(Todomodel todo){
        currentId++; //1
        String convert = String.valueOf(currentId);
        todo.setId(convert);
        todomap.put(convert, todo);
        return todo;
    }
    
    @Override
    public Todomodel updateTodo(Todomodel todo_model, String id){
        if(todomap.containsKey(id)){
            todo_model.setId(id);
            todomap.put(id, todo_model);
            return todo_model;
        }
        return null;
    }

    @Override
    public String deleteTodo(String id){
        if(todomap.containsKey(id)){
            todomap.remove(id);
            return "Deleted successfully";
        }
        return "Id is Invalid";
    }

}
