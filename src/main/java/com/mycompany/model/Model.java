/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.entity.DataMessage;
import com.mycompany.entity.Hotel;
import com.mycompany.entity.Order;
import com.mycompany.entity.Room;
import com.mycompany.entity.User;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author WeinberLnn
 */
public class Model extends Observable{
    public JDBCTemplate jdbcTemplate;
    public DataMessage dm = new DataMessage();
    public User user;
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
    public boolean checkUserWhenRegister(String username){
        dm.initialize();
        if(jdbcTemplate.checkUserWhenRegister(username)){
            dm.setCheckflag(0);
            this.setChanged();
            this.notifyObservers(dm);
            return true;
        }
        else{
            dm.setCheckflag(1);
            this.setChanged();
            this.notifyObservers(dm);
            return false;
        }
    }
    public void register(String username,String password,String email){
        jdbcTemplate.register(username,getMD5String(password), email);
    }
    public boolean login(String username,String password){
        dm.initialize();
        if(jdbcTemplate.login(username,password)!=null){
            user = jdbcTemplate.login(username, password);
            dm.setLoginflag(1);
            this.setChanged();
           
            this.notifyObservers(dm);
            
            return true;
        }
        else{
            dm.setLoginflag(0);
            this.setChanged();
            
            this.notifyObservers(dm);
            
            return false;
        }
    }
    public void modifyPassword(String password){
        jdbcTemplate.modifyPassword(user.getUsername(), password);
    }
    public void getUserInfo(){
        dm.initialize();
        dm.setSource(user);
        dm.setGetuserinfoflag(1);
        this.setChanged();
        this.notifyObservers(dm);
    }
    public void logout(){
        jdbcTemplate.logout();
        dm.initialize();
        user = null;
        dm.setLoginflag(0);
        this.setChanged();
        this.notifyObservers(dm);
    }
    public void getHotelInfo(){
        dm.initialize();
        ArrayList<Hotel> hotelcollection = jdbcTemplate.getHotelInfo(user.getUserid());
        if(hotelcollection!=null){
            dm.setGethotelinfoflag(1);
            dm.setSource(hotelcollection);
            this.setChanged();
            this.notifyObservers(dm);
        }
        else{
            dm.setGethotelinfoflag(0);
            this.setChanged();
            this.notifyObservers(dm);
        }
    }
    public void getHotelInfoByStyleandBreakfast(String hotelstyle,String hotelbreakfast){
        dm.initialize();
        ArrayList<Hotel> hotelcollection = jdbcTemplate.selectHotelInfo(hotelstyle,hotelbreakfast);
        if(hotelcollection!=null){
            dm.setGethotelinfoflag(1);
            dm.setSource(hotelcollection);
            this.setChanged();
            this.notifyObservers(dm);
        }
        else{
            dm.setGethotelinfoflag(0);
            this.setChanged();
            this.notifyObservers(dm);
        }
    }
    public void getRoomInfo(int hotelid){
        dm.initialize();
        ArrayList<Room> roomcollection = jdbcTemplate.getRoomInfo(hotelid);
        if(roomcollection!=null){
            dm.setGetroominfoflag(1);
            dm.setSource(roomcollection);
            this.setChanged();
            this.notifyObservers(dm);
        }
        else{
            dm.setGetroominfoflag(0);
            this.setChanged();
            this.notifyObservers(dm);
        }
    }
    public void booking(int roomid,int roomnumber){
        dm.initialize();
        if(jdbcTemplate.booking(roomid, roomnumber)){
            dm.setRoomexistflag(1);
            this.setChanged();
            this.notifyObservers(dm);
        }
        else{
            dm.setRoomexistflag(0);
            this.setChanged();
            this.notifyObservers(dm);
            
        }
    }
    public void formOrder(String usertruename,String userphone,int bookday,double totalcost,String hotelname,String roomstyle){
        jdbcTemplate.formOrder(user.getUserid(), usertruename, userphone, bookday, totalcost, hotelname, roomstyle);
    }
    public void getOrderInfo(){
        dm.initialize();
        ArrayList<Order> ordercollection = jdbcTemplate.getOrderInfo(user.getUserid());
        if(ordercollection!=null){
            dm.setGetorderinfoflag(1);
            dm.setSource(ordercollection);
            this.setChanged();
            this.notifyObservers(dm);
        }
        else{
            dm.setGetorderinfoflag(0);
            this.setChanged();
            this.notifyObservers(dm);
        }
    }
    public void pay(){
        dm.initialize();
        dm.setPayflag(1);
        this.setChanged();
        this.notifyObservers(dm);
    }
    public void addLikeItem(int hotelid){
        jdbcTemplate.addLikeItem(user.getUserid(), hotelid);
    }
    public void deleteLikeItem(int hotelid){
        jdbcTemplate.deleteLikeItem(user.getUserid(), hotelid);
    }
}
