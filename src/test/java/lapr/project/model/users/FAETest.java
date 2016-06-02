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

/**
 *
 * @author zero_
 */
public class FAETest {

    public FAETest() {
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
     * Test of setUtilizador method, of class FAE.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");

        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email", "tipo");
        FAE instance = new FAE();

        instance.setUtilizador(utilizador);

        assertEquals(instance.getUtilizador(), utilizador);
    }

    /**
     * Test of getUtilizador method, of class FAE.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");

        Utilizador expResult = new Utilizador("Exp", "username", "password", "email", "tipo");
        FAE instance = new FAE(expResult);

        Utilizador result = instance.getUtilizador();

        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class FAE.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email", "tipo");
        Object obj = new FAE(utilizador);
        FAE instance = new FAE(utilizador);

        boolean expResult = true;
        boolean result = instance.equals(obj);

        assertEquals(expResult, result);
    }

}
