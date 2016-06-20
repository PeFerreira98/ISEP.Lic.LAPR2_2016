/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.gestor.DefinirStandCentroController;
import lapr.project.model.Stand;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.RegistoUtilizadores;
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
public class DefinirStandCentroControllerTest {

    public DefinirStandCentroControllerTest() {
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
     * Test of addStand method, of class DefinirStandCentroController.
     */
    @Test
    public void testAddStandByObject() {
        System.out.println("addStand");
        Stand stand = new Stand("descricao");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        DefinirStandCentroController instance = new DefinirStandCentroController(centro);
        boolean expResult = true;
        boolean result = instance.addStandByObject(stand);
        assertEquals(expResult, result);
    }

    /**
     * Test of addStand method, of class DefinirStandCentroController.
     */
    @Test
    public void testAddStandByDesc() {
        System.out.println("addStand");
        String stand = "Stand";
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        DefinirStandCentroController instance = new DefinirStandCentroController(centro);
        instance.addStand(stand);
    }

    /**
     * Test of getListaStands method, of class DefinirStandCentroController.
     */
    @Test
    public void testGetListaStands() {
        System.out.println("getListaStands");
        Stand stand = new Stand("stand");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        DefinirStandCentroController instance = new DefinirStandCentroController(centro);
        instance.addStandByObject(stand);
        List<Stand> expResult = new ArrayList<>();
        expResult.add(stand);
        List<Stand> result = instance.getListaStands();
        assertEquals(expResult, result);
    }

}
