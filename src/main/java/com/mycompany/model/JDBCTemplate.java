/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.entity.Hotel;
import com.mycompany.entity.LikeItem;
import com.mycompany.entity.Order;
import com.mycompany.entity.Room;
import com.mycompany.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WeinberLnn
 */
public class JDBCTemplate{
    public DBManager dBManager;
    public Connection conn;
    public String username;
    public JDBCTemplate(){
        dBManager = new DBManager();
        conn = dBManager.getConnection();
    }
    /*
    * Check username whether be used in database when register
    */
    public boolean checkUserWhenRegister(String username){
        String checksql = "SELECT * FROM HOTELUSER WHERE USERNAME=?";
        try {
            PreparedStatement pst = conn.prepareStatement(checksql);
            pst.setString(1,username);
            ResultSet result = pst.executeQuery();
            if(result.next()){
                return false;
            }
            else{
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /*
    * Register an account by username,password and email
    * Userid will be formed automatically
    */
    public boolean register(String username,String password,String email){
        String registersql = "INSERT INTO HOTELUSER VALUES(?,?,?,?,?)";
        String checkidsql = "SELECT * FROM HOTELUSER";
        try{
            int userid = 0;
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(checkidsql);
            while(result.next()){
                userid = result.getInt("userid");
            }
            PreparedStatement pstm = conn.prepareStatement(registersql);
            pstm.setInt(1,userid+1);
            pstm.setString(2,username);
            pstm.setString(3,password);
            pstm.setString(4,email);
            pstm.setString(5,null);
            pstm.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    /*
    * Login by username and password
    */
    public User login(String username,String password){
        String loginsql = "SELECT * FROM HOTELUSER WHERE USERNAME=? AND PASSWORD=?";
        try{
            PreparedStatement pstm = conn.prepareStatement(loginsql);
            pstm.setString(1,username);
            pstm.setString(2, password);
            ResultSet result = pstm.executeQuery();
            if(result.next()){
                User user = new User(result.getInt("USERID"),result.getString("USERNAME"),result.getString("PASSWORD"),result.getString("USEREMAIL"),result.getString("USERSCULPTURE"));
                return user;
            }
            else{
                return null;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        
    }
    public void modifyPassword(String username,String password){
        String modifypasswordsql = "UPDATE HOTELUSER SET PASSWORD = ? WHERE USERNAME = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(modifypasswordsql);
            pstm.setString(1, password);
            pstm.setString(2, username);
            pstm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    /*
    * Get some Hotel information by userid.
    * Use recommend algorithm base on UserCF.
    * If table LikeItem is empty or the hotel number is lower than 5, it will 
    * return five hotel which the point is the highest.
    */
    public ArrayList<Hotel> getHotelInfo(int userid){
        int size = 0;
        List<LikeItem> likeLists = new ArrayList<>();
	ArrayList<Hotel> recomLists = new ArrayList<>();
        List<Hotel> hotels = new ArrayList<>();
        List<User> users = new ArrayList<>();
	String sql = "SELECT * FROM HOTELUSER";
        String sql5 = "SELECT * FROM HOTEL";
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql5);
            while(result.next()){
                Hotel hotel = new Hotel(result.getInt("HOTELID"),result.getString("HOTELNAME"),result.getDouble("HOTELCOST"),result.getString("HOTELSTYLE"),result.getString("HOTELBREAKFAST"),result.getString("HOTELPICTURE"),result.getInt("HOTELNUMBER"),result.getDouble("HOTELPOINT"),result.getDouble("HOTELSIMILARITY"));
                hotels.add(hotel);
            }
            result = stm.executeQuery(sql);
            while(result.next()){
                User user = new User(result.getInt("userid"),result.getString("username"),result.getString("password"),result.getString("useremail"),result.getString("usersculpture"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	int[][] curMatrix = new int[hotels.size()+5][hotels.size()+5];
	int[][] comMatrix = new int[hotels.size()+5][hotels.size()+5];
	int[] N = new int[hotels.size()+5];
	TreeSet<Hotel> oldList2 = new TreeSet<Hotel>(new Comparator<Hotel>() {

            @Override
            public int compare(Hotel o1, Hotel o2) {
                if(o1.getHotelpoint()!=o2.getHotelpoint()){
                    return (int)((o1.getHotelpoint()-o2.getHotelpoint())*100);
                }
                else{
                    return o2.getHotelid()-o1.getHotelid();
                }
            }
			
	});
	for(Hotel hotel : hotels) {
            oldList2.add(hotel);
	}
        size = oldList2.size();
	for(int m=0;m<users.size();m++) {
            User customer = users.get(m);
            if (customer.getUserid()==userid)
		continue;
            String sql2 = "SELECT * FROM LIKEITEM WHERE USERID = ?";
            try{
                PreparedStatement pstm = conn.prepareStatement(sql2);
                pstm.setInt(1, customer.getUserid());
                ResultSet result = pstm.executeQuery();
                while(result.next()){
                    LikeItem likeItem = new LikeItem(result.getInt("likeid"),result.getInt("userid"),result.getInt("hotelid"));
                    likeLists.add(likeItem);
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            if(likeLists.size()!=0) {	
		for(int i =0; i < hotels.size();i++)
                    for(int j=0;j<hotels.size();j++)
			curMatrix[i][j]=0;
		for(int i=0;i<hotels.size();i++) {
                    int kindId1 = likeLists.get(i).getHotelid();
                    ++N[kindId1];
                    for(int j=i+1;j<hotels.size();j++) {
			int kindId2 = likeLists.get(j).getHotelid();
			++curMatrix[kindId1][kindId2];
			++curMatrix[kindId2][kindId1];
                    }
		}
            }
            else
                continue;
	}
	TreeSet<Hotel> preList = new TreeSet<Hotel>(new Comparator<Hotel>() {

            @Override
            public int compare(Hotel o1, Hotel o2) {
		if(o1.getHotelsimilarity()!=o2.getHotelsimilarity())
                    return (int)(o1.getHotelsimilarity()-o2.getHotelsimilarity())*100;
		else
                    return (int)(o1.getHotelpoint()-o2.getHotelpoint());
            }
			
	});
	if(likeLists.size()!=0) {
            boolean[]used = new boolean[hotels.size()+5];
            for(LikeItem like : likeLists) {
		int Nij=0;
		double Wij;
		Hotel tmp;
		int i = like.getHotelid();
		for(Hotel hotel : hotels) {
                    if(i==hotel.getHotelid())
			continue;
                    int j = hotel.getHotelid();
                    Nij = comMatrix[i][j];
                    Wij = (double)Nij/Math.sqrt(N[i]*N[j]);
                    String sql4 = "SELECT * FROM HOTEL WHERE HOTELID = ?";
                    try{
                        PreparedStatement pstm = conn.prepareStatement(sql4);
                        pstm.setInt(1, j);
                        ResultSet result = pstm.executeQuery();
                        tmp = new Hotel(result.getInt("HOTELID"),result.getString("HOTELNAME"),result.getDouble("HOTELCOST"),result.getString("HOTELSTYLE"),result.getString("HOTELBREAKFAST"),result.getString("HOTELPICTURE"),result.getInt("HOTELNUMBER"),result.getDouble("HOTELPOINT"),result.getDouble("HOTELSIMILARITY"));
                        tmp.setHotelsimilarity(Wij);
                        if(used[tmp.getHotelid()])
                            continue;
                        preList.add(tmp);
			used[tmp.getHotelid()] = true;
                    }catch(SQLException ex){
                        ex.printStackTrace();
                    }		
		}
            }
	}
	for(int i=0;preList.size()>0&&i<5;i++) {
            recomLists.add(preList.pollLast());
	}
	while(recomLists.size()<size) {
            recomLists.add(oldList2.pollLast());
	}
	return recomLists;
    }
    /*
    * Select some hotel by hotelstyle such as 'double bed' or 'single bed'.
    * The output will be sorted by HotelPoint
    */
    public ArrayList<Hotel> getHotelInfoByStyle(String hotelstyle){
        String hotelinfosql = "SELECT * FROM HOTEL WHERE HOTELSTYLE = ?";
        ArrayList<Hotel> hotelcollection = new ArrayList<>();
        try{
            PreparedStatement pstm = conn.prepareStatement(hotelinfosql);
            pstm.setString(1, hotelstyle);
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                 Hotel hotel = new Hotel(result.getInt("HOTELID"),result.getString("HOTELNAME"),result.getDouble("HOTELCOST"),result.getString("HOTELSTYLE"),result.getString("HOTELBREAKFAST"),result.getString("HOTELPICTURE"),result.getInt("HOTELNUMBER"),result.getDouble("HOTELPOINT"),result.getDouble("HOTELSIMILARITY"));
                 hotelcollection.add(hotel);
            }
            Collections.sort(hotelcollection, new Comparator< Hotel >() {

                @Override
                public int compare(Hotel lhs, Hotel rhs) {
                    int point1 = (int)(lhs.getHotelpoint()*10);
                    int point2 = (int)(rhs.getHotelpoint()*10);
                    return point2-point1;
                }
            });
            return hotelcollection;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Hotel getHotelById(int hotelid){
        String hotelinfosql = "SELECT * FROM HOTEL WHERE HOTELID = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(hotelinfosql);
            pstm.setInt(1, hotelid);
            ResultSet result =  pstm.executeQuery();
            if(result.next()){
                Hotel hotel = new Hotel(result.getInt("HOTELID"),result.getString("HOTELNAME"),result.getDouble("HOTELCOST"),result.getString("HOTELSTYLE"),result.getString("HOTELBREAKFAST"),result.getString("HOTELPICTURE"),result.getInt("HOTELNUMBER"),result.getDouble("HOTELPOINT"),result.getDouble("HOTELSIMILARITY"));
                return hotel;
            }
            return null;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    /*
    * Select some hotels by hotelbreakfast such as 'yes' or 'no' which means 
    * this hotel will have breakfast or not.
    * The output will be sorted by HotelPoint.
    */
    public ArrayList<Hotel> getHotelInfoByBreakfast(String hotelbreakfast){
        String hotelinfosql = "SELECT * FROM HOTEL WHERE HOTELBREAKFAST = ?";
        ArrayList<Hotel> hotelcollection = new ArrayList<>();
        try{
            PreparedStatement pstm = conn.prepareStatement(hotelinfosql);
            pstm.setString(1, hotelbreakfast);
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                 Hotel hotel = new Hotel(result.getInt("HOTELID"),result.getString("HOTELNAME"),result.getDouble("HOTELCOST"),result.getString("HOTELSTYLE"),result.getString("HOTELBREAKFAST"),result.getString("HOTELPICTURE"),result.getInt("HOTELNUMBER"),result.getDouble("HOTELPOINT"),result.getDouble("HOTELSIMILARITY"));
                 hotelcollection.add(hotel);
            }
            Collections.sort(hotelcollection, new Comparator< Hotel >() {

                @Override
                public int compare(Hotel lhs, Hotel rhs) {
                    int point1 = (int)(lhs.getHotelpoint()*10);
                    int point2 = (int)(rhs.getHotelpoint()*10);
                    return point2-point1;
                }
            });
            return hotelcollection;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public ArrayList<Hotel> selectHotelInfo(String hotelstyle,String hotelbreakfast){
        ArrayList<Hotel> style = this.getHotelInfoByStyle(hotelstyle);
        ArrayList<Hotel> breakfast = this.getHotelInfoByBreakfast(hotelbreakfast);
        for(Hotel hotel : style){
            breakfast.add(hotel);
        }
        return breakfast;
    }
    /*
    * Get some room information under the hotel.
    */
    public ArrayList<Room> getRoomInfo(int hotelid){
        String roominfosql = "SELECT * FROM HOTELROOM WHERE HOTELID = ?";
        ArrayList<Room> roomcollection = new ArrayList<>();
        try{
            PreparedStatement pstm = conn.prepareStatement(roominfosql);
            pstm.setInt(1, hotelid);
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                 Room room = new Room(result.getInt("roomid"),result.getInt("hotelid"),result.getString("roomstyle"),result.getDouble("roomcost"),result.getInt("roomnumber"));
                 roomcollection.add(room);
            }
            return roomcollection;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Room getRoomByRoomid(int roomid){
        String roominfosql = "SELECT * FROM HOTELROOM WHERE ROOMID = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(roominfosql);
            pstm.setInt(1, roomid);
            ResultSet result = pstm.executeQuery();
            if(result.next()){
                Room room = new Room(result.getInt("roomid"),result.getInt("hotelid"),result.getString("roomstyle"),result.getDouble("roomcost"),result.getInt("roomnumber"));
                return room;
            }
            else{
                return null;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    /*
    * Booking the hotel's room by roomid and roomnumber
    * If roomnumber is lower than zero after booking, the database will rollback
    */
    public boolean booking(int roomid,int roomnumber){
        Room room = null;
        String existroomsql = "SELECT * FROM HOTELROOM WHERE ROOMID = ?";
        String updateroomsql = "UPDATE HOTELROOM SET ROOMNUMBER =? WHERE ROOMID = ?";
        try{
            conn.setAutoCommit(false);
            PreparedStatement pstm = conn.prepareStatement(updateroomsql);
            pstm.setInt(1, roomnumber-1);
            pstm.setInt(2,roomid);
            pstm.executeUpdate();
            conn.commit();
            pstm = conn.prepareStatement(existroomsql);
            pstm.setInt(1, roomid);
            ResultSet result = pstm.executeQuery();
            if(result.next()){
                room = new Room(result.getInt("roomid"),result.getInt("hotelid"),result.getString("roomstyle"),result.getDouble("roomcost"),result.getInt("roomnumber"));
            }
            if(room.getRoomnumber()<0){
                throw new RuntimeException("room is not enough");
            }
            else{
                conn.setAutoCommit(true);
                return true;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(RuntimeException ex){
            ex.printStackTrace();
            try {
                conn.rollback();
                conn.setAutoCommit(true);
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(JDBCTemplate.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }
    /*
    * Form the order information and insert it to the database
    */
    public void formOrder(int userid,String usertruename,String userphone,int bookday,double totalcost,String hotelname,String roomstyle){
        String formordersql = "INSERT INTO HOTELORDER VALUES(?,?,?,?,?,?,?,?,?)";
        String selectsql = "SELECT * FROM HOTELORDER";
        Order order = null;
        try{
            PreparedStatement pstm = conn.prepareStatement(selectsql);
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                order = new Order(result.getInt("orderid"),result.getInt("userid"),result.getString("usertruename"),result.getString("userphone"),result.getInt("bookday"),result.getDouble("totalcost"),result.getString("hotelname"),result.getString("roomstyle"),result.getString("orderstatus"));
            }
            pstm = conn.prepareStatement(formordersql);
            pstm.setInt(1, order.getOrderid()+1);
            pstm.setInt(2, userid);
            pstm.setString(3, usertruename);
            pstm.setString(4, userphone);
            pstm.setInt(5,bookday);
            pstm.setDouble(6, totalcost);
            pstm.setString(7, hotelname);
            pstm.setString(8,roomstyle);
            pstm.setString(9, "Ordered");
            pstm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    /*
    * Get user's order by userid
    */
    public ArrayList<Order> getOrderInfo(int userid){
        String orderinfosql = "SELECT * FROM HOTELORDER WHERE USERID = ?";
        ArrayList<Order> ordercollection = new ArrayList<>();
        try{
            PreparedStatement pstm = conn.prepareStatement(orderinfosql);
            pstm.setInt(1,userid);
            ResultSet result = pstm.executeQuery();
            while(result.next()){
                Order order = new Order(result.getInt("orderid"),result.getInt("userid"),result.getString("usertruename"),result.getString("userphone"),result.getInt("bookday"),result.getDouble("totalcost"),result.getString("hotelname"),result.getString("roomstyle"),result.getString("orderstatus"));
                ordercollection.add(order);
            }
            return ordercollection;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public void cancelOrder(int orderid){
        String cancelordersql = "UPDATE HOTELORDER SET ORDERSTATUS = ? WHERE ORDERID = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(cancelordersql);
            pstm.setString(1, "Cancel");
            pstm.setInt(2, orderid);
            pstm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    /*
    * Pay method which probably can use AliPay API.
    */
    public void pay(){
        
    }
    public void logout(){
        dBManager.closeConnection();
    }
    /*
    * Add some hotel that user like.
    * This result can be used to UserCF.
    */
    public void addLikeItem(int userid,int hotelid){
        String addlikeitemsql = "INSERT INTO LIKEITEM VALUES(?,?,?)";
        String selectitemsql = "SELECT * FROM LIKEITEM";
        LikeItem like = null;
        try{
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(selectitemsql);
            while(result.next()){
                like = new LikeItem(result.getInt("likeid"),result.getInt("userid"),result.getInt("hotelid"));
            }
            PreparedStatement pstm = conn.prepareStatement(addlikeitemsql);
            pstm.setInt(1, like.getLikeid()+1);
            pstm.setInt(2, userid);
            pstm.setInt(3, hotelid);
            pstm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void deleteLikeItem(int userid,int hotelid){
        String deletelikeitemsql = "DELETE FROM LIKEITEM WHERE USERID = ? AND HOTELID = ?";
        try{
            PreparedStatement pstm = conn.prepareStatement(deletelikeitemsql);
            pstm.setInt(1,userid);
            pstm.setInt(2,hotelid);
            pstm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
