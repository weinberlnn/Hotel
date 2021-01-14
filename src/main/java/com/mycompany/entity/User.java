/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

/**
 *
 * @author WeinberLnn  
 */
public class User {
    private int userid;
    private String username;
    private String password;
    private String useremail;
    private String usersculpture;

    public User(int userid, String username, String password, String useremail, String usersculpture) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.useremail = useremail;
        this.usersculpture = usersculpture;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsersculpture() {
        return usersculpture;
    }

    public void setUsersculpture(String usersculpture) {
        this.usersculpture = usersculpture;
    }
    
}
