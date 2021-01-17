/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

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
public class ModelTest {
    
    public ModelTest() {
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

//    /**
//     * Test of getMD5String method, of class Model.
//     */
//    @Test
//    public void testGetMD5String() {
//        System.out.println("getMD5String");
//        String password = "";
//        Model instance = new Model();
//        String expResult = "";
//        String result = instance.getMD5String(password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of checkUserWhenRegister method, of class Model.
//     */
//    @Test
//    public void testCheckUserWhenRegister() {
//        System.out.println("checkUserWhenRegister");
//        String username = "";
//        Model instance = new Model();
//        boolean expResult = false;
//        boolean result = instance.checkUserWhenRegister(username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of register method, of class Model.
//     */
//    @Test
//    public void testRegister() {
//        System.out.println("register");
//        String username = "";
//        String password = "";
//        String email = "";
//        Model instance = new Model();
//        instance.register(username, password, email);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of login method, of class Model.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "weinberlnn";
        String password = "123456";
        Model instance = new Model();
        boolean expResult = true;
        boolean result = instance.login(username, password);
        assertEquals(expResult, result);
        
    }
//
//    /**
//     * Test of modifyPassword method, of class Model.
//     */
//    @Test
//    public void testModifyPassword() {
//        System.out.println("modifyPassword");
//        String password = "";
//        Model instance = new Model();
//        instance.modifyPassword(password);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getUserInfo method, of class Model.
//     */
//    @Test
//    public void testGetUserInfo() {
//        System.out.println("getUserInfo");
//        Model instance = new Model();
//        instance.getUserInfo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of logout method, of class Model.
//     */
//    @Test
//    public void testLogout() {
//        System.out.println("logout");
//        Model instance = new Model();
//        instance.logout();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getHotelInfo method, of class Model.
//     */
//    @Test
//    public void testGetHotelInfo() {
//        System.out.println("getHotelInfo");
//        Model instance = new Model();
//        instance.getHotelInfo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getHotelInfoByStyleandBreakfast method, of class Model.
//     */
//    @Test
//    public void testGetHotelInfoByStyleandBreakfast() {
//        System.out.println("getHotelInfoByStyleandBreakfast");
//        String hotelstyle = "";
//        String hotelbreakfast = "";
//        Model instance = new Model();
//        instance.getHotelInfoByStyleandBreakfast(hotelstyle, hotelbreakfast);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRoomInfo method, of class Model.
//     */
//    @Test
//    public void testGetRoomInfo() {
//        System.out.println("getRoomInfo");
//        int hotelid = 0;
//        Model instance = new Model();
//        instance.getRoomInfo(hotelid);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of booking method, of class Model.
//     */
//    @Test
//    public void testBooking() {
//        System.out.println("booking");
//        int roomid = 0;
//        int roomnumber = 0;
//        Model instance = new Model();
//        instance.booking(roomid, roomnumber);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of formOrder method, of class Model.
//     */
//    @Test
//    public void testFormOrder() {
//        System.out.println("formOrder");
//        String usertruename = "";
//        String userphone = "";
//        int bookday = 0;
//        double totalcost = 0.0;
//        String hotelname = "";
//        String roomstyle = "";
//        Model instance = new Model();
//        instance.formOrder(usertruename, userphone, bookday, totalcost, hotelname, roomstyle);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getOrderInfo method, of class Model.
//     */
//    @Test
//    public void testGetOrderInfo() {
//        System.out.println("getOrderInfo");
//        Model instance = new Model();
//        instance.getOrderInfo();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of pay method, of class Model.
//     */
//    @Test
//    public void testPay() {
//        System.out.println("pay");
//        Model instance = new Model();
//        instance.pay();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addLikeItem method, of class Model.
//     */
//    @Test
//    public void testAddLikeItem() {
//        System.out.println("addLikeItem");
//        int hotelid = 0;
//        Model instance = new Model();
//        instance.addLikeItem(hotelid);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteLikeItem method, of class Model.
//     */
//    @Test
//    public void testDeleteLikeItem() {
//        System.out.println("deleteLikeItem");
//        int hotelid = 0;
//        Model instance = new Model();
//        instance.deleteLikeItem(hotelid);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
