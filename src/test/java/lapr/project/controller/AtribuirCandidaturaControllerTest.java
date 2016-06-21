/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.organizador.AtribuirCandidaturaController;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.mecanismos.MecanismoAtribuicao;
import lapr.project.model.mecanismos.atribuicao.MecanismoAtribuicao1;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Keyword;
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
 * @author TiagoSilvestre
 */
public class AtribuirCandidaturaControllerTest {

    public AtribuirCandidaturaControllerTest() {
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
     * AtribuirCandidaturaController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        Exposicao expo = new Exposicao("nome", "desc", new Data(2000, 10, 10), new Data(2000, 10, 10), new Data(2000, 10, 10), new Data(2000, 10, 10), "local");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        centro.getListaExposicoes().getListaExposicoes().add(expo);
        AtribuirCandidaturaController instance = new AtribuirCandidaturaController(centro);
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo);
        List<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaMecanismos method, of class
     * AtribuirCandidaturaController.
     */
    @Test
    public void testGetListaMecanismos() {
        System.out.println("getListaMecanismos");
        MecanismoAtribuicao mecanismo = null;
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        centro.getListaMecanismos().add(mecanismo);
        AtribuirCandidaturaController instance = new AtribuirCandidaturaController(centro);
        List<MecanismoAtribuicao> expResult = new ArrayList<>();
        expResult.add(mecanismo);
        List<MecanismoAtribuicao> result = instance.getListaMecanismos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaAtribuicoes method, of class
     * AtribuirCandidaturaController.
     */
    @Test
    public void testGetListaAtribuicoes() {
        System.out.println("getListaAtribuicoes");

        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email");
        FAE fae = new FAE(utilizador);
        Candidatura candidatura = new Candidatura("nome", "morada", 918000000, 10, 2, new ArrayList<>());
        Atribuicao atribuicao = new Atribuicao(fae, candidatura);
        Exposicao expo = new Exposicao("nome", "desc", new Data(2000, 10, 10), new Data(2000, 10, 10), new Data(2000, 10, 10), new Data(2000, 10, 10), "local");

        expo.getListaFAE().addFAE(fae);
        expo.addCandidatura(candidatura);
        expo.getListaAtribuicoes().addAtribuicao(atribuicao);

        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        centro.getListaExposicoes().addExposicao(expo);

        AtribuirCandidaturaController instance = new AtribuirCandidaturaController(centro);
        instance.setExposicao(expo);
        instance.setMecanismo(new MecanismoAtribuicao1());

        List<Atribuicao> expResult = new ArrayList<>();
        expResult.add(atribuicao);
        List<Atribuicao> result = instance.getListaAtribuicoes();

        System.out.println(expResult);
        System.out.println(result);

        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class AtribuirCandidaturaController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao exposicao = new Exposicao("nome", "desc", new Data(2000, 10, 10), new Data(2000, 10, 10), new Data(2000, 10, 10), new Data(2000, 10, 10), "local");
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        AtribuirCandidaturaController instance = new AtribuirCandidaturaController(centro);
        instance.setExposicao(exposicao);
    }

    /**
     * Test of setMecanismo method, of class AtribuirCandidaturaController.
     */
    @Test
    public void testSetMecanismo() {
        System.out.println("setMecanismo");
        MecanismoAtribuicao mecanismo = null;
        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        AtribuirCandidaturaController instance = new AtribuirCandidaturaController(centro);
        instance.setMecanismo(mecanismo);
    }

    /**
     * Test of registarAtribuicoes method, of class AtribuirCandidaturaController.
     */
    @Test
    public void testRegistarAtribuicoes() {
        System.out.println("registarAtribuicoes");
        Utilizador utilizador = new Utilizador("Exp", "username", "password", "email");
        FAE fae = new FAE(utilizador);
        Candidatura candidatura = new Candidatura("nome", "morada", 918000000, 10, 2, new ArrayList<>());
        Atribuicao atribuicao = new Atribuicao(fae, candidatura);
        Exposicao expo = new Exposicao("nome", "desc", new Data(2000, 10, 10), new Data(2000, 10, 10), new Data(2000, 10, 10), new Data(2000, 10, 10), "local");

        expo.getListaFAE().addFAE(fae);
        expo.addCandidatura(candidatura);
        expo.getListaAtribuicoes().addAtribuicao(atribuicao);

        RegistoUtilizadores rUtil = new RegistoUtilizadores();
        ListaExposicoes lstExpo = new ListaExposicoes();
        CentroExposicoes centro = new CentroExposicoes(rUtil, lstExpo);
        centro.getListaExposicoes().addExposicao(expo);

        AtribuirCandidaturaController instance = new AtribuirCandidaturaController(centro);
        instance.setExposicao(expo);
        instance.setMecanismo(new MecanismoAtribuicao1());
        
        instance.getListaAtribuicoes();
        boolean expResult = true;
        boolean result = instance.registarAtribuicoes();
        assertEquals(expResult, result);
    }

}
