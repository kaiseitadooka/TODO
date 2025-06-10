package com.example.todo.controller;

import com.example.todo.service.todoService;
import com.example.todo.model.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class todoController {
     private final todoService service;

    public todoController(todoService service){
        this.service =service;
    }

    @GetMapping("/")
    public String index(Model model){
        List<todo> todos = service.getAlltodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name,
                       @RequestParam String text,
                       Model model) {
        if(name.isBlank() || text.isBlank()){
            model.addAttribute("error", "名前とメッセージは必須です");

        }else{
            service.addtodo((name), text);
        }
        
        List<todo> todos = service.getAlltodos();
        model.addAttribute("todos", todos);
        return "index";
    }
}