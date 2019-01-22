/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTGS.Login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class UserTest {
    
    public UserTest() {
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
     * Test of setName method, of class User.
     */
    
    User instance2 = new User();
    @Test
    public void testSetName() {
        System.out.println("setName");
        String Name = "Kavishka";
        
        instance2.setName(Name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName_pass() {
        System.out.println("getName");
        //User instance = new User();
        String Name = "Kavishka";
        
        instance2.setName(Name);
        String expResult = "Kavishka";
        String result = instance2.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    
     @Test
    public void testGetName_fail() {
        System.out.println("getName");
        //User instance = new User();
        String Name = "Nethmal";
        
        instance2.setName(Name);
        String expResult = "Kavishka";
        String result = instance2.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class User.
     */
    @Test
    public void testGetUserName_pass() {
        System.out.println("getUserName");
        User instance = new User();
        
        String userName = "Jazeel";
        instance.setUserName(userName);
        String expResult = "Jazeel";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
     public void testGetUserName_fail() {
        System.out.println("getUserName");
        User instance = new User();
        
        String userName = "Hashan";
        instance.setUserName(userName);
        String expResult = "Jazeel";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class User.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String userName = "Jazeel";
        User instance = new User();
        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword_pass() {
        System.out.println("getPassword");
        User instance = new User();
        String password = "abc1234";
        instance.setPassword(password);
        
        String expResult = "abc1234";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
     public void testGetPassword_fail() {
        System.out.println("getPassword");
        User instance = new User();
        String password = "abcd1234";
        instance.setPassword(password);
        
        String expResult = "abc1234";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "abc1234";
        User instance = new User();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class User.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        User instance = new User();
        String expResult = "Type1";
        String type = "Type1";
        instance.setType(type);
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class User.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "Type1";
        User instance = new User();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
