/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.entity.DataMessage;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    public String getMD5String(String password){
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest  = md5.digest(password.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }
    public void checkUserWhenRegister(String username,String password,String email){
        if(jdbcTemplate.checkUserWhenRegister(username,getMD5String(password), email)){
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
        jdbcTemplate.register(username,getMD5String(password), email);
    }
    public void login(String username,String password){
        if(jdbcTemplate.login(username,getMD5String(password))){
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
