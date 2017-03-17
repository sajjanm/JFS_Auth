/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajjan.entity;

/**
 *
 * @author lifeo
 */
public class Forum {
    
    private int id;
    private String name;
    private String message;
    private boolean status;

    public Forum() {
    }

    public Forum(int id, String name, String message, boolean status) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.status = status;
    }

    public Forum(String name, String message, boolean status) {
        this.name = name;
        this.message = message;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
