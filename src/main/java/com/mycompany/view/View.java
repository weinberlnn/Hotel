/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import com.mycompany.controller.Controller;
import com.mycompany.entity.DataMessage;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author xiaochou(wenbolin)
 */
public class View extends JFrame implements Observer{

    //login page
    private JPanel LoginPanel1 = new JPanel();
    private JPanel LoginPanel2 = new JPanel();
    //private JPanel LoginPanel3 = new JPanel();
    private JPanel LoginPanel4 = new JPanel();
    private JLabel username = new JLabel("Username: ");
    private JLabel password = new JLabel("Password: ");
    public JTextField unInput = new JTextField(19);
    public JPasswordField pwInput = new JPasswordField(19);
    private JButton registerButton = new JButton("Register");
    private JButton loginButton = new JButton("Log in");
    
    //Register page
     private JPanel RegisterPanel1 = new JPanel();
     private JPanel RegisterPanel2 = new JPanel();
     private JPanel RegisterPanel3 = new JPanel();
     private JPanel RegisterPanel4 = new JPanel();
     private JPanel RegisterPanel5 = new JPanel();
     private JLabel Regusername = new JLabel("Username: ");
     private JLabel Regpassword = new JLabel("Password: ");
     private JLabel Chepassword = new JLabel("Confirm Password: ");
     private JLabel Email = new JLabel("Email: ");
     public JTextField registerunInput = new JTextField(19);
     public JPasswordField registerpwInput1 = new JPasswordField(19);
     public JPasswordField registerpwInput2 = new JPasswordField(19);
     public JTextField EmailInput = new JTextField(19);
     private JButton ButtonforRegister = new JButton("Get Registe");
     private JButton Back = new JButton("Back");
     
    private boolean Registerstarted = false;
    
    
    public View(){
        
        this.setLayout(new GridLayout(3,1));
        
        JLabel tempj = new JLabel("Hotel Era Login System");
        tempj.setFont(new Font("宋体",Font.BOLD,20));
        tempj.setBounds(180,0,300,80);
        
       
        username.setFont(new Font("宋体",Font.BOLD,20));
        username.setBounds(90,0,110,30);

       
        password.setFont(new Font("宋体",Font.BOLD,20));
        password.setBounds(90,80,110,30);

        //用户名
        
        unInput.setFont(new Font("宋体",Font.BOLD,20));
        unInput.setBounds(190,0,190,30);
        //密码
     
        pwInput.setFont(new Font("宋体",Font.BOLD,20));
        pwInput.setBounds(190,80,190,30);

       
        loginButton.setFont(new Font("宋体",Font.BOLD,20));
        loginButton.setBounds(120,20,130,40);

       
        registerButton.setFont(new Font("宋体",Font.BOLD,20));
        registerButton.setBounds(280,20,130,40);
        
        LoginPanel1.add(tempj);

        LoginPanel2.add(username);
        LoginPanel2.add(unInput);
        LoginPanel2.add(password);
        LoginPanel2.add(pwInput);


        LoginPanel4.add(loginButton);
        LoginPanel4.add(registerButton);
        this.add(LoginPanel1);
        this.add(LoginPanel2);
        this.add(LoginPanel4);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }
    
    public void Register(){
        
        
        this.setLayout(new GridLayout(5,1));
        
        
        JLabel tempj = new JLabel("Hotel Era Register System");
        tempj.setFont(new Font("宋体",Font.BOLD,20));
        tempj.setBounds(180,0,300,80);
        
        RegisterPanel1 = new JPanel((new FlowLayout(FlowLayout.LEFT)));
        RegisterPanel1.add(Regusername);
        RegisterPanel1.add(registerunInput);
        
        
        RegisterPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        RegisterPanel2.add(Regpassword);
        RegisterPanel2.add(registerpwInput1);
        
        
        RegisterPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        RegisterPanel3.add(Chepassword);
        RegisterPanel3.add(registerpwInput2);
        
        
        RegisterPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        RegisterPanel4.add(Email);
        RegisterPanel4.add(EmailInput);
       
        
        
        RegisterPanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        RegisterPanel5.add(ButtonforRegister);
        RegisterPanel5.add(Back);
        
        
        
        this.getContentPane().removeAll();
        RegisterPanel1.setVisible(true);
        RegisterPanel2.setVisible(true);
        RegisterPanel3.setVisible(true);
        RegisterPanel4.setVisible(true);
        RegisterPanel5.setVisible(true);
        this.add(RegisterPanel1);
        this.add(RegisterPanel2);
        this.add(RegisterPanel3);
        this.add(RegisterPanel4);
        this.add(RegisterPanel5);
        this.revalidate();
        this.repaint();
        
    }
    
     public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
        this.registerButton.addActionListener(listener);
        this.ButtonforRegister.addActionListener(listener);
        this.Back.addActionListener(listener);
    }
     
     
     
     public void update(Observable o, Object arg){
          DataMessage data = (DataMessage) arg;
          if (data.getLoginflag() == 0) { // If loginFlage is false, then ask the user to input again.
            this.unInput.setText("");
            this.pwInput.setText("");
            JOptionPane.showMessageDialog(null,"Invalid username or password.");
            
        } else if (!this.Registerstarted) { // If the game has not started, then start the game.
            this.Register(); // Change the interface of the frame.
            this.Registerstarted = true;
            
        } 
//        else if (data.quitFlag) { // If user quits the game, display user's current score.
//            this.quitGame(data.currentScore);
//        } else { // Otherwise, update a new question for the user.
//            this.setQuestion(data.num1, data.num2);
//        }
     }
    
    public void addActionListener(Controller aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
