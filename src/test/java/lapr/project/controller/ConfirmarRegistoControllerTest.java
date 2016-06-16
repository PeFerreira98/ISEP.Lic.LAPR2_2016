/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.controller.gestor.ConfirmarRegistoController;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.users.Utilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Silva
 */
public class ConfirmarRegistoControllerTest {

    public ConfirmarRegistoControllerTest() {
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
     * Test of getListUtNaoConfirmado method, of class
     * ConfirmarRegistoController.
     */
    @Test
    public void testGetListUtNaoConfirmado() {
        System.out.println("getListUtNaoConfirmado");
        CentroExposicoes ce = new CentroExposicoes();
        ConfirmarRegistoController instance = new ConfirmarRegistoController(ce);
        Utilizador u1 = new Utilizador("Sara", "1140957", "xpto", "1140957@isep.ipp.pt", "organizador");
        List<Utilizador> expResult = new ArrayList<>();
        expResult.add(u1);
        ce.getRegistoUtilizadores().addUtilizadorNaoRegistado(u1);

        List<Utilizador> result = instance.getListUtNaoConfirmado();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUtilizador method, of class ConfirmarRegistoController.
     */
    @Test
    public void testSetUtilizadorAndToString() {
        System.out.println("setUtilizadorAndToString");
        Utilizador utilizador = new Utilizador("Sara", "1140957", "xpto", "1140957@isep.ipp.pt", "organizador");
        ConfirmarRegistoController instance = new ConfirmarRegistoController(new CentroExposicoes());
        instance.setUtilizador(utilizador);
        String expResult = "\nUtilizador{" + "nome=" + "Sara" + ", username=" + "1140957" + ", password=" + "xpto" + ", email=" + "1140957@isep.ipp.pt" + ", tipoUtilizador=" + "organizador" + ", estado=" + "PENDING" + "}";
        String result = instance.utilizadorToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of confirmaUtilizador method, of class ConfirmarRegistoController.
     */
    @Test
    public void testConfirmaUtilizador() {
        System.out.println("confirmaUtilizador");
        CentroExposicoes ce = new CentroExposicoes();
        ConfirmarRegistoController instance = new ConfirmarRegistoController(ce);
        Utilizador utilizador = new Utilizador("Sara", "1140957", "xpto", "1140957@isep.ipp.pt", "organizador");
        ce.getRegistoUtilizadores().addUtilizadorNaoRegistado(utilizador);
        instance.setUtilizador(utilizador);
        instance.confirmaUtilizador();
        List<Utilizador> expResult = new ArrayList<>();
        expResult.add(utilizador);

        List<Utilizador> result = ce.getRegistoUtilizadores().getListaUtilizadoresRegistados();
        assertEquals(expResult, result);

    }

}
