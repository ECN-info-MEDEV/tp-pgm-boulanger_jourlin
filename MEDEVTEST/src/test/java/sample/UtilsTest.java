/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Boulanger
 */
public class UtilsTest {
    
    public UtilsTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of concatWords method, of class Utils.
     */
    @Test
    public void testConcatWords() {
        System.out.println("concatWords");
        assertFalse(Utils.concatWords(new String[]{" "+" "+" "}).equals (""));
        assertTrue(Utils.concatWords(new String[]{"Hello"+" "+"World"}).equals("Hello World"));
        assertFalse(Utils.concatWords(new String[]{""+" "+"World"}).equals( "World"));
    }

    /**
     * Test of computeFactorial method, of class Utils.
     */
    @Test
    public void testComputeFactorial() {
        System.out.println("computeFactorial");
        //assertFalse(Utils.computeFactorial(0));
        assertEquals("1",Utils.computeFactorial(1));
        assertEquals("24",Utils.computeFactorial(4));
        assertEquals("479001600",Utils.computeFactorial(12));
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void checkExpectedException() {
        System.out.println("checkExpectedException");
        final int factorialOf = -5;
        System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
    }
    
}
