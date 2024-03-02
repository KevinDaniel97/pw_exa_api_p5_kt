package com.example.demo.service.to;

import java.io.Serializable;

public class EstudianteTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;

    // SET y GET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}