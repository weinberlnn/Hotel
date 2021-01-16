/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mac
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
                System.out.println(URL+" Get Connected Successfully ...");
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
}
