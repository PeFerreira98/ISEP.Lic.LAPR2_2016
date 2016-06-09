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
 * @author Marcos
 */
public class AlterarPerfilUtilizadorControllerTest {

    public AlterarPerfilUtilizadorControllerTest() {
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
     * Test of setName method, of class AlterarPerfilUtilizadorController.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Pedro";
        Utilizador utilizador = new Utilizador("Marcos", "1140956", "xpto", "1140956@isep.ipp.pt", "organizador");
        RegistoUtilizadores rUers = new RegistoUtilizadores();
        AlterarPerfilUtilizadorController instance = new AlterarPerfilUtilizadorController(utilizador, rUers);
        rUers.addUtilizadorNaoRegistado(utilizador);
        instance.setName(name);
        String expResult = "Pedro";
        String result = utilizador.getNome();

        assertEquals(expResult, result);
    }

    /**
     * Test of confirmPassword method, of class
     * AlterarPerfilUtilizadorController.
     */
    @Test
    public void testConfirmPassword() {
        System.out.println("confirmPassword");
        String pw = "pw";
        Utilizador utilizador = new Utilizador("Marcos", "1140956", "pw", "1140956@isep.ipp.pt", "organizador");
        RegistoUtilizadores rUers = new RegistoUtilizadores();
        AlterarPerfilUtilizadorController instance = new AlterarPerfilUtilizadorController(utilizador, rUers);
        boolean expResult = true;
        boolean result = instance.confirmPassword(pw);
        assertEquals(expResult, result);

    }

    /**
     * Test of setPassword method, of class AlterarPerfilUtilizadorController.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String pw = "pw";
        Utilizador utilizador = new Utilizador("Marcos", "1140956", "xpto", "1140956@isep.ipp.pt", "organizador");
        RegistoUtilizadores rUers = new RegistoUtilizadores();
        AlterarPerfilUtilizadorController instance = new AlterarPerfilUtilizadorController(utilizador, rUers);
        instance.setPassword(pw);
        String expResult = "pw";
        String result = utilizador.getPassword();

        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class AlterarPerfilUtilizadorController.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "1140956@isep.ipp.pt";
       Utilizador utilizador = new Utilizador("Marcos", "1140953", "xpto", "1140956@isep.ipp.pt", "organizador");
        RegistoUtilizadores rUers = new RegistoUtilizadores();
        AlterarPerfilUtilizadorController instance = new AlterarPerfilUtilizadorController(utilizador, rUers);
        boolean expResult = true;
        boolean result = instance.setEmail(email);
        assertEquals(expResult, result);
       
    }

}
