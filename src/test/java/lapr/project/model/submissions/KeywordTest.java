/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class KeywordTest {

    public KeywordTest() {
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
     * Test of equals method, of class Keyword.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Object();
        Keyword instance = new Keyword("keyword");
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        Keyword k = new Keyword("keyword");
        expResult = true;
        result = instance.equals(k);
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Keyword.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Keyword instance = new Keyword("keyword");
        Keyword k = new Keyword("keyword");
        int expResult = k.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

}
