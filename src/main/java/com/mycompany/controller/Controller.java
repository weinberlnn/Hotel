/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.Model;
import com.mycompany.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mac
 */
public class Controller implements ActionListener{
    public View view;
    public Model model;
    
    public Controller(View view,Model model){
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "Log in":
                String loginusername = this.view.unInput.getText();
                String loginpassword = new String(this.view.pwInput.getPassword());
                System.out.println(loginpassword);
                if(this.model.login(loginusername, loginpassword)){
                    this.model.getHotelInfo();
                    this.view.Hotelinformation();
                }
                break;
            case "Get Registe":
                String registerusername = this.view.registerunInput.getText();
                String registerpassword = new String(this.view.registerpwInput1.getPassword());
                String registeremail = this.view.EmailInput.getText();
                if(!this.model.checkUserWhenRegister(registerusername))
                {
                    System.out.println("username has exist!");
                }
                else{
                    this.model.register(registerusername, registerpassword, registeremail);
                    this.view.View1();
                }
                break;
            case "Register":
                this.view.Register();
                break;
            case "Get Userinfo":
                this.model.getUserInfo();
                break;
            case "Modify Password":
                String password = null;
                this.model.modifyPassword(password);
                break;
            case "Logout":
                this.model.logout();
            //Get Order List;
            case "My OrderLIst":
                this.model.getOrderInfo();
                this.view.Orderinformation();
                break;
            case "Cancel Order":
                int orderid = 0;
                this.model.cancelOrder(orderid);
                break;
            //Order List View that back to HotelList;
            case "Back to Hotelinfo":
//                this.view.HotellistScroll.removeAll();
                this.model.getHotelInfo();
                this.view.Hotelinformation();
                break;
            case "RoomInfo":
                int hotelid = 0;
                this.model.getRoomInfo(hotelid);
                this.view.Roominformation();
                break;
            //Room List View that back to HotelList;
            case "Back2":
                this.model.getHotelInfo();
                break;
            case "Form Order":
                int roomid = 0;
                int roomnumber = 1;
                String usertruename = null;
                String userphone = null;
                int bookday = 2;
                double totalcost = 255.5;
                String hotelname = null;
                String roomstyle = null;
                if(this.model.booking(roomid, roomnumber)){
                    this.model.formOrder(usertruename, userphone, bookday, totalcost, hotelname, roomstyle);
                }
                else{
                    System.out.println("hotel has no empty room");
                }
                break;
            //Form Order View that back to RoomInfo View
            case "Back3":
                this.model.getRoomInfoIfHotelNotNull();
                break;
            case "Pay":
                this.model.pay();
                //Pay successfully and Back to HotelList;
                this.model.getHotelInfo();
                break;
            case "AddLikeItem":
                int likehotelid = 0;
                this.model.addLikeItem(likehotelid);
            case "DeleteLikeItem":
                int dislikehotelid = 0;
                this.model.deleteLikeItem(dislikehotelid);
        }
    }
    
}
