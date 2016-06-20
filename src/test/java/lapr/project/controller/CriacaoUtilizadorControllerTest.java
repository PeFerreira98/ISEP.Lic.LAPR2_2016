/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.lists.RegistoUtilizadores;
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
public class CriacaoUtilizadorControllerTest {

    public CriacaoUtilizadorControllerTest() {
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
     * Test of addUtilizadorNaoRegistado method, of class
     * CriacaoUtilizadorController.
     */
    @Test
    public void testAddUtilizadorNaoRegistado() {
        System.out.println("addUtilizadorNaoRegistado");
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        CriacaoUtilizadorController instance = new CriacaoUtilizadorController(rUtil);
        boolean expResult = true;
        boolean result = instance.addUtilizadorNaoRegistado(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUtilizadorByUsername method, of class
     * CriacaoUtilizadorController.
     */
    @Test
    public void testCheckUtilizadorByUsername() {
        System.out.println("checkUtilizadorByUsername");
        String username = "username";
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        CriacaoUtilizadorController instance = new CriacaoUtilizadorController(rUtil);
        instance.addUtilizadorNaoRegistado(utilizador);
        boolean expResult = true;
        boolean result = instance.checkUtilizadorByUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUtilizadorByUsername method, of class
     * CriacaoUtilizadorController.
     */
    @Test
    public void testCheckUtilizadorByUsernameFail() {
        System.out.println("checkUtilizadorByUsername");
        String username = "";
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        CriacaoUtilizadorController instance = new CriacaoUtilizadorController(rUtil);
        instance.addUtilizadorNaoRegistado(utilizador);
        boolean expResult = false;
        boolean result = instance.checkUtilizadorByUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUtilizadorByEmail method, of class
     * CriacaoUtilizadorController.
     */
    @Test
    public void testCheckUtilizadorByEmail() {
        System.out.println("checkUtilizadorByEmail");
        String email = "email";
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        CriacaoUtilizadorController instance = new CriacaoUtilizadorController(rUtil);
        instance.addUtilizadorNaoRegistado(utilizador);
        boolean expResult = true;
        boolean result = instance.checkUtilizadorByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUtilizadorByEmail method, of class
     * CriacaoUtilizadorController.
     */
    @Test
    public void testCheckUtilizadorByEmailFail() {
        System.out.println("checkUtilizadorByEmail");
        String email = "";
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        CriacaoUtilizadorController instance = new CriacaoUtilizadorController(rUtil);
        instance.addUtilizadorNaoRegistado(utilizador);
        boolean expResult = false;
        boolean result = instance.checkUtilizadorByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaEmailPattern method, of class CriacaoUtilizadorController.
     */
    @Test
    public void testValidaEmailPattern() {
        System.out.println("validaEmailPattern");
        String email = "1140948@isep.ipp.pt";
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "1140948@isep.ipp.pt");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        CriacaoUtilizadorController instance = new CriacaoUtilizadorController(rUtil);
        instance.addUtilizadorNaoRegistado(utilizador);
        boolean expResult = true;
        boolean result = instance.validaEmailPattern(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaEmailPattern method, of class CriacaoUtilizadorController.
     */
    @Test
    public void testValidaEmailPatternFail() {
        System.out.println("validaEmailPattern");
        String email = "email";
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        CriacaoUtilizadorController instance = new CriacaoUtilizadorController(rUtil);
        instance.addUtilizadorNaoRegistado(utilizador);
        boolean expResult = false;
        boolean result = instance.validaEmailPattern(email);
        assertEquals(expResult, result);
    }

}
