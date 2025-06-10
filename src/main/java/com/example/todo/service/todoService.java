package com.example.todo.service;

import com.example.todo.model.todo;
import com.example.todo.repository.todoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class todoService {
    private final todoRepository repository;

     public todoService(todoRepository repository){
        this.repository = repository;
    }

    public List<todo> getAlltodos(){
        return repository.findAll();
    }

     public void addtodo(String name, String text){
        repository.save(new todo(name,text));
    }
}