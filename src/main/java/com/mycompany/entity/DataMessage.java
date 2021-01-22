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
    private int gethotelinfoflag;
    private int getroominfoflag;
    private int getorderinfoflag;
    private int payflag;
    private int roomexistflag;
    private int getuserinfoflag;
    private int searchflag;
    private Object source;
    public DataMessage(){
        registerflag = 0;
        loginflag = 0;
        checkflag = 0;
        gethotelinfoflag=0;
        getroominfoflag=0;
        getorderinfoflag=0;
        payflag=0;
        roomexistflag=0;
        getuserinfoflag=0;
        searchflag=0;
        source = null;
    }

    public int getRegisterflag() {
        return registerflag;
    }

    public void setRegisterflag(int registerflag) {
        this.registerflag = registerflag;
    }
    
    public int getSearchflag(){
        return searchflag;
    }
    
    public void setSearchflag(int searchflag){
        this.searchflag = searchflag;
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

    public int getGethotelinfoflag() {
        return gethotelinfoflag;
    }

    public void setGethotelinfoflag(int gethotelinfoflag) {
        this.gethotelinfoflag = gethotelinfoflag;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public int getGetroominfoflag() {
        return getroominfoflag;
    }

    public void setGetroominfoflag(int getroominfoflag) {
        this.getroominfoflag = getroominfoflag;
    }

    public int getPayflag() {
        return payflag;
    }

    public void setPayflag(int payflag) {
        this.payflag = payflag;
    }

    public int getRoomexistflag() {
        return roomexistflag;
    }

    public void setRoomexistflag(int roomexistflag) {
        this.roomexistflag = roomexistflag;
    }

    public int getGetorderinfoflag() {
        return getorderinfoflag;
    }

    public void setGetorderinfoflag(int getorderinfoflag) {
        this.getorderinfoflag = getorderinfoflag;
    }

    public int getGetuserinfoflag() {
        return getuserinfoflag;
    }

    public void setGetuserinfoflag(int getuserinfoflag) {
        this.getuserinfoflag = getuserinfoflag;
    }
    
    public void initialize(){
        loginflag=0;
        registerflag = 0;
        checkflag = 0;
        gethotelinfoflag=0;
        getroominfoflag=0;
        getorderinfoflag=0;
        payflag=0;
        roomexistflag=0;
        getuserinfoflag=0;
        searchflag = 0;
        source = null;
    }
}
