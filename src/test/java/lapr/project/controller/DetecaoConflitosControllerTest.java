/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

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
public class DetecaoConflitosControllerTest {
    
    public DetecaoConflitosControllerTest() {
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
     * Test of processoDeteccaoConflito method, of class DetecaoConflitosController.
     */
    @Test
    public void testProcessoDeteccaoConflito() {
        System.out.println("processoDeteccaoConflito");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        DetecaoConflitosController instance = new DetecaoConflitosController(centro);
        instance.processoDeteccaoConflito();
    }
    
}
