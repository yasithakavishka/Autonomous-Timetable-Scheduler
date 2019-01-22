/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTGS.Timetable;

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
public class RulesTest {
    
    public RulesTest() {
    }
    
    /*Sometimes several tests need to share computationally expensive setup (like logging into a database). 
    While this can compromise the independence of tests, sometimes it is a necessary optimization. 
    Annotating a public static void no-arg method with @BeforeClass causes it to be run once before any of 
    the test methods in the class. The @BeforeClass methods of superclasses will be run before those the current class.*/
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    
    
    /*If you allocate expensive external resources in a BeforeClass method you need to release them after all the tests in the class have run. 
    Annotating a public static void method with @AfterClass causes that method to be run after all the tests in the class have been run. 
    All @AfterClass methods are guaranteed to run even if a BeforeClass method throws an exception.
    The @AfterClass methods declared in superclasses will be run after those of the current class.*/
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    /*When writing tests, it is common to find that several tests need similar objects created before they can run.
    Annotating a public void method with @Before causes that method to be run before the Test method. 
    The @Before methods of superclasses will be run before those of the current class.*/
    @Before
    public void setUp() {
    }
    
    /*If you allocate external resources in a Before method you need to release them after the test runs. 
    Annotating a public void method with @After causes that method to be run after the Test method. 
    All @After methods are guaranteed to run even if a Before or Test method throws an exception. 
    The @After methods declared in superclasses will be run after those of the current class.*/
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCollageName method, of class Rules.
     */
    @Test
    public void testSetCollageName() {
        System.out.println("setCollageName");
        String _collageName = "University of Peradeniya";
        Rules instance = new Rules();
        instance.setCollageName(_collageName);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getCollageName method, of class Rules.
     */
    @Test
    public void testGetCollageName() {
        System.out.println("getCollageName");
        Rules instance = new Rules();
        String _collageName = "University of Peradeniya";
        instance.setCollageName(_collageName);
        String expResult = "University of Peradeniya";
        String result = instance.getCollageName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDeptName method, of class Rules.
     */
    @Test
    public void testSetDeptName() {
        System.out.println("setDeptName");
        String _deptName = "Civil";
        Rules instance = new Rules();
        instance.setDeptName(_deptName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDeptName method, of class Rules.
     */
    @Test
    public void testGetDeptName_pass() {
        System.out.println("getDeptName");
        String _deptName = "Computer";
        Rules instance = new Rules();
        instance.setDeptName(_deptName);
        String expResult = "Computer";
        String result = instance.getDeptName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetDeptName_fail() {
        System.out.println("getDeptName");
        String _deptName = "Civil";
        Rules instance = new Rules();
        instance.setDeptName(_deptName);
        String expResult = "Computer";
        String result = instance.getDeptName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBreak method, of class Rules.
     */
    @Test
    public void testSetBreak() {
        System.out.println("setBreak");
        String _break = "";
        Rules instance = new Rules();
        instance.setBreak(_break);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBreak method, of class Rules.
     */
    @Test
    public void testGetBreak() {
        System.out.println("getBreak");
        Rules instance = new Rules();
        String expResult = "11-12";
        String result = instance.getBreak();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoom method, of class Rules.
     */
    @Test
    public void testSetRoom() {
        System.out.println("setRoom");
        Matrix3D<Boolean> room = null;
        Rules instance = new Rules();
        instance.setRoom(room);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoom method, of class Rules.
     */
    @Test
    public void testGetRoom() {
        System.out.println("getRoom");
        Rules instance = new Rules();
        Matrix3D<Boolean> expResult = null;
        Matrix3D<Boolean> result = instance.getRoom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeacher method, of class Rules.
     */
    @Test
    public void testSetTeacher() {
        System.out.println("setTeacher");
        Matrix3D<Boolean> tch = null;
        Rules instance = new Rules();
        instance.setTeacher(tch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeacher method, of class Rules.
     */
    @Test
    public void testGetTeacher() {
        System.out.println("getTeacher");
        Rules instance = new Rules();
        Matrix3D<Boolean> expResult = null;
        Matrix3D<Boolean> result = instance.getTeacher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStudent method, of class Rules.
     */
    @Test
    public void testSetStudent() {
        System.out.println("setStudent");
        Matrix3D<Boolean> stud = null;
        Rules instance = new Rules();
        instance.setStudent(stud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudent method, of class Rules.
     */
    @Test
    public void testGetStudent() {
        System.out.println("getStudent");
        Rules instance = new Rules();
        Matrix3D<Boolean> expResult = null;
        Matrix3D<Boolean> result = instance.getStudent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
