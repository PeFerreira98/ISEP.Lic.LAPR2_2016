/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

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
public class OrganizadorTest {

    public OrganizadorTest() {
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
     * Test of getUtilizador method, of class Organizador.
     */
    @Test
    public void testGetSetUtilizador() {
        System.out.println("getUtilizador");
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        Organizador instance = new Organizador();
        instance.setUtilizador(ut);
        Utilizador expResult = new Utilizador("nome", "username", "password", "email");
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class Organizador.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Organizador instance = new Organizador();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Organizador.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        Organizador instance = new Organizador(ut);
        Organizador org = new Organizador(ut);
        int expResult = org.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Organizador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Object();
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        Organizador instance = new Organizador(ut);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        Organizador org = new Organizador(ut);
        expResult = true;
        result = instance.equals(org);
        assertEquals(expResult, result);

    }

}
