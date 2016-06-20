/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TiagoSilvestre
 */
public class StandTest {
    
    public StandTest() {
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
     * Test of setDesignacao method, of class Stand.
     */
    @Test
    public void testSetDesignacao() {
        System.out.println("setDesignacao");
        String designacao = "designacao";
        Stand instance = new Stand("des1");
        instance.setDesignacao(designacao);
    }

    /**
     * Test of getDesignacao method, of class Stand.
     */
    @Test
    public void testGetDesignacao() {
        System.out.println("getDesignacao");
        Stand instance = new Stand("desc1");
        String expResult = "desc1";
        String result = instance.getDesignacao();
        assertEquals(expResult, result);
    }
    
}
