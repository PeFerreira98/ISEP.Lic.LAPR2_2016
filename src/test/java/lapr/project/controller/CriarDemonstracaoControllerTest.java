/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaRecursos;
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
public class CriarDemonstracaoControllerTest {

    public CriarDemonstracaoControllerTest() {
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
     * Test of criarDemo method, of class CriarDemonstracaoController.
     */
    @Test
    public void testCriarDemo() {
        System.out.println("criarDemo");
        String cod = "codigo";
        String desc = "descricao";
        ListaRecursos r = new ListaRecursos();
        Exposicao expo = new Exposicao();
        CriarDemonstracaoController instance = new CriarDemonstracaoController(expo);
        instance.criarDemo(desc, cod, r);
        Demonstracao expResult = new Demonstracao(cod, desc, r);
        Demonstracao result = expo.getListaDemonstracoes().getListaDemonstracoes().get(0);
        assertEquals(expResult, result);

    }

}
