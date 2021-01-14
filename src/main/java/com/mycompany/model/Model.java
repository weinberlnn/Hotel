/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.entity.DataMessage;
import java.util.Observable;

/**
 *
 * @author WeinberLnn
 */
public class Model extends Observable{
    public JDBCTemplate jdbcTemplate;
    public DataMessage dm = new DataMessage();
    public String username;
    public Model(){
        this.jdbcTemplate = new JDBCTemplate();
    }
    public void checkUserWhenRegister(String username,String password,String email){
        if(jdbcTemplate.checkUserWhenRegister(username, password, email)){
            dm.setCheckflag(0);
            this.setChanged();
            this.notifyObservers(dm);
        }
        else{
            dm.setCheckflag(1);
            this.setChanged();
            this.notifyObservers(dm);
        }
    }
    public void register(String username,String password,String email){
        jdbcTemplate.register(username, password, email);
    }
    public void login(String username,String password){
        if(jdbcTemplate.login(username, password)){
            dm.setLoginflag(1);
            this.setChanged();
            this.notifyObservers(dm);
        }
        else{
            dm.setLoginflag(0);
            this.setChanged();
            this.notifyObservers(dm);
        }
    }
    
}
