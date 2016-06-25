/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.representante;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Retiravel;
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
public class RetirarCandidaturaControllerTest {

    public RetirarCandidaturaControllerTest() {
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
     * Test of getListaRetiraveis method, of class RetirarCandidaturaController.
     */
    @Test
    public void testGetListaRetiraveis() {
        System.out.println("getListaRetiraveis");
        CentroExposicoes ce = new CentroExposicoes();
        Exposicao exp = new Exposicao();
        Candidatura can = new Candidatura("nomeEmpresa", "moradaEmpresa", 911111111, 23, 5, new ArrayList<>());
        exp.addCandidatura(can);
        ce.getListaExposicoes().addExposicao(exp);
        RetirarCandidaturaController instance = new RetirarCandidaturaController(ce);
        List<Retiravel> expResult = new ArrayList<>();
        expResult.add(can);
        List<Retiravel> result = instance.getListaRetiraveis();
        assertEquals(expResult, result);

    }

    /**
     * Test of retirarCandidatura method, of class RetirarCandidaturaController.
     */
    @Test
    public void testRetirarCandidatura() {
        System.out.println("retirarCandidatura");
        Candidatura retiravel = new Candidatura();
        CentroExposicoes ce = new CentroExposicoes();
        RetirarCandidaturaController instance = new RetirarCandidaturaController(ce);
        boolean expResult = true;
        boolean result = instance.retirarCandidatura(retiravel);
        assertEquals(expResult, result);
        assertTrue(retiravel.isRetirada());

    }

}
