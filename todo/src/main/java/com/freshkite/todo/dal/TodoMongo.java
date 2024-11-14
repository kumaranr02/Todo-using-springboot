package com.freshkite.todo.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.freshkite.todo.model.Todomodel;
@Repository
public interface TodoMongo extends MongoRepository<Todomodel, String>{
    
}
