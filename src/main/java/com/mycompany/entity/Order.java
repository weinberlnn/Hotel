/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

/**
 *
 * @author mac
 */
public class Order {
    private int orderid;
    private int userid;
    private String usertruename;
    private String userphone;
    private int bookday;
    private double totalcost;
    private String hotename;
    private String roomstyle;

    public Order(int orderid, int userid, String usertruename, String userphone, int bookday, double totalcost, String hotename, String roomstyle) {
        this.orderid = orderid;
        this.userid = userid;
        this.usertruename = usertruename;
        this.userphone = userphone;
        this.bookday = bookday;
        this.totalcost = totalcost;
        this.hotename = hotename;
        this.roomstyle = roomstyle;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsertruename() {
        return usertruename;
    }

    public void setUsertruename(String usertruename) {
        this.usertruename = usertruename;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public int getBookday() {
        return bookday;
    }

    public void setBookday(int bookday) {
        this.bookday = bookday;
    }

    public double getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(double totalcost) {
        this.totalcost = totalcost;
    }

    public String getHotename() {
        return hotename;
    }

    public void setHotename(String hotename) {
        this.hotename = hotename;
    }

    public String getRoomstyle() {
        return roomstyle;
    }

    public void setRoomstyle(String roomstyle) {
        this.roomstyle = roomstyle;
    }
    
}
