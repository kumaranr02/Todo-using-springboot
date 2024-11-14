package com.freshkite.todo.dal;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.freshkite.todo.model.Todomodel;
@Repository
public interface TodoRepo {
    public List<Todomodel> getAllTodos();
    public Todomodel createTodo(Todomodel todo_model);
    public Todomodel updateTodo(Todomodel todo_model, String id);
    public String deleteTodo(String id);
}
