/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.users.Utilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Silva
 */
public class RegistoUtilizadoresTest {
    
    public RegistoUtilizadoresTest() {
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
     * Test of checkUtilizadorByUsername method, of class RegistoUtilizadores.
     */
    @Test
    public void testCheckUtilizadorByUsername() {
        System.out.println("checkUtilizadorByUsername");
        String username = "1140957";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = new Utilizador("Sara", username, "xpto", "1140957@isep.ipp.pt", "organizador");
        instance.addUtilizadorNaoRegistado(expResult);
        Utilizador result = instance.checkUtilizadorByUsername(username);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkUtilizadorByEmail method, of class RegistoUtilizadores.
     */
    @Test
    public void testCheckUtilizadorByEmail() {
        System.out.println("checkUtilizadorByEmail");
        String email = "1140957@isep.ipp.pt";
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador expResult = new Utilizador("Sara", "1140957", "xpto", email, "organizador");
        instance.addUtilizadorNaoRegistado(expResult);
        Utilizador result = instance.checkUtilizadorByEmail(email);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addUtilizadorNaoRegistado method, of class RegistoUtilizadores.
     */
    @Test
    public void testAddUtilizadorNaoRegistado() {
        System.out.println("addUtilizadorNaoRegistado");
        Utilizador utilizador = new Utilizador("Sara", "1140957", "xpto", "1140957@isep.ipp.pt", "organizador");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = true;
        boolean result = instance.addUtilizadorNaoRegistado(utilizador);
        assertEquals(expResult, result);
        result = instance.addUtilizadorNaoRegistado(utilizador);
        expResult = false;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of registarUtilizador method, of class RegistoUtilizadores.
     */
    @Test
    public void testRegistarUtilizador() {
        System.out.println("registarUtilizador");
        Utilizador utilizador = new Utilizador("Sara", "1140957", "xpto", "1140957@isep.ipp.pt", "organizador");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        boolean expResult = false;
        boolean result = instance.registarUtilizador(utilizador);
        assertEquals(expResult, result);
        instance.addUtilizadorNaoRegistado(utilizador);
        result = instance.registarUtilizador(utilizador);
        expResult = true;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getListaUtilizadoresNaoRegistados method, of class
     * RegistoUtilizadores.
     */
    @Test
    public void testGetListaUtilizadoresNaoRegistados() {
        System.out.println("getListaUtilizadoresNaoRegistados");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador ut = new Utilizador("Sara", "1140957", "xpto", "1140957@isep.ipp.pt", "organizador");
        List<Utilizador> expResult = new ArrayList<>();
        expResult.add(ut);
        instance.addUtilizadorNaoRegistado(ut);
        List<Utilizador> result = instance.getListaUtilizadoresNaoRegistados();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getListaUtilizadoresRegistados method, of class
     * RegistoUtilizadores.
     */
    @Test
    public void testGetListaUtilizadoresRegistados() {
        System.out.println("getListaUtilizadoresRegistados");
        RegistoUtilizadores instance = new RegistoUtilizadores();
        Utilizador ut = new Utilizador("Sara", "1140957", "xpto", "1140957@isep.ipp.pt", "organizador");
        ut.setRegistado();
        Utilizador ut2 = new Utilizador("Sara", "1140957", "xpto", "1140957@isep.ipp.pt", "organizador");
        List<Utilizador> expResult = new ArrayList<>();
        expResult.add(ut);
        instance.addUtilizadorNaoRegistado(ut2);
        instance.registarUtilizador(ut2);
        List<Utilizador> result = instance.getListaUtilizadoresRegistados();
        assertEquals(expResult, result);
        
    }
    
}
