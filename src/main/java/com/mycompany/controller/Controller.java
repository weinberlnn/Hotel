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
//        if(e.getSource() == this.view.loginButton)
//        {
//            String loginusername = this.view.unInput.getText();
//            String loginpassword = new String(this.view.pwInput.getPassword());
//            System.out.println(loginpassword);
//            if(this.model.login(loginusername, loginpassword)){
//                this.model.getHotelInfo();
//                    
//                this.view.Hotelinformation();
//            }
//        }else if(e.getSource() == this.view.registerButton)
//        {
//            this.view.Register();
//        }else if(e.getSource() == this.view.ButtonforRegister){
//                String registerusername = this.view.registerunInput.getText();
//                String registerpassword = new String(this.view.registerpwInput1.getPassword());
//                String registeremail = this.view.EmailInput.getText();
//                
//                if(!this.model.checkUserWhenRegister(registerusername))
//                {
//                    
//                    this.model.register(registerusername, registerpassword, registeremail);
//                    this.view.View1();
//                    
//                }else{
//                    this.view.tempj.setText("Username exist!");
//                }
//        }
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
                System.out.println(this.model.checkUserWhenRegister(registerusername));
                if(this.model.checkUserWhenRegister(registerusername))
                {
                    System.out.println(" there is no such user!");
                    this.model.register(registerusername, registerpassword, registeremail);
                    this.view.View1();
                    
                }else{
                    this.view.tempj.setText("Username exist!");
                }
                break;
                    
            case "Register":
                this.view.Register();
                break;
            case "BUY":
                
            case "Back to Hotelinfo":
            
        }
    }
    
}
