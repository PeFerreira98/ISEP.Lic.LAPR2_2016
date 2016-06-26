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
public class RepresentanteTest {

    public RepresentanteTest() {
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
     * Test of getNomeEmpresa method, of class Representante.
     */
    @Test
    public void testGetNomeEmpresa() {
        System.out.println("getNomeEmpresa");
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        Representante instance = new Representante(ut, "nomeEmpresa");
        String expResult = "nomeEmpresa";
        String result = instance.getNomeEmpresa();
        assertEquals(expResult, result);

    }

    /**
     * Test of getUtilizador method, of class Representante.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        Representante instance = new Representante(ut);
        Utilizador expResult = new Utilizador("nome", "username", "password", "email");
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Representante.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        Representante instance = new Representante(ut);
        Representante r = new Representante(ut);
        int expResult = r.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Representante.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Object();
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        Representante instance = new Representante(ut);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        Representante r = new Representante(ut);
        expResult = true;
        result = instance.equals(r);
        assertEquals(expResult, result);

    }

}
