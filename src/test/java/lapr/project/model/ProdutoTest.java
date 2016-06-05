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
public class ProdutoTest {
    
    public ProdutoTest() {
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
     * Test of validaDesignacao method, of class Produto.
     */
    @Test
    public void testValidaDesignacao() {
        System.out.println("validaDesignacao");
        
        String designacao = "something";
        
        boolean expResult = true;
        boolean result = Produto.validaDesignacao(designacao);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Produto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        Object obj = new Produto("something");
        Produto instance = new Produto("something");
        
        boolean expResult = true;
        boolean result = instance.equals(obj);
        
        assertEquals(expResult, result);
    }

    
}
