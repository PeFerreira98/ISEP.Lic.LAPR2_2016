/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.representante;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Keyword;
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
public class RegistarCandidaturaDemoControllerTest {

    public RegistarCandidaturaDemoControllerTest() {
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
     * RegistarCandidaturaDemoController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        CentroExposicoes ce = new CentroExposicoes();
        Exposicao exp = new Exposicao();
        RegistarCandidaturaDemoController instance = new RegistarCandidaturaDemoController(ce);
        ce.getListaExposicoes().addExposicao(exp);
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(exp);
        List<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaDemonstracoes method, of class
     * RegistarCandidaturaDemoController.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        CentroExposicoes centro = new CentroExposicoes();
        Demonstracao demo = new Demonstracao();
        Exposicao expo = new Exposicao();
        expo.getListaDemonstracoes().addDemonstracao(demo);
        RegistarCandidaturaDemoController instance = new RegistarCandidaturaDemoController(centro);
        instance.setExposicao(expo);
        centro.getListaExposicoes().addExposicao(expo);
        List<Demonstracao> expResult = new ArrayList<>();
        expResult.add(demo);
        List<Demonstracao> result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of registarCandidatura method, of class
     * RegistarCandidaturaDemoController.
     */
    @Test
    public void testRegistarCandidatura() {
        System.out.println("registarCandidatura");
        CentroExposicoes ce = new CentroExposicoes();
        RegistarCandidaturaDemoController instance = new RegistarCandidaturaDemoController(ce);
        instance.setDemonstracao(new Demonstracao());
        instance.novaCandidatura();
        instance.setDados("nome", "morada", 3, 911111111, 3);
        boolean expResult = true;
        boolean result = instance.registarCandidatura();
        assertEquals(expResult, result);
        expResult = false;
        result = instance.registarCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of addKeyword method, of class RegistarCandidaturaDemoController.
     */
    @Test
    public void testAddKeyword() {
        System.out.println("addKeyword");
        String keyword = "Valor";
        CentroExposicoes ce = new CentroExposicoes();
        RegistarCandidaturaDemoController instance = new RegistarCandidaturaDemoController(ce);
        instance.novaCandidatura();
        Demonstracao demo = new Demonstracao();
        instance.setDemonstracao(demo);
        instance.setDados("nome", "morada", 2, 911111111, 9);
        instance.addKeyword(keyword);
        instance.registarCandidatura();
        List<Keyword> expResult = new ArrayList<>();
        expResult.add(new Keyword(keyword));
        List<Keyword> result = demo.getListaCandidaturas().getListaCandidaturas().get(0).getKeywordList();
        assertEquals(expResult, result);

    }

    /**
     * Test of addProduto method, of class RegistarCandidaturaDemoController.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        String designacao = "Descricao";
        CentroExposicoes ce = new CentroExposicoes();
        RegistarCandidaturaDemoController instance = new RegistarCandidaturaDemoController(ce);
        instance.novaCandidatura();
        boolean expResult = true;
        boolean result = instance.addProduto(designacao);
        assertEquals(expResult, result);
        expResult = false;
        result = instance.addProduto(designacao);
        assertEquals(expResult, result);

    }

    /**
     * Test of setDados method, of class RegistarCandidaturaDemoController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String nomeEmpresa = "nomeEmpresa";
        String moradaEmpresa = "moradaEmpresa";
        double areaPretendida = 4.0;
        int telemovel = 915968742;
        int qtdConvites = 8;
        CentroExposicoes ce = new CentroExposicoes();
        RegistarCandidaturaDemoController instance = new RegistarCandidaturaDemoController(ce);
        instance.novaCandidatura();
        boolean expResult = true;
        boolean result = instance.setDados(nomeEmpresa, moradaEmpresa, areaPretendida, telemovel, qtdConvites);
        assertEquals(expResult, result);
        Demonstracao demo = new Demonstracao();
        Candidatura can = new Candidatura(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, qtdConvites, new ArrayList<>());
        instance.setDemonstracao(demo);
        instance.registarCandidatura();
        Candidatura c = demo.getListaCandidaturas().getListaCandidaturas().get(0);
        assertEquals(can, c);

    }

}
