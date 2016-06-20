/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

import lapr.project.model.states.EstadoUtilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class UtilizadorTest {

    public UtilizadorTest() {
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
     * Test of validateUsername method, of class Utilizador.
     */
    @Test
    public void testValidateUsername() {
        System.out.println("validateUsername");

        String username = "username";
        Utilizador instance = new Utilizador("Exp", "username", "password", "email");

        boolean expResult = true;
        boolean result = instance.validateUsername(username);

        assertEquals(expResult, result);
    }

    /**
     * Test of validatePassword method, of class Utilizador.
     */
    @Test
    public void testValidatePassword() {
        System.out.println("validatePassword");

        String password = "password";
        Utilizador instance = new Utilizador("Exp", "username", "password", "email");

        boolean expResult = true;
        boolean result = instance.validatePassword(password);

        assertEquals(expResult, result);
    }

    /**
     * Test of validateEmail method, of class Utilizador.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");

        String email = "email";
        Utilizador instance = new Utilizador("Exp", "username", "password", "email");

        boolean expResult = true;
        boolean result = instance.validateEmail(email);

        assertEquals(expResult, result);
    }

    /**
     * Test of isRegistado method, of class Utilizador.
     */
    @Test
    public void testIsRegistado() {
        System.out.println("isRegistado");

        Utilizador instance = new Utilizador("Exp", "username", "password", "email");
        instance.setRegistado();

        boolean expResult = true;
        boolean result = instance.isRegistado();

        assertEquals(expResult, result);
    }

    /**
     * Test of setRegistado method, of class Utilizador.
     */
    @Test
    public void testSetRegistado() {
        System.out.println("setRegistado");

        Utilizador instance = new Utilizador("Exp", "username", "password", "email");

        instance.setRegistado();

        boolean expResult = true;
        boolean result = instance.isRegistado();

        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Utilizador.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Object obj = new Utilizador("Exp", "username", "password", "email");
        Utilizador instance = new Utilizador("Exp", "username", "password", "email");

        boolean expResult = true;
        boolean result = instance.equals(obj);

        assertEquals(expResult, result);
    }

    /**
     * Test of isPending method, of class Utilizador.
     */
    @Test
    public void testIsPendingTrue() {
        System.out.println("isPending");
        Utilizador instance = new Utilizador("Exp", "username", "password", "email");
        boolean expResult = true;
        boolean result = instance.isPending();
        assertEquals(expResult, result);
    }

    /**
     * Test of isPending method, of class Utilizador.
     */
    @Test
    public void testIsPendingFalse() {
        System.out.println("isPending");
        Utilizador instance = new Utilizador("Exp", "username", "password", "email");
        instance.setRegistado();
        boolean expResult = false;
        boolean result = instance.isPending();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Utilizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Utilizador instance = new Utilizador("Exp", "username", "password", "email");
        String expResult = "\nUtilizador{nome=Exp, username=username, email=email, estado=PENDING}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
