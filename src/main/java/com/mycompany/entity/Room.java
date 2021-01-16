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
public class Room {
    private int roomid;
    private int hotelid;
    private String roomstyle;
    private double roomcost;
    private int roomnumber;

    public Room(int roomid, int hotelid, String roomstyle, double roomcost, int roomnumber) {
        this.roomid = roomid;
        this.hotelid = hotelid;
        this.roomstyle = roomstyle;
        this.roomcost = roomcost;
        this.roomnumber = roomnumber;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public String getRoomstyle() {
        return roomstyle;
    }

    public void setRoomstyle(String roomstyle) {
        this.roomstyle = roomstyle;
    }

    public double getRoomcost() {
        return roomcost;
    }

    public void setRoomcost(double roomcost) {
        this.roomcost = roomcost;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }
    
}
