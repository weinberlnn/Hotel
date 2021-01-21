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
    private int hotelid = 0;
    private int roomid = 0;
    public Controller(View view,Model model){
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.contains(",")){
            String result[] = command.split(",");
            command = result[0];
            hotelid = Integer.valueOf(result[1]);
        }
        else if(command.contains("-")){
            System.out.println(command);
            String result[] = command.split("-");
            command = result[0];
            roomid = Integer.valueOf(result[1]);
        }
        switch(command){
            case "Log in":
                String loginusername = this.view.userInput.getText();
                String loginpassword = this.view.passInput.getText();
                if(this.model.login(loginusername, loginpassword)){
                    this.model.getHotelInfo();
                }
                break;
            case "Get Register":
                this.view.Register();
                break;
            case "Register":
                String registerusername = this.view.userInput2.getText();
                String registerpassword = this.view.passInput2.getText();
                String registeremail = this.view.emailInput.getText();
                if(this.model.checkUserWhenRegister(registerusername)){
                    this.model.register(registerusername, registerpassword, registeremail);
                    this.view.Login();
                }
                break;
            case "More Information":
                this.model.getRoomInfo(hotelid);
                break;
            case "Buy":
                this.view.FormOrder();
                break;
            case "Pay":
                System.out.println(roomid);
                String truename = this.view.truename.getText();
                String phone = this.view.phone.getText();
                int bookday = Integer.valueOf(this.view.bookday.getText());
                if(this.model.booking(roomid)){
                    this.model.formOrder(truename, phone, bookday);
                    this.model.pay();
                }
//            case "Get Userinfo":
//                this.model.getUserInfo();
//                break;
//            case "Modify Password":
//                String password = null;
//                this.model.modifyPassword(password);
//                break;
//            case "Logout":
//                this.model.logout();
//            //Get Order List;
//            case "My OrderLIst":
//                this.model.getOrderInfo();
//                this.view.Orderinformation();
//                break;
//            case "Cancel Order":
//                int orderid = 0;
//                this.model.cancelOrder(orderid);
//                break;
//            //Order List View that back to HotelList;
//            case "Back to Hotelinfo":
//                this.model.getHotelInfo();
//                this.view.Hotelinformation();
//                break;
//            case "RoomInfo":
//                int hotelid = 0;
//                this.model.getRoomInfo(hotelid);
//                this.view.Roominformation();
//                break;
//            //Room List View that back to HotelList;
//            case "Back2":
//                this.model.getHotelInfo();
//                break;
//            case "Form Order":
//                int roomid = 0;
//                int roomnumber = 1;
//                String usertruename = null;
//                String userphone = null;
//                int bookday = 2;
//                double totalcost = 255.5;
//                String hotelname = null;
//                String roomstyle = null;
//                if(this.model.booking(roomid, roomnumber)){
//                    this.model.formOrder(usertruename, userphone, bookday, totalcost, hotelname, roomstyle);
//                }
//                else{
//                    System.out.println("hotel has no empty room");
//                }
//                break;
//            //Form Order View that back to RoomInfo View
//            case "Back3":
//                this.model.getRoomInfoIfHotelNotNull();
//                break;
//            case "Pay":
//                this.model.pay();
//                //Pay successfully and Back to HotelList;
//                this.model.getHotelInfo();
//                break;
//            case "AddLikeItem":
//                int likehotelid = 0;
//                this.model.addLikeItem(likehotelid);
//            case "DeleteLikeItem":
//                int dislikehotelid = 0;
//                this.model.deleteLikeItem(dislikehotelid);
        }
    }
    
}
