/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import com.mycompany.entity.DataMessage;
import com.mycompany.entity.Hotel;
import com.mycompany.entity.Order;
import com.mycompany.entity.Room;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author xiaochou(wenbolin)
 */
public class View extends JFrame implements Observer{
    public ActionListener listener;
    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null); // Make the frame located at the absolute center of the screen.
        this.Login();
        this.setVisible(true);
    }
    
    //Login Page
    private JPanel LoginPanel = new JPanel(new BorderLayout());
    private JPanel titlePanel = new JPanel();
    private JPanel loginPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel title = new JLabel("Hotel Booking System");
    private JLabel username = new JLabel("Username");
    private JLabel password = new JLabel("Password");
    public JTextField userInput = new JTextField(10);
    public JTextField passInput = new JTextField(10);
    private JButton loginButton = new JButton("Log in");
    private JButton registerButton = new JButton("Get Register");
    public void Login(){
        this.titlePanel.add(title);
        this.loginPanel.add(username);
        this.loginPanel.add(userInput);
        this.loginPanel.add(password);
        this.loginPanel.add(passInput);
        this.buttonPanel.add(loginButton);
        this.buttonPanel.add(registerButton);
        this.LoginPanel.add(titlePanel,BorderLayout.NORTH);
        this.LoginPanel.add(loginPanel,BorderLayout.CENTER);
        this.LoginPanel.add(buttonPanel,BorderLayout.SOUTH);
        this.add(LoginPanel);
    }
    
    //Register Page
    private JPanel RegisterPanel = new JPanel(new BorderLayout());
    private JPanel usernamePanel = new JPanel();
    private JPanel buttonPanel2 = new JPanel();
    private JPanel emailPanel = new JPanel();
    private JLabel username2 = new JLabel("Username");
    private JLabel password2 = new JLabel("Password");
    private JLabel email = new JLabel("email");
    public JTextField userInput2 = new JTextField(10);
    public JTextField passInput2 = new JTextField(10);
    public JTextField emailInput = new JTextField(10);
    private JButton registerButton2 = new JButton("Register");
    public void Register(){
        this.getContentPane().removeAll();
        this.usernamePanel.add(username2);
        this.usernamePanel.add(userInput2);
        this.usernamePanel.add(password2);
        this.usernamePanel.add(passInput);
        this.emailPanel.add(email);
        this.emailPanel.add(emailInput);
        this.buttonPanel2.add(registerButton2);
        this.RegisterPanel.add(usernamePanel,BorderLayout.NORTH);
        this.RegisterPanel.add(emailPanel,BorderLayout.CENTER);
        this.RegisterPanel.add(buttonPanel2,BorderLayout.SOUTH);
        RegisterPanel.setVisible(true);
        this.add(RegisterPanel);
        this.revalidate();
        this.repaint();
    }
    
    //HotelInformation Page;
    private ArrayList<Hotel> hotelcollection;
    private JPanel Hotellistpanel;
    private JPanel Hotellistpanel_1;
    private JPanel Hotellistpanel_2;
    private JPanel Hotellistpanel_3;
    private JPanel Hotellistpanel_4;
    private JPanel Hotellistpanel1 = new JPanel();
    private JScrollPane HotellistScroll = new JScrollPane(Hotellistpanel1);
    private JLabel Hotellistlabel;
    private JRadioButton Hotellistbutton;//like
    public ArrayList<JButton> Hotellistbu1 = new ArrayList<JButton>();//more information
    private void HotelList() {
        Hotellistpanel1.setLayout(new GridLayout(hotelcollection.size() / 2, 4, 10, 10));
        
        for (int i = 0; i < hotelcollection.size(); i++) {
            Hotel hotel = hotelcollection.get(i);
            Hotellistpanel = new JPanel();
            Hotellistpanel.setLayout(new GridLayout(2, 1));
            Hotellistpanel.setPreferredSize(new Dimension(150, 300));
            Hotellistpanel_1 = new JPanel();
            Hotellistpanel_2 = new JPanel();
            Hotellistpanel_2.setLayout(new GridLayout(2, 1));
            Hotellistpanel_3 = new JPanel();
            Hotellistpanel_4 = new JPanel();
            Hotellistlabel = new JLabel(",hotelname:"+hotel.getHotelname());
            Hotellistbutton = new JRadioButton("Like");
            JButton button1 = new JButton("More Information,"+hotel.getHotelid());
            button1.addActionListener(listener);
            Hotellistbu1.add(button1);
            Hotellistpanel_1.setPreferredSize(new Dimension(150, 200));
            Hotellistpanel_2.setPreferredSize(new Dimension(150, 50));
            Hotellistpanel_3.setPreferredSize(new Dimension(100, 50));
            Hotellistpanel_3.add(Hotellistlabel);

            Hotellistpanel_4.add(Hotellistbutton);
            Hotellistpanel_4.add(button1);
            

            Hotellistpanel_2.add(Hotellistpanel_3);
            Hotellistpanel_2.add(Hotellistpanel_4);

            Hotellistpanel.add(Hotellistpanel_1);
            Hotellistpanel.add(Hotellistpanel_2);

            Hotellistpanel1.add(Hotellistpanel);

            JLabel jlimage = new JLabel();
            ImageIcon icon = new ImageIcon("src/main/java/com/mycompany/view/HotelPictures/"+hotel.getHotelpicture());	    
            icon.setImage(icon.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));//80和100为大小 可以自由设置		
            jlimage.setIcon(icon);
            Hotellistpanel_1.add(jlimage);
            
        }
        
    }
    public void Hotelinformation(){
        this.getContentPane().removeAll();
        NavigateBar();
        HotelList();
        this.setLayout(new GridLayout(1, 1));
        this.add(HotellistScroll);
        this.setVisible(true);
    }
    
    //RoomList Page;
    private ArrayList<Room> roomcollection;
    private JPanel roomPanel = new JPanel();
    public void RoomList(){
        roomPanel.setLayout(new GridLayout(roomcollection.size(), 4, 10, 10));
        for(int i=0;i<roomcollection.size();i++){
            JPanel roomPanel1 = new JPanel(new BorderLayout());
            JPanel roomstylePanel = new JPanel();
            JPanel roomcostPanel = new JPanel();
            JPanel roombuttonPanel = new JPanel();
            JLabel roomstyle = new JLabel("Room Style:"+roomcollection.get(i).getRoomstyle());
            JLabel roomcost = new JLabel("Room Cost:"+roomcollection.get(i).getRoomcost());
            JButton backButton = new JButton("Back to HotelList");
            JButton buyButton = new JButton("Buy-"+roomcollection.get(i).getRoomid());
            buyButton.addActionListener(listener);
            roomstylePanel.add(roomstyle);
            roomcostPanel.add(roomcost);
            roombuttonPanel.add(backButton);
            roombuttonPanel.add(buyButton);
            roomPanel1.add(roomstylePanel,BorderLayout.NORTH);
            roomPanel1.add(roomcostPanel,BorderLayout.CENTER);
            roomPanel1.add(roombuttonPanel,BorderLayout.SOUTH);
            roomPanel.add(roomPanel1);
        }
        this.getContentPane().removeAll();
        roomPanel.setVisible(true);
        this.add(roomPanel);
        this.revalidate();
        this.repaint();
        
    }
    
    //FormOrder
    private JPanel orderPanel = new JPanel(new BorderLayout());
    private JPanel truenamePanel = new JPanel();
    private JPanel buttonPanel1 = new JPanel();
    private JPanel bookdayPanel = new JPanel();
    private JLabel truenameLabel = new JLabel("True Name");
    private JLabel phoneLabel = new JLabel("Phone");
    private JLabel bookdayLabel = new JLabel("Book Day");
    public JTextField truename = new JTextField(10);
    public JTextField phone = new JTextField(10);
    public JTextField bookday = new JTextField(10);
    private JButton payButton = new JButton("Pay");
    public void FormOrder(){
        this.getContentPane().removeAll();
        this.truenamePanel.add(truenameLabel);
        this.truenamePanel.add(truename);
        this.truenamePanel.add(phoneLabel);
        this.truenamePanel.add(phone);
        this.buttonPanel1.add(payButton);
        this.bookdayPanel.add(bookdayLabel);
        this.bookdayPanel.add(bookday);
        this.orderPanel.add(truenamePanel,BorderLayout.NORTH);
        this.orderPanel.add(bookdayPanel,BorderLayout.CENTER);
        this.orderPanel.add(buttonPanel1,BorderLayout.SOUTH);
        orderPanel.setVisible(true);
        this.add(orderPanel);
        this.revalidate();
        this.repaint();
    }
    
    //Navigater Bar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private void NavigateBar() {
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Booking System");

        jRadioButton1.setText("jRadioButton1");

        jRadioButton2.setText("jRadioButton2");

        jMenu3.setText("Settings");

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\25433\\Desktop\\StudentInfo\\src\\images\\修改密码.png")); // NOI18N
        jMenuItem1.setText("Change password");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon("C:\\Users\\25433\\Desktop\\StudentInfo\\src\\images\\退出.png")); // NOI18N
        jMenuItem2.setText("Exit");
        jMenuItem2.setActionCommand("Exit");
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("User");

        jMenuItem3.setText("My Collection");
        jMenuItem3.setToolTipText("");
        jMenu2.add(jMenuItem3);

        jMenuItem5.setIcon(new javax.swing.ImageIcon("C:\\Users\\25433\\Desktop\\StudentInfo\\src\\images\\确认.png")); // NOI18N
        jMenuItem5.setText("My OrderLIst");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Search");

        jRadioButtonMenuItem2.setText("Single room");
        jMenu4.add(jRadioButtonMenuItem2);

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Double room");
        jMenu4.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("Breakfast");
        jMenu4.add(jRadioButtonMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }
    
//    //OrderList Page;
//    private JPanel orderlistpanel;
//    private JPanel orderlistpanel1 = new JPanel();
//    private JScrollPane orderlistScroll = new JScrollPane(orderlistpanel1);
//    private JLabel orderlistlabel;
//    private JTextField orderlisttext;
//    private JButton orderlistbu1;
//    private void OrderList() {
////        this.setLayout(new GridLayout(2,1) );
////        this.getContentPane().removeAll();
//        orderlistpanel1.setLayout(new GridLayout(OrderNumber, 1));
//        orderlistpanel1.setBounds(20, 20, 500, 500);
//        for (int i = 0; i < OrderNumber; i++) {
//            orderlistpanel = new JPanel();
//            orderlistlabel = new JLabel("No: " + i);
//            orderlisttext = new JTextField("This is NO: " + i);
//            orderlistbu1 = new JButton("Delete");
//            orderlistpanel.add(orderlistlabel);
//            orderlistpanel.add(orderlisttext);
//            orderlistpanel.add(orderlistbu1);
//
//            orderlistpanel1.add(orderlistpanel);
//        }
//
////        this.getContentPane().add(orderlistScroll);
////        this.setVisible(true);
////        this.revalidate();
////        this.repaint();
//    }
//    public void Orderinformation() {
//        this.getContentPane().removeAll();
//        NavigateBar();
//        OrderList();
//
//        this.setLayout(new GridLayout(1, 1));
//
//        this.add(orderlistScroll);
//        this.setVisible(true);
//    }
    
    public void addActionListener(ActionListener listener){
        this.listener = listener;
        loginButton.addActionListener(listener);
        registerButton.addActionListener(listener);
        registerButton2.addActionListener(listener);
        payButton.addActionListener(listener);

    }
    public void update(Observable arg0, Object arg1) {
        DataMessage data = (DataMessage) arg1;
        if(data.getCheckflag()==1){
            this.userInput2.setText("");
            this.passInput2.setText("");
            this.emailInput.setText("");
            JOptionPane.showMessageDialog(RegisterPanel, "Username is exists", "Error",JOptionPane.ERROR_MESSAGE);  
        }
        else if(data.getLoginflag()==0){
            this.userInput.setText("");
            this.passInput.setText("");
            JOptionPane.showMessageDialog(LoginPanel, "Enter the right username and password", "Error",JOptionPane.ERROR_MESSAGE);  
        }
        else if(data.getGethotelinfoflag()==1){
            hotelcollection = (ArrayList<Hotel>)data.getSource();
            this.Hotelinformation();
        }
        else if(data.getGetroominfoflag()==1){
            roomcollection = (ArrayList<Room>)data.getSource();
            this.RoomList();
        }
        else if(data.getRoomexistflag()==1){
            JOptionPane.showMessageDialog(orderPanel, "room is not enough", "Error",JOptionPane.ERROR_MESSAGE);
            this.Hotelinformation();
        }
        else if(data.getPayflag()==1){
            this.Hotelinformation();
        }
    }
    
}
