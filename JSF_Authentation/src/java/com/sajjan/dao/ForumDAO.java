/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajjan.dao;

import com.sajjan.entity.Forum;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lifeo
 */
public interface ForumDAO {

    public int insert(Forum f) throws SQLException, ClassNotFoundException;

    public List<Forum> getAll() throws SQLException, ClassNotFoundException;

    public Forum getById(int id) throws SQLException, ClassNotFoundException;

    public int delete(int id) throws SQLException, ClassNotFoundException;

    public int edit(Forum f) throws SQLException, ClassNotFoundException;

}
