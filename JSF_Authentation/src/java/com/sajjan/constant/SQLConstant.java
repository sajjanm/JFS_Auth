/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajjan.constant;

/**
 *
 * @author lifeo
 */
public class SQLConstant {
    
    
    public static final String INSERT_FORUM="INSERT INTO " +TableConstant.TBL_FORUM +" ( name, message, status) VALUES (?,?,?)";
    public static final String GETBYID = "SELECT * FROM " +TableConstant.TBL_FORUM + " WHERE id = ? ";
    public static final String GETALL = "SELECT * FROM " + TableConstant.TBL_FORUM;
    public static final String DELETEBYID = "DELETE FROM "+TableConstant.TBL_FORUM + " WHERE id=?";
    public static final String EDITBYID = "UPDATE "+TableConstant.TBL_FORUM+ " SET name=?, message=?, status=? WHERE id=?";
}
