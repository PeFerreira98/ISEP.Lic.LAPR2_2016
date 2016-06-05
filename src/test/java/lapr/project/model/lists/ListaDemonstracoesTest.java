/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
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
public class ListaDemonstracoesTest {
    
    public ListaDemonstracoesTest() {
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
     * Test of addDemonstracao method, of class ListaDemonstracoes.
     */
    @Test
    public void testAddDemonstracao() {
        System.out.println("addDemonstracao");
        
        Demonstracao demonstracao = new Demonstracao("demo1");
        ListaDemonstracoes instance = new ListaDemonstracoes();
        
        boolean expResult = true;
        boolean result = instance.addDemonstracao(demonstracao);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDemonstracoes method, of class ListaDemonstracoes.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        
        ListaDemonstracoes instance = new ListaDemonstracoes();
        List<Demonstracao> expResult = new ArrayList<>();
        
        List<Demonstracao> result = instance.getListaDemonstracoes();
        
        assertEquals(expResult, result);
    }
    
}
