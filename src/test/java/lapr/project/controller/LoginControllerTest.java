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
 * @author hugos
 */
public class LoginControllerTest {

    public LoginControllerTest() {
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
     * Test of getUtilizador method, of class LoginController.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        String username = "1140956";
        Utilizador utilizador = new Utilizador("Marcos", "1140956", "xpto", "1140956@isep.ipp.pt");
        RegistoUtilizadores rUers = new RegistoUtilizadores();
        rUers.addUtilizadorNaoRegistado(utilizador);
        LoginController instance = new LoginController(rUers);
        Utilizador expResult = new Utilizador("Marcos", "1140956", "xpto", "1140956@isep.ipp.pt");;
        Utilizador result = instance.getUtilizador(username);
        assertEquals(expResult, result);

    }

}
