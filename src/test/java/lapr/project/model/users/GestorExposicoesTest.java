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
public class GestorExposicoesTest {

    public GestorExposicoesTest() {
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
     * Test of getUtilizador method, of class GestorExposicoes.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        GestorExposicoes instance = new GestorExposicoes(ut);
        Utilizador expResult = new Utilizador("nome", "username", "password", "email");
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class GestorExposicoes.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        GestorExposicoes instance = new GestorExposicoes(ut);
        GestorExposicoes ge = new GestorExposicoes(ut);
        int expResult = ge.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class GestorExposicoes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Object();
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        GestorExposicoes instance = new GestorExposicoes(ut);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        GestorExposicoes ge = new GestorExposicoes(ut);
        expResult = true;
        result = instance.equals(ge);
        assertEquals(expResult, result);

    }

}
