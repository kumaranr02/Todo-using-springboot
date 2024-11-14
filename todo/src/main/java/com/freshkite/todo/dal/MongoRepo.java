package com.freshkite.todo.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freshkite.todo.model.Todomodel;
@Repository
public class MongoRepo implements TodoRepo{
    @Autowired
    private TodoMongo mrepo;
        
        @Override
        public List<Todomodel> getAllTodos(){
            System.out.println("Get repo: ");
            return mrepo.findAll();
        }

        @Override
        public Todomodel createTodo(Todomodel todo_model){
            return mrepo.save(todo_model);
        }

        @Override
        public Todomodel updateTodo(Todomodel todo_model, String id){
            Todomodel oldId = mrepo.findById(id).get();
            oldId.setTitle(todo_model.getTitle());
            oldId.setDescription(todo_model.getDescription());
            return mrepo.save(oldId);
        }

        @Override
        public String deleteTodo(String id){
            mrepo.deleteById(id);
            return "Delete Successfully";
        }
    }
