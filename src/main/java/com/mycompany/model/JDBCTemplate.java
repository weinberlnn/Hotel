/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WeinberLnn
 */
public class JDBCTemplate{
    public DBManager dBManager;
    public Connection conn;
    public String username;
    public JDBCTemplate(){
        dBManager = new DBManager();
        conn = dBManager.getConnection();
    }
    public boolean checkUserWhenRegister(String username,String password,String email){
        String checksql = "SELECT * FROM HOTELUSER WHERE USERNAME=? and PASSWORD=? and USEREMAIL=?";
        try {
            PreparedStatement pst = conn.prepareStatement(checksql);
            pst.setString(1,username);
            pst.setString(2,password);
            pst.setString(3,email);
            ResultSet result = pst.executeQuery();
            if(result.next()){
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean register(String username,String password,String email){
        String registersql = "INSERT INTO HOTELUSER VALUES(?,?,?,?,?)";
        try{
            PreparedStatement pstm = conn.prepareStatement(registersql);
            pstm.setString(1,null);
            pstm.setString(2,username);
            pstm.setString(3,password);
            pstm.setString(4, email);
            pstm.setString(5,null);
            pstm.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    public boolean login(String username,String password){
        String loginsql = "SELECT * FROM HOTELUSER WHERE USERNAME=? AND PASSWORD=?";
        try{
            PreparedStatement pstm = conn.prepareStatement(loginsql);
            pstm.setString(1,username);
            pstm.setString(2, password);
            ResultSet result = pstm.executeQuery();
            if(result.next()){
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
