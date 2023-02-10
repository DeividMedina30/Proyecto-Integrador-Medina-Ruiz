package com.example.demo.model;

import jakarta.persistence.Entity;

@Entity
public class Usuario {

    private Long id;

    private String name;

    private String password;

    public Usuario(Long id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
