package com.example.todo.model;

import jakarta.persistence.*;

@Entity
public class todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String text;

    public todo() {
    }

    public todo(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getText(){
        return text;
    }

}