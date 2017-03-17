/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajjan.controller;

import com.sajjan.dao.ForumDAO;
import com.sajjan.dao.impl.ForumDAOImpl;
import com.sajjan.entity.Forum;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author lifeo
 */
@ManagedBean(name = "forumController")
@SessionScoped
public class ForumController implements Serializable {

    private List<Forum> forumResult = new ArrayList<>();
    ForumDAO forumDAO = new ForumDAOImpl();

    private static final long serialVersionUID = 1L;
    private String name;
    private String message;
    private boolean status;
    private Integer editedId;

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

    public Integer getEditedId() {
        return editedId;
    }

    public void setEditedId(Integer editedId) {
        this.editedId = editedId;
    }

    public String insertData() throws SQLException, ClassNotFoundException {
        int r = forumDAO.insert(new Forum(name, message, status));
        if (r == 1) {
            return "success.xhtml?faces-redirect=true";
        } else {
            return "not inserted";
        }
    }
    
    public List<Forum> showValues(){

        try {
            
            return forumDAO.getAll();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ArrayList<Forum>();
        }
    }
    
    public String initToEdit() throws SQLException, ClassNotFoundException{
        
        int r = forumDAO.edit(new Forum(editedId, name, message, status));
        if (r == 1) {
            name=null;message=null;
            return "forum.xhtml?faces-redirect=true";
        } else {
            return "not inserted";
        }
    }

    public String initToDelete() throws SQLException, ClassNotFoundException{
        System.out.println("edited id: "+editedId);
        int r =forumDAO.delete(editedId);
        if (r == 1) {
            return "success.xhtml?faces-redirect=true";
        } else {
            return "not inserted";
        }
    }
    
}
