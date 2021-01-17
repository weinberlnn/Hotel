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
                String loginpassword = this.view.pwInput.getPassword().toString();
                this.model.login(loginusername, loginpassword);
                break;
            case "Get Registe":
                String registerusername = this.view.registerunInput.getText();
                String registerpassword = this.view.registerpwInput1.getPassword().toString();
                String registeremail = this.view.EmailInput.getText();
                if(this.model.checkUserWhenRegister(registerusername))
                    this.model.register(registerusername, registerpassword, registeremail);
            
        }
    }
    
}
