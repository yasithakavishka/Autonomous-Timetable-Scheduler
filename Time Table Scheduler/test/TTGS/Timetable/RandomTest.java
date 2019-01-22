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
public class RandomTest {
    
    public RandomTest() {
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
     * Test of getRandValue method, of class Random.
     */
    @Test
    public void testGetRandValue() {
        System.out.println("getRandValue");
        int i = 0;
        Random instance = null;
        int expResult = 0;
        int result = instance.getRandValue(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gcd method, of class Random.
     */
    @Test
    public void testGcd() {
        System.out.println("gcd");
        int a = 10;
        int b = 20;
        int expResult = 10;
        int result = Random.gcd(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    public void testGcd2() {
        System.out.println("gcd");
        int a = 10;
        int b = 45;
        int expResult = 10;
        int result = Random.gcd(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void testGcd3() {
        System.out.println("gcd");
        int a = 1701;
        int b = 3768;
        int expResult = 3;
        int result = Random.gcd(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
