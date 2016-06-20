/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.gestor.DefinirStandCentroController;
import lapr.project.controller.organizador.DefinirStandCandidaturaController;
import lapr.project.model.Stand;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.submissions.Candidatura;
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
public class DefinirStandCandidaturaControllerTest {
    
    public DefinirStandCandidaturaControllerTest() {
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
     * Test of getStands method, of class DefinirStandCandidaturaController.
     */
    @Test
    public void testGetStands() {
        System.out.println("getStands");
        Stand stand = new Stand("stand");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        Candidatura candidatura = new Candidatura("nome", "morada", 918000000, 10, 2, new ArrayList<>());
        DefinirStandCandidaturaController instance = new DefinirStandCandidaturaController(centro, candidatura);
        instance.getStands().add(stand);
        List<Stand> expResult = new ArrayList<>();
        expResult.add(stand);
        List<Stand> result = instance.getStands();
        assertEquals(expResult, result);
    }

    /**
     * Test of atribuirStand method, of class DefinirStandCandidaturaController.
     */
    @Test
    public void testAtribuirStand() {
        System.out.println("atribuirStand");
        Stand s = new Stand("desc1");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        Candidatura candidatura = new Candidatura("nome", "morada", 918000000, 10, 2, new ArrayList<>());
        DefinirStandCandidaturaController instance = new DefinirStandCandidaturaController(centro, candidatura);
        instance.atribuirStand(s);
    }
    
}
