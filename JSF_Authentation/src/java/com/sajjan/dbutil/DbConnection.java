/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajjan.dbutil;

import com.sajjan.constant.DbConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lifeo
 */
public class DbConnection {

    Connection conn;
    PreparedStatement stmt;

    public DbConnection() {
    }

    public void open() throws ClassNotFoundException, SQLException {

        Class.forName(DbConstant.DB_DRIVER);
        conn = DriverManager.getConnection(DbConstant.DB_URL, DbConstant.USER, DbConstant.PASS);

    }

    public PreparedStatement init(String sql) throws SQLException {
        stmt = conn.prepareStatement(sql);
        return stmt;
    }

    public int executeUpdate() throws SQLException {
        return stmt.executeUpdate();
    }

    public ResultSet executeQuery() throws SQLException {
        return stmt.executeQuery();
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
        }
    }

}
