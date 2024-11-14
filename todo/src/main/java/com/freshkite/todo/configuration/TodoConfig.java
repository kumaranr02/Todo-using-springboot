package com.freshkite.todo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.freshkite.todo.dal.InMemory;
import com.freshkite.todo.dal.MongoRepo;
import com.freshkite.todo.dal.TodoRepo;

@Configuration
public class TodoConfig {
    @Value("${storage}")
    private String storage;

    @Autowired
    private final InMemory inMemory;

    @Autowired
    private final MongoRepo mongo;

    public TodoConfig(InMemory inMemory, MongoRepo mongo) {
        this.inMemory = inMemory;
        this.mongo = mongo;
    }

    @Bean(name="todoRepo")
    public TodoRepo todoRepo(){
        if("mongo".equals(storage)){
            return mongo;
        }
        return inMemory;
    }
    
}
