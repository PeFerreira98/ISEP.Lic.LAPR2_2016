/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.fae;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Conflito;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.exhibitions.TipoConflito;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;
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
 * @author Sara Silva
 */
public class ActualizarConflitosControllerTest {

    public ActualizarConflitosControllerTest() {
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
     * Test of getListaExposicoes method, of class
     * ActualizarConflitosController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        CentroExposicoes centroExposicoes = new CentroExposicoes();
        FAE fae = new FAE();
        Exposicao exp = new Exposicao("nomeExposicao", "descricaoExposicao", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "local");
        exp.getRegistoConflitos().registarConflito(new FAE(), new Candidatura());
        centroExposicoes.getListaExposicoes().addExposicao(exp);
        ActualizarConflitosController instance = new ActualizarConflitosController(centroExposicoes, fae);
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(exp);
        List<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaDemonstracoes method, of class
     * ActualizarConflitosController.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        CentroExposicoes centroExposicoes = new CentroExposicoes();
        FAE fae = new FAE();
        Demonstracao demo = new Demonstracao("descricao");
        Exposicao exp = new Exposicao("nomeExposicao", "descricaoExposicao", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "local");
        demo.getRegistoConflitos().registarConflito(new FAE(), new Candidatura());
        exp.getListaDemonstracoes().addDemonstracao(demo);
        centroExposicoes.getListaExposicoes().addExposicao(exp);
        ActualizarConflitosController instance = new ActualizarConflitosController(centroExposicoes, fae);
        List<Demonstracao> expResult = new ArrayList<>();
        expResult.add(demo);
        List<Demonstracao> result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaCandidaturas method, of class
     * ActualizarConflitosController.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        CentroExposicoes centroExposicoes = new CentroExposicoes();
        FAE fae = new FAE();
        Exposicao exp = new Exposicao();
        Candidatura can = new Candidatura("nomeEmpresa", "moradaEmpresa", 911111111, 21, 5, new ArrayList<>());
        exp.getListaCandidaturas().registaCandidatura(can);
        ActualizarConflitosController instance = new ActualizarConflitosController(centroExposicoes, fae);
        List<Candidatura> expResult = new ArrayList<>();
        expResult.add(can);
        instance.selectExposicao(exp);
        List<Candidatura> result = instance.getListaCandidaturas();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFAELabel method, of class ActualizarConflitosController.
     */
    @Test
    public void testGetFAELabel() {
        System.out.println("getFAELabel");
        CentroExposicoes centroExposicoes = new CentroExposicoes();
        FAE fae = new FAE();
        Utilizador ut = new Utilizador("nome", "username", "password", "email");
        fae.setUtilizador(ut);
        ActualizarConflitosController instance = new ActualizarConflitosController(centroExposicoes, fae);
        String expResult = "username";
        String result = instance.getFAELabel();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCandidaturaLabel method, of class
     * ActualizarConflitosController.
     */
    @Test
    public void testGetCandidaturaLabel() {
        System.out.println("getCandidaturaLabel");
        CentroExposicoes centroExposicoes = new CentroExposicoes();
        FAE fae = new FAE();
        Candidatura can = new Candidatura("nomeEmpresa", "moradaEmpresa", 911111111, 21, 5, new ArrayList<>());
        ActualizarConflitosController instance = new ActualizarConflitosController(centroExposicoes, fae);
        String expResult = "nomeEmpresa";
        instance.selectExposicao(new Exposicao());
        instance.selectCandidatura(can);
        String result = instance.getCandidaturaLabel();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaConflitos method, of class ActualizarConflitosController.
     */
    @Test
    public void testGetListaConflitos() {
        System.out.println("getListaConflitos");
        CentroExposicoes centroExposicoes = new CentroExposicoes();
        FAE fae = new FAE();
        Candidatura can = new Candidatura();
        Conflito c = new Conflito(fae, can);
        Exposicao exp = new Exposicao();
        exp.getRegistoConflitos().registarConflito(fae, can);
        ActualizarConflitosController instance = new ActualizarConflitosController(centroExposicoes, fae);
        List<Conflito> expResult = new ArrayList<>();
        expResult.add(c);
        instance.selectExposicao(exp);
        instance.selectCandidatura(can);
        List<Conflito> result = instance.getListaConflitos();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaTiposConflito method, of class
     * ActualizarConflitosController.
     */
    @Test
    public void testGetListaTiposConflito() {
        System.out.println("getListaTiposConflito");
        CentroExposicoes centroExposicoes = new CentroExposicoes();
        FAE fae = new FAE();
        TipoConflito tp = new TipoConflito();
        centroExposicoes.getListaTipoConflito().addTipoConflito(tp);
        ActualizarConflitosController instance = new ActualizarConflitosController(centroExposicoes, fae);
        List<TipoConflito> expResult = new ArrayList<>();
        expResult.add(tp);
        List<TipoConflito> result = instance.getListaTiposConflito();
        assertEquals(expResult, result);

    }

    /**
     * Test of eliminarConflito method, of class ActualizarConflitosController.
     */
    @Test
    public void testEliminarConflito() {
        System.out.println("eliminarConflito");
        FAE fae = new FAE();
        Candidatura can = new Candidatura();
        CentroExposicoes ce = new CentroExposicoes();
        TipoConflito tc = new TipoConflito("descricao");
        Conflito conflito = new Conflito(fae, can, tc);
        ActualizarConflitosController instance = new ActualizarConflitosController(ce, fae);
        instance.selectExposicao(new Exposicao());
        instance.selectCandidatura(can);
        boolean expResult = false;
        boolean result = instance.eliminarConflito(conflito);
        assertEquals(expResult, result);
        instance.adicionaConflito(tc);
        expResult = true;
        result = instance.eliminarConflito(conflito);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionaConflito method, of class ActualizarConflitosController.
     */
    @Test
    public void testAdicionaConflito() {
        System.out.println("adicionaConflito");
        TipoConflito tipoConflito = new TipoConflito("descricao");
        FAE fae = new FAE();
        Candidatura can = new Candidatura();
        CentroExposicoes ce = new CentroExposicoes();
        ActualizarConflitosController instance = new ActualizarConflitosController(ce, fae);
        instance.selectExposicao(new Exposicao());
        instance.selectCandidatura(can);
        boolean expResult = true;
        boolean result = instance.adicionaConflito(tipoConflito);
        assertEquals(expResult, result);

    }

}
