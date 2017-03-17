/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajjan.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author lifeo
 */
@ManagedBean (name = "bean1")
@SessionScoped
public class Bean implements Serializable{

    private String name;
    private String pass;
    public boolean isLogged = false;
    
    public Bean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String action(){
        
        if(name.equals(pass)){
            isLogged = true;
            return "forum.xhtml?faces-redirect=true";
        }else{
            return null;
        }
        
        
    }
    
}
