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
public class LikeItem {
    private int likeid;
    private int userid;
    private int hotelid;
    public LikeItem(int likeid, int userid, int hotelid) {
        this.likeid = likeid;
        this.userid = userid;
        this.hotelid = hotelid;
    }

    public int getLikeid() {
        return likeid;
    }

    public void setLikeid(int likeid) {
        this.likeid = likeid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }
    
}
