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
public class Hotel {
    private int hotelid;
    private String hotelname;
    private double hotelcost;
    private String hotelstyle;
    private String hotelbreakfast;
    private String hotelpicture;
    private int hotelnumber;
    public Hotel(int hotelid, String hotelname, double hotelcost, String hotelstyle, String hotelbreakfast, String hotelpicture, int hotelnumber) {
        this.hotelid = hotelid;
        this.hotelname = hotelname;
        this.hotelcost = hotelcost;
        this.hotelstyle = hotelstyle;
        this.hotelbreakfast = hotelbreakfast;
        this.hotelpicture = hotelpicture;
        this.hotelnumber = hotelnumber;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public double getHotelcost() {
        return hotelcost;
    }

    public void setHotelcost(double hotelcost) {
        this.hotelcost = hotelcost;
    }

    public String getHotelstyle() {
        return hotelstyle;
    }

    public void setHotelstyle(String hotelstyle) {
        this.hotelstyle = hotelstyle;
    }

    public String getHotelbreakfast() {
        return hotelbreakfast;
    }

    public void setHotelbreakfast(String hotelbreakfast) {
        this.hotelbreakfast = hotelbreakfast;
    }

    public String getHotelpicture() {
        return hotelpicture;
    }

    public void setHotelpicture(String hotelpicture) {
        this.hotelpicture = hotelpicture;
    }

    public int getHotelnumber() {
        return hotelnumber;
    }

    public void setHotelnumber(int hotelnumber) {
        this.hotelnumber = hotelnumber;
    }
    
}
