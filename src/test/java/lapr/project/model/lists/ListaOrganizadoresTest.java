/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.users.Organizador;
import lapr.project.model.users.Utilizador;
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
public class ListaOrganizadoresTest {
    
    public ListaOrganizadoresTest() {
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
     * Test of getLstOrganizadores method, of class ListaOrganizadores.
     */
    @Test
    public void testGetLstOrganizadores() {
        System.out.println("getLstOrganizadores");
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email");
        Organizador organizador = new Organizador(utilizador);
        
        ListaOrganizadores instance = new ListaOrganizadores();
        List<Organizador> instance2 = new ArrayList<Organizador>();
        
        instance.addOrganizador(utilizador);
        instance2.add(organizador);
        
        List<Organizador> expResult = instance2;
        List<Organizador> result = instance.getLstOrganizadores();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of addOrganizador method, of class ListaOrganizadores.
     */
    @Test
    public void testAddOrganizador() {
        System.out.println("addOrganizador");
        Utilizador u = new Utilizador("user", "user", "pw", "email");
        ListaOrganizadores instance = new ListaOrganizadores();
        instance.addOrganizador(u);
    }

    /**
     * Test of validaOrganizador method, of class ListaOrganizadores.
     */
    @Test
    public void testValidaOrganizador() {
        System.out.println("validaOrganizador");
        Utilizador u = new Utilizador("user", "user", "pw", "email");
        Organizador organizador = new Organizador(u);
        ListaOrganizadores instance = new ListaOrganizadores();
        boolean expResult = true;
        boolean result = instance.validaOrganizador(organizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of valida method, of class ListaOrganizadores.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Utilizador u = new Utilizador("user", "user", "pw", "email");
        ListaOrganizadores instance = new ListaOrganizadores();
        instance.addOrganizador(u);
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }
    
}
