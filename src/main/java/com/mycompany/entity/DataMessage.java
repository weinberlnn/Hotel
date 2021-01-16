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
public class DataMessage {
    private int checkflag;
    private int registerflag;
    private int loginflag;
    public DataMessage(){
        registerflag = 0;
        loginflag = 0;
        checkflag = 0;
    }

    public int getRegisterflag() {
        return registerflag;
    }

    public void setRegisterflag(int registerflag) {
        this.registerflag = registerflag;
    }

    public int getLoginflag() {
        return loginflag;//1 0
    }

    public void setLoginflag(int loginflag) {
        this.loginflag = loginflag;
    }

    public int getCheckflag() {
        return checkflag;
    }

    public void setCheckflag(int checkflag) {
        this.checkflag = checkflag;
    }
    
}
