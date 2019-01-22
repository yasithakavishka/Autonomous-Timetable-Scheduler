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
public class Matrix3DTest {
    
    
    
    public Matrix3DTest() {
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
     * Test of getT method, of class Matrix3D.
     */
    @Test
    public void testGetT() {
        System.out.println("getT");
        Matrix3D instance = null;
        Object expResult = null;
        Object result = instance.getT();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getP method, of class Matrix3D.
     */
    @Test
    public void testGetP() {
        System.out.println("getP");
        Matrix3D instance = null;
        int expResult = 0;
        int result = instance.getP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getR method, of class Matrix3D.
     */
    @Test
    public void testGetR() {
        System.out.println("getR");
        Matrix3D instance = null;
        int expResult = 0;
        int result = instance.getR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getC method, of class Matrix3D.
     */
    @Test
    public void testGetC() {
        System.out.println("getC");
        Matrix3D instance = null;
        int expResult = 0;
        int result = instance.getC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearContent method, of class Matrix3D.
     */
    @Test
    public void testClearContent() {
        System.out.println("clearContent");
        Matrix3D instance = null;
        instance.clearContent();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class Matrix3D.
     */
    @Test
    public void testGetContent_0args() {
        System.out.println("getContent");
        Matrix3D instance = null;
        Vector expResult = null;
        Vector result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContent method, of class Matrix3D.
     */
    @Test
    public void testGetContent_3args() {
        System.out.println("getContent");
        int i = 0;
        int j = 0;
        int k = 0;
        Matrix3D instance = null;
        Object expResult = null;
        Object result = instance.getContent(i, j, k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Matrix3D.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Matrix3D instance = null;
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContent method, of class Matrix3D.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        int i = 0;
        int j = 0;
        int k = 0;
        Object t = null;
        Matrix3D instance = null;
        instance.setContent(i, j, k, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Init method, of class Matrix3D.
     */
    @Test
    public void testInit() {
        System.out.println("Init");
        Object t = null;
        Matrix3D instance = null;
        instance.Init(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get2DPart method, of class Matrix3D.
     */
    @Test
    public void testGet2DPart() {
        System.out.println("get2DPart");
        int i = 0;
        Matrix3D instance = null;
        Matrix2D expResult = null;
        Matrix2D result = instance.get2DPart(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set2DPart method, of class Matrix3D.
     */
//    @Test
//    public void testSet2DPart() {
//        System.out.println("set2DPart");
//        Matrix3D instance = null;
//        instance.set2DPart(null);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
