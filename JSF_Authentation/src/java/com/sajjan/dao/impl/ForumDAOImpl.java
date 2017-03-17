/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajjan.dao.impl;

import com.sajjan.constant.SQLConstant;
import com.sajjan.dao.ForumDAO;
import com.sajjan.dbutil.DbConnection;
import com.sajjan.entity.Forum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lifeo
 */
public class ForumDAOImpl implements ForumDAO{
    
    private DbConnection con= new DbConnection();

    @Override
    public int insert(Forum f) throws SQLException, ClassNotFoundException {
        con.open();
        PreparedStatement stmt = con.init(SQLConstant.INSERT_FORUM);
        stmt.setString(1, f.getName());
        stmt.setString(2, f.getMessage());
        stmt.setBoolean(3, f.isStatus());
        int a = con.executeUpdate();
        con.close();
        return a;
    }

    @Override
    public List<Forum> getAll() throws SQLException, ClassNotFoundException  {
        List<Forum> forumList = new ArrayList<>();
        con.open();
        PreparedStatement stmt = con.init(SQLConstant.GETALL);
        ResultSet rs = con.executeQuery();
        while (rs.next()) {
            Forum forum = mapData(rs);
            forumList.add(forum);
        }
        con.close();
        return forumList;
    }
    
    private Forum mapData(ResultSet rs) throws SQLException{
        Forum f = new Forum();
        f.setId(rs.getInt("id"));
        f.setName(rs.getString("name"));
        f.setMessage(rs.getString("message"));
        f.setStatus(rs.getBoolean("status"));
        return f;
    }

    @Override
    public Forum getById(int id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        con.open();
        PreparedStatement stmt = con.init(SQLConstant.DELETEBYID);
        stmt.setInt(1, id);
        int a = con.executeUpdate();
        con.close();
        return a;
    }

    @Override
    public int edit(Forum f) throws SQLException, ClassNotFoundException {
        con.open();
        PreparedStatement stmt = con.init(SQLConstant.EDITBYID);
        stmt.setString(1, f.getName());
        stmt.setString(2, f.getMessage());
        stmt.setBoolean(3, f.isStatus());
        stmt.setInt(4, f.getId());
        int a = con.executeUpdate();
        con.close();
        return a;
    }
    
}
