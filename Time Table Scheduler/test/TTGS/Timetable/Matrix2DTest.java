/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTGS.Timetable;

import java.util.Vector;
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
public class Matrix2DTest {
    
    public Matrix2DTest() {
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
     * Test of getR method, of class Matrix2D.
     */
    @Test
    public void testGetR() {
        System.out.println("getR");
        Matrix2D instance = null;
        int expResult = 0;
        int result = instance.getR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getC method, of class Matrix2D.
     */
    @Test
    public void testGetC() {
        System.out.println("getC");
        Matrix2D instance = null;
        int expResult = 0;
        int result = instance.getC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearContent method, of class Matrix2D.
     */
    @Test
    public void testClearContent() {
        System.out.println("clearContent");
        Matrix2D instance = null;
        instance.clearContent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class Matrix2D.
     */
    @Test
    public void testGetContent_0args() {
        System.out.println("getContent");
        Matrix2D instance = null;
        Vector expResult = null;
        Vector result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class Matrix2D.
     */
    @Test
    public void testGetContent_int_int() {
        System.out.println("getContent");
        int i = 0;
        int j = 0;
        Matrix2D instance = null;
        Object expResult = null;
        Object result = instance.getContent(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContent method, of class Matrix2D.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        int i = 0;
        int j = 0;
        Object t = null;
        Matrix2D instance = null;
        instance.setContent(i, j, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Init method, of class Matrix2D.
     */
    @Test
    public void testInit() {
        System.out.println("Init");
        Object t = null;
        Matrix2D instance = null;
        instance.Init(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Matrix2D.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Matrix2D instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
