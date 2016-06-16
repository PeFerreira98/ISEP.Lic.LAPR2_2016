/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.controller.organizador.DefinirFAEController;
import java.util.List;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Data;
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
public class DefinirFAEControllerTest {

    public DefinirFAEControllerTest() {
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
     * Test of addUtilizadorListaFAE method, of class DefinirFAEController.
     */
    @Test
    public void testAddUtilizadorListaFAE() {
        System.out.println("addUtilizadorListaFAE");

        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email", "FAE");

        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();
        registoUtilizadores.addUtilizadorNaoRegistado(utilizador);
        registoUtilizadores.registarUtilizador(utilizador);

        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");

        DefinirFAEController instance = new DefinirFAEController(registoUtilizadores, exposicao);
        boolean expResult = true;
        boolean result = instance.addUtilizadorListaFAE(utilizador);

        assertEquals(expResult, result);
    }

    /**
     * Test of getListaUtilizadoresRegistados method, of class
     * DefinirFAEController.
     */
    @Test
    public void testGetListaUtilizadoresRegistados() {
        System.out.println("getListaUtilizadoresRegistados");

        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email", "FAE");

        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();
        registoUtilizadores.addUtilizadorNaoRegistado(utilizador);
        registoUtilizadores.registarUtilizador(utilizador);

        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");

        DefinirFAEController instance = new DefinirFAEController(registoUtilizadores, exposicao);

        List<Utilizador> expResult = registoUtilizadores.getListaUtilizadoresRegistados();
        List<Utilizador> result = instance.getListaUtilizadoresRegistados();

        assertEquals(expResult, result);
    }

}
