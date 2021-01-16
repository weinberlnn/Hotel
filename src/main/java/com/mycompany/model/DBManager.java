/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author WeinberLnn
 */
public class DBManager {
    private static final String URL = "jdbc:derby:HotelBook";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
    Connection conn;
    public DBManager(){
        establishConnection();
    }
    public void establishConnection(){
        if(conn == null){
            try{
                conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
                System.out.println(URL + " successfully connect...");
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
}
