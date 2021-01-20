/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.view;

import com.mycompany.controller.Controller;
import com.mycompany.entity.DataMessage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
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
     private JPanel RegisterPanel6 = new JPanel();
     private JLabel Regusername = new JLabel("    Username:     ");
     
     private JLabel Regpassword = new JLabel("    Password:     ");
     private JLabel Chepassword = new JLabel("Confirm Password: ");
     private JLabel Email = new JLabel("      Email:       ");
     public JTextField registerunInput = new JTextField(19);
     public JPasswordField registerpwInput1 = new JPasswordField(19);
     public JPasswordField registerpwInput2 = new JPasswordField(19);
     public JTextField EmailInput = new JTextField(19);
     private JButton ButtonforRegister = new JButton("Get Registe");
     private JButton Back = new JButton("Back");
     
     private boolean Registerstarted = false;
    
    //OrderList Page
    int OrderNumber = 29;
    private JPanel orderlistpanel ;
    private JPanel orderlistpanel1 = new JPanel();
    private JScrollPane orderlistScroll = new JScrollPane(orderlistpanel1);
    private JLabel orderlistlabel ;
    private JTextField orderlisttext ;
    private JButton orderlistbu1 = new JButton("Delete");
    
    //NavigateBar
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
    
    //Hotellist
    private JPanel Hotellistpanel ;
    private JPanel Hotellistpanel_1 ;
    private JPanel Hotellistpanel_2 ;
    private JPanel Hotellistpanel_3 ;
    private JPanel Hotellistpanel_4 ;
    private JPanel Hotellistpanel1 = new JPanel() ;
    private JScrollPane HotellistScroll = new JScrollPane(Hotellistpanel1);
    private JLabel Hotellistlabel ;
    public JRadioButton Hotellistbutton = new JRadioButton("Like");
    private JButton Hotellistbu1 = new JButton("Detail");
    
    //detail hotel info
    private JPanel detailpanel1;
    private JPanel detailpanel2;
    private JLabel detaillabel1;
    private JLabel detaillabel2;
    private JLabel detaillabel3;
    private JLabel detaillabel4;
    private JLabel detaillabel5;
    private JLabel detaillabel6;
    private JButton detailbutton;
    
    
    
    public View(){
        View1();
    }
    
    public void View1(){
        
        this.getContentPane().removeAll();
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
        this.setSize(1200, 1000);
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }
    
    public void Register(){
        
        
        this.setLayout(new GridLayout(6,1));
        
        
        JLabel tempj = new JLabel("Hotel Era Register System");
        tempj.setFont(new Font("宋体",Font.BOLD,20));
        tempj.setBounds(180,0,300,80);
        
        RegisterPanel6 = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        RegisterPanel6.add(tempj);
        
        RegisterPanel1 = new JPanel((new FlowLayout(FlowLayout.CENTER)));
        Regusername.setFont(new Font("宋体",Font.BOLD,20));
        RegisterPanel1.add(Regusername);
        RegisterPanel1.add(registerunInput);
        
        
        RegisterPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Regpassword.setFont(new Font("宋体",Font.BOLD,20));
        RegisterPanel2.add(Regpassword);
        RegisterPanel2.add(registerpwInput1);
        
        
        RegisterPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Chepassword.setFont(new Font("宋体",Font.BOLD,20));
        RegisterPanel3.add(Chepassword);
        RegisterPanel3.add(registerpwInput2);
        
        
        RegisterPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Email.setFont(new Font("宋体",Font.BOLD,20));
        RegisterPanel4.add(Email);
        RegisterPanel4.add(EmailInput);
       
        
        
        RegisterPanel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonforRegister.setFont(new Font("宋体",Font.BOLD,20));
        RegisterPanel5.add(ButtonforRegister);
//        RegisterPanel5.add(Back);
        
        
        
        this.getContentPane().removeAll();
        RegisterPanel1.setVisible(true);
        RegisterPanel2.setVisible(true);
        RegisterPanel3.setVisible(true);
        RegisterPanel4.setVisible(true);
        RegisterPanel5.setVisible(true);
        this.add(RegisterPanel6);
        this.add(RegisterPanel1);
        this.add(RegisterPanel2);
        this.add(RegisterPanel3);
        this.add(RegisterPanel4);
        this.add(RegisterPanel5);
        this.setSize(1200, 1000);
        this.setLocationRelativeTo(null);
        this.revalidate();
        this.repaint();
        
    }
    
    public void Orderinformation(){
       NavigateBar();
       OrderList();
       this.setLayout(new GridLayout(1,1));
       this.getContentPane().removeAll();
       
       
       
       
       this.add(orderlistScroll);
       this.setSize(1200, 1000);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void Hotelinformation(){
        this.getContentPane().removeAll();
        NavigateBar();
        HotelList(OrderNumber);
        
        this.setLayout(new GridLayout(1,1));
        this.add(HotellistScroll);
        this.setSize(1200, 1000);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void detailHotelinfo(){
         this.getContentPane().removeAll();
         
         detailHotel();
         this.setLayout(new GridLayout(2,1));
         this.add(detailpanel1);
         this.add(detailpanel2);
         this.setSize(1200, 1000);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
    public void collection(){
        this.getContentPane().removeAll();
        NavigateBar();
        HotelList(OrderNumber/2);
        
        this.setLayout(new GridLayout(1,1));
        this.add(HotellistScroll);
        this.setSize(1200, 1000);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
         this.revalidate();
        this.repaint();
    }
    
    
    private void detailHotel(){
        
        detailpanel1 = new JPanel();
        detailpanel2 = new JPanel();
        detaillabel1 = new JLabel("HotelName: ");
        detaillabel2 = new JLabel(" HuaMeiDa ");
        detaillabel3 = new JLabel("HotelPrice: ");
        detaillabel4 = new JLabel(" $99 ");
        detaillabel5 = new JLabel("HotelStyle: ");
        detaillabel6 = new JLabel(" doubleroom/breakfast ");
        detailbutton = new JButton("Back to Hotelinfo");
        
        detailpanel1.setBackground(Color.PINK);
        detailpanel2.setLayout(new GridLayout(4,2));
        detailpanel2.add(detaillabel1);
        detailpanel2.add(detaillabel2);
        detailpanel2.add(detaillabel3);
        detailpanel2.add(detaillabel4);
        detailpanel2.add(detaillabel5);
        detailpanel2.add(detaillabel6);
        detailpanel2.add(detailbutton);
        
        
    }
    private void NavigateBar(){
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem("Exit");
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem("My Collection");
        jMenuItem5 = new javax.swing.JMenuItem("My OrderLIst");
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        

        jRadioButton1.setText("jRadioButton1");

        jRadioButton2.setText("jRadioButton2");

        jMenu3.setText("Settings");

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\25433\\Desktop\\StudentInfo\\src\\images\\修改密码.png")); // NOI18N
        jMenuItem1.setText("Change password");
//        jMenu3.add(jMenuItem1);

       
        
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("User");

        
        
        jMenu2.add(jMenuItem3);

        
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
    
    private void OrderList(){
//        this.setLayout(new GridLayout(2,1) );
//        this.getContentPane().removeAll();
        orderlistpanel1.setLayout(new GridLayout(OrderNumber,1) );
        orderlistpanel1.setBounds(20,20,500,500);
        for(int i=0;i<OrderNumber;i++){
            orderlistpanel = new JPanel();
            orderlistlabel = new JLabel("No: "+i);
            orderlisttext = new JTextField("This is NO: "+i);
            
            orderlistpanel.add(orderlistlabel);
            orderlistpanel.add(orderlisttext);
            orderlistpanel.add(orderlistbu1);
            
            orderlistpanel1.add(orderlistpanel);
        }
        
//        this.getContentPane().add(orderlistScroll);
//        this.setVisible(true);
//        this.revalidate();
//        this.repaint();
    }
    
    private void HotelList(int OrderNumber){
        Hotellistpanel1.setLayout(new GridLayout(OrderNumber/2,4,10,10));
        orderlistpanel1.setBounds(new Rectangle(25,25,25,25));
        for(int i=0;i<OrderNumber;i++)
        {
            Hotellistpanel = new JPanel();
            Hotellistpanel.setLayout(new GridLayout(2,1));
            Hotellistpanel.setPreferredSize(new Dimension(150, 300));
            Hotellistpanel_1 = new JPanel();
            Hotellistpanel_2 = new JPanel();
            Hotellistpanel_2.setLayout(new GridLayout(2,1));
            Hotellistpanel_3 = new JPanel();
            Hotellistpanel_4 = new JPanel();
            Hotellistlabel = new JLabel("HotelName: "+i);
            
            
            Hotellistpanel_1.setBackground(Color.PINK);
            Hotellistpanel_3.setBackground(Color.cyan);
            Hotellistpanel_4.setBackground(Color.GRAY);
            Hotellistpanel_1.setPreferredSize(new Dimension(150,200));
            Hotellistpanel_2.setPreferredSize(new Dimension(150,50));
            Hotellistpanel_3.setPreferredSize(new Dimension(150,50));
            Hotellistpanel_3.add(Hotellistlabel);
            
            Hotellistpanel_4.add(Hotellistbutton);
            Hotellistpanel_4.add(Hotellistbu1);
            
            Hotellistpanel_2.add(Hotellistpanel_3);
            Hotellistpanel_2.add(Hotellistpanel_4);
            
            Hotellistpanel.add(Hotellistpanel_1);
            Hotellistpanel.add(Hotellistpanel_2);
            
            
            Hotellistpanel1.add(Hotellistpanel);
            Hotellistpanel.setVisible(true);
        }
    }
    
    
     public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
        this.registerButton.addActionListener(listener);
        this.ButtonforRegister.addActionListener(listener);
        this.Back.addActionListener(listener);
//        this.jMenuItem1.addActionListener(listener);//change password
//        this.jMenuItem2.addActionListener(listener);//Exit
//        this.jMenuItem3.addActionListener(listener);//Collection
//        this.jMenuItem4.addActionListener(listener);//Order
//        this.jRadioButtonMenuItem1.addActionListener(listener);//Double room
//        this.jRadioButtonMenuItem2.addActionListener(listener);//Single room
//        this.jRadioButtonMenuItem3.addActionListener(listener);//Breakfast
        this.Hotellistbutton.addActionListener(listener);//Like
        this.Hotellistbu1.addActionListener(listener);//Buy
        this.orderlistbu1.addActionListener(listener);//Delete
    }
     
     
     
    @Override
     public void update(Observable o, Object arg){
          DataMessage data = (DataMessage) arg;
          System.out.println("update going");
          System.out.println("Loginfalg: "+data.getLoginflag());
          System.out.println("registerflag: "+data.getRegisterflag());
          System.out.println("checkflag: "+data.getCheckflag());
          System.out.println("gethotelinfoflag: "+data.getGethotelinfoflag());
          
        if (data.getLoginflag() == 0) { // If loginFlage is false, then ask the user to input again.
            System.out.println("wrong");
            this.unInput.setText("");
            this.pwInput.setText("");
        }
        if(data.getGethotelinfoflag()== 1 ){
            
            System.out.println(" got hotelinfoflag");
        }
        if(data.getRegisterflag() == 1)
        {
            System.out.println(" got registerflag");
            View1();
        }
        if(data.getCheckflag() == 1)
        {
            System.out.println(" got checkflag");
        }
        if(data.getGetorderinfoflag() == 1)
        {
            System.out.println(" got orderinfoflag");
        }
        if(data.getGetroominfoflag() == 1)
        {
             System.out.println(" got roominfoflag");
        }
        if(data.getGetuserinfoflag() == 1)
        {
             System.out.println(" got userinfoflag");
        }
        if(data.getPayflag() == 1)
        {
            System.out.println(" got payflag");
        }
//        else if (data.quitFlag) { // If user quits the game, display user's current score.
//            this.quitGame(data.currentScore);
//        } else { // Otherwise, update a new question for the user.
//            this.setQuestion(data.num1, data.num2);
//        }
     }
    
    
    

}
