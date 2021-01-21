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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
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

    //login page
    private JPanel LoginPanel1 = new JPanel();
    private JPanel LoginPanel2 = new JPanel();
    //private JPanel LoginPanel3 = new JPanel();
    private JPanel LoginPanel4 = new JPanel();
    private JLabel username = new JLabel("Username: ");
    private JLabel password = new JLabel("Password: ");
    public JLabel tempk = new JLabel("Hotel Era Login System");
    public JTextField unInput = new JTextField(19);
    public JPasswordField pwInput = new JPasswordField(19);
    public JButton registerButton = new JButton("Register");
    public JButton loginButton = new JButton("Log in");
    
    //Register page
     private JPanel RegisterPanel1 = new JPanel();
     private JPanel RegisterPanel2 = new JPanel();
     private JPanel RegisterPanel3 = new JPanel();
     private JPanel RegisterPanel4 = new JPanel();
     private JPanel RegisterPanel5 = new JPanel();
     private JPanel RegisterPanel6 = new JPanel();
     private JLabel Regusername = new JLabel("    Username:     ");
     public JLabel tempj = new JLabel("Hotel Era Register System");
     private JLabel Regpassword = new JLabel("    Password:     ");
     private JLabel Chepassword = new JLabel("Confirm Password: ");
     private JLabel Email = new JLabel("      Email:       ");
     public JTextField registerunInput = new JTextField(19);
     public JPasswordField registerpwInput1 = new JPasswordField(19);
     public JPasswordField registerpwInput2 = new JPasswordField(19);
     public JTextField EmailInput = new JTextField(19);
     public JButton ButtonforRegister = new JButton("Get Registe");
     private JButton Back = new JButton("Back");
     
     private boolean Registerstarted = false;
    
    //OrderList Page
    int OrderNumber = 29;
    private JPanel orderlistpanel ;
    private JPanel orderlistpanel1 = new JPanel();
    private JScrollPane orderlistScroll = new JScrollPane(orderlistpanel1);
    private JLabel orderlistlabel_1  ;
    private JLabel orderlistlabel_2  ;
    private JLabel orderlistlabel_3  ;
    private JLabel orderlistlabel_4  ;
    private JLabel orderlistlabel_5  ;
    private JLabel orderlistlabel_6  ;
    private JLabel orderlistlabel_7  ;
    private JLabel orderlistlabel_8  ;
    private JLabel orderlistlabel_9  ;
    
    
    private JButton orderlistbu1 = new JButton("Delete");
    
    //NavigateBar
    private javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
    private javax.swing.JMenu jMenu2 = new javax.swing.JMenu("User");
    private javax.swing.JMenu jMenu3 = new javax.swing.JMenu("Setting");
    private javax.swing.JMenu jMenu4 = new javax.swing.JMenu("Search");
    private javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
    private javax.swing.JMenuItem jMenuItem1 = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem jMenuItem2 = new javax.swing.JMenuItem("Exit");
    private javax.swing.JMenuItem jMenuItem3 = new javax.swing.JMenuItem("My Collection");
    private javax.swing.JMenuItem jMenuItem4 = new javax.swing.JMenuItem("jMenuItem4");
    private javax.swing.JMenuItem jMenuItem5 = new javax.swing.JMenuItem("My OrderLIst");
    private javax.swing.JMenuItem jMenuItem6 = new javax.swing.JMenuItem("jMenuItem6");
    private javax.swing.JRadioButton jRadioButton1 = new javax.swing.JRadioButton("jRadioButton1");
    private javax.swing.JRadioButton jRadioButton2 = new javax.swing.JRadioButton("jRadioButton2");
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem("Double room");
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem("Single room");
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem("Breakfast");
    
    //Hotellist
    private JPanel Hotellistpanel ;
    private JPanel Hotellistpanel_1 ;
    private JPanel Hotellistpanel_2 ;
    private JPanel Hotellistpanel_3 ;
    private JPanel Hotellistpanel_4 = new JPanel();
    private JPanel Hotellistpanel1 = new JPanel() ;
    public JScrollPane HotellistScroll = new JScrollPane(Hotellistpanel1);
    private JLabel Hotellistlabel ;
    public JRadioButton Hotellistbutton1 = new JRadioButton("Like");
    public JRadioButton Hotellistbutton2 = new JRadioButton("DisLike");
    public ButtonGroup group ;
    public JButton Hotellistbu1 = new JButton("Detail");
    
    //detail hotel info
    private JPanel detailpanel1;
    private JPanel detailpanel2;
    private JLabel detaillabel1;
    private JLabel detaillabel2;
    private JLabel detaillabel3;
    private JLabel detaillabel4;
    private JLabel detaillabel5;
    private JLabel detaillabel6;
    private JButton detailbutton = new JButton("Back to Hotelinfo");
    private JButton detailbuttonbuy = new JButton("BUY");
    private JButton detailroominfo = new JButton("RoomInfo");
    
    //roominfo
    private JLabel RoomPanel1;
    private JLabel RoomPanel2;
    private JPanel RoomPanel3 = new JPanel();
    private JPanel RoomPanel4;
    private JPanel RoomPanel5;
    private JPanel RoomPanel6;
    private JButton Roombuy;
    
    //hotel
    ArrayList<Hotel> hotelinfo;
    public Hotel hotel;
    ArrayList<Room> roominfo;
    ArrayList<Order> orderinfo;
    
    public View(){
        View1();
    }
    
    public void View1(){
        
        this.setLayout(new GridLayout(3,1));
        
       
        tempk.setFont(new Font("宋体",Font.BOLD,20));
        tempk.setBounds(180,0,300,80);
        
       
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
        
        
        
        this.getContentPane().removeAll();
        LoginPanel1.setVisible(true);
        LoginPanel2.setVisible(true);
        LoginPanel4.setVisible(true);
        
        this.add(LoginPanel1);
        this.add(LoginPanel2);
        this.add(LoginPanel4);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1000);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void Register(){
        
        
        this.setLayout(new GridLayout(6,1));
        
        
       
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
       this.getContentPane().removeAll();
       NavigateBar();
       OrderList(orderinfo);
       
       this.setLayout(new GridLayout(1,1));
       
       this.add(orderlistScroll);
       this.setSize(1200, 1000);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
    
    public void Hotelinformation(){
        this.getContentPane().removeAll();
        NavigateBar();
        HotelList(hotelinfo);
        
        this.setLayout(new GridLayout(1,1));
        HotellistScroll.setVisible(true);
        this.add(HotellistScroll);
        this.setSize(1200, 1000);
        this.setLocationRelativeTo(null);
        this.revalidate();
        this.repaint();
    }
    
    public void detailHotelinfo(Hotel detail){
         this.getContentPane().removeAll();
         
         detailHotel(detail);
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
        HotelList(hotelinfo);
        
        this.setLayout(new GridLayout(1,1));
        this.add(HotellistScroll);
        this.setSize(1200, 1000);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void Roominformation(){
        this.getContentPane().removeAll();
        NavigateBar();
        RoomList(roominfo);
        this.setLayout(new GridLayout(1,1));
        this.add(RoomPanel3);
        this.setSize(1200, 1000);
        this.setLocationRelativeTo(null);
        this.revalidate();
        this.repaint();
    }
    
    private void RoomList(ArrayList<Room> roominfo){
        RoomPanel3.setLayout(new GridLayout(roominfo.size()/2,4,10,10));
        for(int i=0;i<roominfo.size();i++)
        {
            RoomPanel1 = new JLabel("RoomStyle:  "+roominfo.get(i).getRoomstyle());
            RoomPanel2 = new JLabel("RoomCost:  "+roominfo.get(i).getRoomcost());
            RoomPanel4 = new JPanel();
            RoomPanel5 = new JPanel();
            RoomPanel6 = new JPanel();
            Roombuy = new JButton("BUY");
            Roombuy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    JOptionPane.showMessageDialog(null,"Buy success","success",JOptionPane.OK_OPTION);
                }
            
            });
            RoomPanel6.setLayout(new GridLayout(3,1));
            RoomPanel6.add(RoomPanel1);
            RoomPanel6.add(RoomPanel2);
            RoomPanel5.setBackground(Color.PINK);
            RoomPanel4.setLayout(new GridLayout(2,1));
            RoomPanel4.add(RoomPanel5);
            RoomPanel4.add(RoomPanel6);
            RoomPanel3.add(RoomPanel4);
        }
    }
    
    private void detailHotel(Hotel detail){
        
        detailpanel1 = new PicturePanel(detail.getHotelid());
        detailpanel2 = new JPanel();
        detaillabel1 = new JLabel("HotelName: "+detail.getHotelname());
        
        detaillabel3 = new JLabel("HotelPrice: "+detail.getHotelcost());
        
        detaillabel5 = new JLabel("HotelStyle: "+detail.getHotelstyle());
        detaillabel1.setFont(new Font("宋体",Font.BOLD,20));
        detaillabel3.setFont(new Font("宋体",Font.BOLD,20));
        detaillabel5.setFont(new Font("宋体",Font.BOLD,20));
        detailbutton.setFont(new Font("宋体",Font.BOLD,20));
//        detailbuttonbuy.setFont(new Font("宋体",Font.BOLD,20));
        detailroominfo.setFont(new Font("宋体",Font.BOLD,20));
        
        detaillabel6 = new JLabel();
        
        detaillabel6.setLayout(new GridLayout(1,2));
        detaillabel6.add(detailbutton);
//        detaillabel6.add(detailbuttonbuy);
        detaillabel6.add(detailroominfo);
//        detailbutton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                
//                Hotelinformation();
//            }
//        });
//        detailbuttonbuy.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                JOptionPane.showMessageDialog(null,"Buy success","success",JOptionPane.OK_OPTION);
//            }
//        });
        
        
        detailpanel2.setLayout(new GridLayout(4,1));
        detailpanel2.add(detaillabel1);
        
        detailpanel2.add(detaillabel3);
        
        detailpanel2.add(detaillabel5);
        
        detailpanel2.add(detaillabel6);
        
        
    }
    
    private void NavigateBar(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu2.add(jMenuItem3);

        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenu4.add(jRadioButtonMenuItem2);

        jMenu4.add(jRadioButtonMenuItem1);

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
    
    private void OrderList(ArrayList<Order> orderinfo){
//        this.setLayout(new GridLayout(2,1) );
//        this.getContentPane().removeAll();
        orderlistpanel1.setLayout(new GridLayout(orderinfo.size(),1) );
        orderlistpanel1.setBounds(20,20,500,500);
        for(int i=0;i<orderinfo.size();i++){
            orderlistpanel = new JPanel();
            orderlistpanel.setLayout(new GridLayout(5,2));
            orderlistpanel.setBackground(Color.green);
            orderlistlabel_1  = new JLabel("No:   "+orderinfo.get(i).getOrderid());
            orderlistlabel_2  = new JLabel("UserID:   "+orderinfo.get(i).getUserid());
            orderlistlabel_3  = new JLabel("UserName:   "+orderinfo.get(i).getUsertruename());
            orderlistlabel_4  = new JLabel("UserPhone:   "+orderinfo.get(i).getUserphone());
            orderlistlabel_5  = new JLabel("BoookDay:   "+orderinfo.get(i).getBookday());
            orderlistlabel_6  = new JLabel("TotalCost:   "+orderinfo.get(i).getTotalcost());
            orderlistlabel_7  = new JLabel("HotelName:   "+orderinfo.get(i).getHotename());
            orderlistlabel_8  = new JLabel("RoomStyle:   "+orderinfo.get(i).getRoomstyle());
            orderlistlabel_9  = new JLabel("Status:   "+orderinfo.get(i).getOrderstatus());
            
            orderlistpanel.add(orderlistlabel_1);
            orderlistpanel.add(orderlistlabel_2);
            orderlistpanel.add(orderlistlabel_3);
            orderlistpanel.add(orderlistlabel_4);
            orderlistpanel.add(orderlistlabel_5);
            orderlistpanel.add(orderlistlabel_6);
            orderlistpanel.add(orderlistlabel_7);
            orderlistpanel.add(orderlistlabel_8);
            orderlistpanel.add(orderlistlabel_9);
            
            
            orderlistbu1 = new JButton("Delete");
            orderlistpanel.add(orderlistbu1);
            orderlistbu1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    orderlistpanel.setBackground(Color.GRAY);
                }
            
            });
            
            
            orderlistpanel1.add(orderlistpanel);
        }
        
//        this.getContentPane().add(orderlistScroll);
//        this.setVisible(true);
//        this.revalidate();
//        this.repaint();
    }
    
    private void HotelList(ArrayList<Hotel> hotelinfo){
        Hotellistpanel1.setLayout(new GridLayout(hotelinfo.size()/2,4,10,10));
        orderlistpanel1.setBounds(new Rectangle(25,25,25,25));
        for(int i=0;i<hotelinfo.size();i++)
        {
            Hotellistpanel = new JPanel();
            Hotellistpanel.setLayout(new GridLayout(2,1));
            Hotellistpanel.setPreferredSize(new Dimension(150, 300));
            Hotellistpanel_1 = new PicturePanel(i);
            Hotellistpanel_2 = new JPanel();
            Hotellistpanel_2.setLayout(new GridLayout(2,1));
            Hotellistpanel_3 = new JPanel();
            Hotellistpanel_4 = new JPanel();
            Hotellistpanel_4.setLayout(new GridLayout(1,3));
            Hotellistlabel = new JLabel("HotelName: "+hotelinfo.get(i).getHotelname());
            Hotellistbutton1 = new JRadioButton("Like");
            Hotellistbutton2 = new JRadioButton("DisLike");
            group = new ButtonGroup();
            group.add(Hotellistbutton1);
            group.add(Hotellistbutton2);
            hotel = hotelinfo.get(i);
            Hotellistbu1 = new JButton("Detail");
            Hotellistbu1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    detailHotelinfo(hotel);
                }
            
            });
            
           
            Hotellistpanel_3.setBackground(Color.cyan);
            Hotellistpanel_4.setBackground(Color.GRAY);
            Hotellistpanel_1.setPreferredSize(new Dimension(150,200));
            Hotellistpanel_2.setPreferredSize(new Dimension(150,50));
            Hotellistpanel_3.setPreferredSize(new Dimension(150,50));
            Hotellistpanel_3.add(Hotellistlabel);
            
            Hotellistpanel_4.add(Hotellistbutton1);
            Hotellistpanel_4.add(Hotellistbutton2);
            Hotellistpanel_4.add(Hotellistbu1);
            
            Hotellistpanel_2.add(Hotellistpanel_3);
            Hotellistpanel_2.add(Hotellistpanel_4);
            
            Hotellistpanel.add(Hotellistpanel_1);
            Hotellistpanel.add(Hotellistpanel_2);
            
            
            Hotellistpanel1.add(Hotellistpanel);
            Hotellistpanel.setVisible(true);
        }
    }

    private class PicturePanel extends JPanel{
        private ImageIcon image;
        private int index;
        public PicturePanel(int i){
            index = i;
        }
        public void paintComponent(Graphics g){
            image = new ImageIcon("src/main/java/com/mycompany/view/HotelPictures/"+index+".jpg");
            g.drawImage(image.getImage(),0,0,getSize().width,getSize().height,this);
            this.setBackground(Color.PINK);
            
        }
    }
    
     public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
        this.registerButton.addActionListener(listener);
        this.ButtonforRegister.addActionListener(listener);
//        this.Back.addActionListener(listener);
        this.jMenuItem1.addActionListener(listener);//change password
        this.jMenuItem2.addActionListener(listener);//Exit
        this.jMenuItem3.addActionListener(listener);//Collection
        this.jMenuItem5.addActionListener(listener);//Order
        this.jRadioButtonMenuItem1.addActionListener(listener);//Double room
        this.jRadioButtonMenuItem2.addActionListener(listener);//Single room
        this.jRadioButtonMenuItem3.addActionListener(listener);//Breakfast
//        this.Roombuy.addActionListener(listener);//Buy
        this.detailbutton.addActionListener(listener);//back to the hotelinfo
        this.detailroominfo.addActionListener(listener);//go to Roominfo
//        this.orderlistbu1.addActionListener(listener);//Delete
    }
     
     
     
    @Override
     public void update(Observable o, Object arg){
          DataMessage data = (DataMessage) arg;
          System.out.println("update going");
          System.out.println("Loginfalg: "+data.getLoginflag());
          System.out.println("registerflag: "+data.getRegisterflag());
          System.out.println("checkflag: "+data.getCheckflag());
          System.out.println("gethotelinfoflag: "+data.getGethotelinfoflag());
          System.out.println("getorderinfoflag: "+data.getGetorderinfoflag());
        if (data.getLoginflag() == 0) { // If loginFlage is false, then ask the user to input again.
            JOptionPane.showMessageDialog(LoginPanel4, "Please Enter the right username and password", "Error",JOptionPane.ERROR_MESSAGE);
            this.unInput.setText("");
            this.pwInput.setText("");
        }
        if(data.getGethotelinfoflag()== 1 ){
            hotelinfo = (ArrayList<Hotel>)data.getSource();
            System.out.println(hotelinfo.size());
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
            orderinfo = (ArrayList)data.getSource();
            System.out.println(" got orderinfoflag");
        }
        if(data.getGetroominfoflag() == 1)
        {
            roominfo = (ArrayList)data.getSource();
            
            System.out.println(" got roominfoflag   "+roominfo);
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
