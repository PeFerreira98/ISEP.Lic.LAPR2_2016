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
 * @author zero_
 */
public class DemonstracaoTest {
    
    public DemonstracaoTest() {
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
     * Test of validateDesignacao method, of class Demonstracao.
     */
    @Test
    public void testValidateDesignacao() {
        System.out.println("validateDesignacao");
        
        String designacao = "some";
        
        boolean expResult = true;
        boolean result = Demonstracao.validateDesignacao(designacao);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getDesignacao method, of class Demonstracao.
     */
    @Test
    public void testGetDesignacao() {
        System.out.println("getDesignacao");
        
        Demonstracao instance = new Demonstracao("some");
        
        String expResult = "some";
        String result = instance.getDesignacao();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Demonstracao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        Object obj = new Demonstracao("some");
        Demonstracao instance = new Demonstracao("some");
        
        boolean expResult = true;
        boolean result = instance.equals(obj);
        
        assertEquals(expResult, result);
    }
    
}
