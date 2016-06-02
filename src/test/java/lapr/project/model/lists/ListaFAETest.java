/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Utilizador;
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
public class ListaFAETest {
    
    public ListaFAETest() {
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
     * Test of addFAE method, of class ListaFAE.
     */
    @Test
    public void testAddFAE() {
        System.out.println("addFAE");
        
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email", "FAE");

        FAE fae = new FAE(utilizador);
        ListaFAE instance = new ListaFAE();
        
        boolean expResult = true;
        boolean result = instance.addFAE(fae);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaFAE method, of class ListaFAE.
     */
    @Test
    public void testGetListaFAE() {
        System.out.println("getListaFAE");
        
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email", "FAE");
        FAE fae = new FAE(utilizador);
        
        ListaFAE instance = new ListaFAE();
        List<FAE> instance2 = new ArrayList<FAE>();
        
        instance.addFAE(fae);
        instance2.add(fae);
        
        List<FAE> expResult = instance2;
        List<FAE> result = instance.getListaFAE();
        
        assertEquals(expResult, result);
    }
    
}
