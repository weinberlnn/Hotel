/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.entity.Hotel;
import com.mycompany.entity.Order;
import com.mycompany.entity.Room;
import com.mycompany.entity.User;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mac
 */
public class JDBCTemplateTest {
    
    public JDBCTemplateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkUserWhenRegister method, of class JDBCTemplate.
     */
    @Test
    public void testCheckUserWhenRegister() {
        System.out.println("checkUserWhenRegister");
        String username = "weinberlnn";
        JDBCTemplate instance = new JDBCTemplate();
        boolean expResult = false;
        boolean result = instance.checkUserWhenRegister(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of register method, of class JDBCTemplate.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String username = "nanzy";
        String password = "123456";
        String email = "1259683880@qq.com";
        JDBCTemplate instance = new JDBCTemplate();
        boolean expResult = true;
        boolean result = instance.register(username, password, email);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of login method, of class JDBCTemplate.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "weinberlnn";
        String password = "123456";
        JDBCTemplate instance = new JDBCTemplate();
        String expResult = "weinberlnn";
        String result = instance.login(username, password).getUsername();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHotelInfo method, of class JDBCTemplate.
     */
    @Test
    public void testGetHotelInfo() {
        System.out.println("getHotelInfo");
        int userid = 1000;
        JDBCTemplate instance = new JDBCTemplate();
        String expResult = "华美达大酒店";
        String result = instance.getHotelInfo(userid).get(0).getHotelname();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHotelInfoByStyle method, of class JDBCTemplate.
     */
    @Test
    public void testGetHotelInfoByStyle() {
        System.out.println("getHotelInfoByStyle");
        String hotelstyle = "double bed";
        JDBCTemplate instance = new JDBCTemplate();
        String expResult = "华美达大酒店";
        String result = instance.getHotelInfoByStyle(hotelstyle).get(0).getHotelname();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getHotelInfoByBreakfast method, of class JDBCTemplate.
     */
    @Test
    public void testGetHotelInfoByBreakfast() {
        System.out.println("getHotelInfoByBreakfast");
        String hotelbreakfast = "";
        JDBCTemplate instance = new JDBCTemplate();
        ArrayList<Hotel> expResult = null;
        ArrayList<Hotel> result = instance.getHotelInfoByBreakfast(hotelbreakfast);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomInfo method, of class JDBCTemplate.
     */
    @Test
    public void testGetRoomInfo() {
        System.out.println("getRoomInfo");
        int hotelid = 0;
        JDBCTemplate instance = new JDBCTemplate();
        ArrayList<Room> expResult = null;
        ArrayList<Room> result = instance.getRoomInfo(hotelid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of booking method, of class JDBCTemplate.
     */
    @Test
    public void testBooking() {
        System.out.println("booking");
        int roomid = 0;
        int roomnumber = 0;
        JDBCTemplate instance = new JDBCTemplate();
        boolean expResult = false;
        boolean result = instance.booking(roomid, roomnumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formOrder method, of class JDBCTemplate.
     */
    @Test
    public void testFormOrder() {
        System.out.println("formOrder");
        int userid = 0;
        String usertruename = "";
        String userphone = "";
        int bookday = 0;
        double totalcost = 0.0;
        String hotelname = "";
        String roomstyle = "";
        JDBCTemplate instance = new JDBCTemplate();
        instance.formOrder(userid, usertruename, userphone, bookday, totalcost, hotelname, roomstyle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderInfo method, of class JDBCTemplate.
     */
    @Test
    public void testGetOrderInfo() {
        System.out.println("getOrderInfo");
        int userid = 0;
        JDBCTemplate instance = new JDBCTemplate();
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = instance.getOrderInfo(userid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pay method, of class JDBCTemplate.
     */
    @Test
    public void testPay() {
        System.out.println("pay");
        JDBCTemplate instance = new JDBCTemplate();
        instance.pay();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
