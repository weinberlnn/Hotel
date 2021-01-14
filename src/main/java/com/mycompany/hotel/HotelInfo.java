/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mac
 */
public class HotelInfo {
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    public HotelInfo(){
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    public ResultSet getHotelInfo(){
        String sql = "SELECT * FROM HOTEL";
        ResultSet resultSet = null;
        try{
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }
    public static void main(String args[]){
        HotelInfo hotelInfo = new HotelInfo();
        ResultSet result = hotelInfo.getHotelInfo();
        try{
           while(result.next()){
                System.out.println(result.getString("HOTELNAME"));
           }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
