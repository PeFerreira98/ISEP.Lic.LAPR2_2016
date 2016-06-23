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
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Keyword;
import lapr.project.model.submissions.Produto;
import lapr.project.model.users.Representante;
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
public class AlterarCandidaturaControllerTest {

    public AlterarCandidaturaControllerTest() {
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
     * Test of getListaExposicoes method, of class AlterarCandidaturaController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        CentroExposicoes centro = new CentroExposicoes();
        Exposicao exp = new Exposicao();
        AlterarCandidaturaController instance = new AlterarCandidaturaController(centro);
        centro.getListaExposicoes().addExposicao(exp);
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(exp);
        List<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDemonstracoes method, of class
     * AlterarCandidaturaController.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        CentroExposicoes centro = new CentroExposicoes();
        Demonstracao demo = new Demonstracao();
        Exposicao expo = new Exposicao();
        expo.getListaDemonstracoes().addDemonstracao(demo);
        AlterarCandidaturaController instance = new AlterarCandidaturaController(centro);
        instance.setExposicao(expo);
        centro.getListaExposicoes().addExposicao(expo);
        ListaDemonstracoes expResult = new ListaDemonstracoes();
        expResult.addDemonstracao(demo);
        ListaDemonstracoes result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCandidatura method, of class AlterarCandidaturaController.
     */
    @Test
    public void testGetCandidatura() {
        System.out.println("getCandidatura");
        CentroExposicoes ce = new CentroExposicoes();
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce);
        instance.setCandidatura(new Candidatura());
        Candidatura expResult = new Candidatura();
        Candidatura result = instance.getCandidatura();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaCandidaturas method, of class
     * AlterarCandidaturaController.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        CentroExposicoes ce = new CentroExposicoes();
        Utilizador utilizador = new Utilizador();
        Representante rep = new Representante(utilizador);
        Candidatura can = new Candidatura("nome", "morada", 911111111, 2, 2, new ArrayList<>());
        can.setRep(rep);
        Exposicao exp = new Exposicao();
        Demonstracao demo = new Demonstracao();
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce);
        exp.addCandidatura(can);
        demo.addCandidatura(can);
        instance.setExposicao(exp);
        instance.setUtilizador(utilizador);
        List<Candidatura> expResult = new ArrayList<>();
        expResult.add(can);
        List<Candidatura> result = instance.getListaCandidaturas();
        assertEquals(expResult, result);
        instance.setDemonstracao(demo);
        result = instance.getListaCandidaturas();
        assertEquals(expResult, result);

    }

    /**
     * Test of addProduto method, of class AlterarCandidaturaController.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        String produto = "Descricao";
        CentroExposicoes ce = new CentroExposicoes();
        Candidatura can = new Candidatura();
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce);
        instance.setCandidatura(can);
        instance.addProduto(produto);
        List<Produto> expResult = new ArrayList<>();
        expResult.add(new Produto(produto));
        List<Produto> result = can.getListaProdutos().getListaProdutos();
        assertEquals(expResult, result);
    }

    /**
     * Test of addKeyword method, of class AlterarCandidaturaController.
     */
    @Test
    public void testAddKeyword() {
        System.out.println("addKeyword");
        String keyword = "Valor";
        CentroExposicoes ce = new CentroExposicoes();
        Candidatura can = new Candidatura();
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce);
        instance.setCandidatura(can);
        instance.addKeyword(keyword);
        List<Keyword> expResult = new ArrayList<>();
        expResult.add(new Keyword(keyword));
        List<Keyword> result = can.getKeywordList();
        assertEquals(expResult, result);

    }

    /**
     * Test of addDemonstracao method, of class AlterarCandidaturaController.
     */
    @Test
    public void testAddDemonstracao() {
        System.out.println("addDemonstracao");
        CentroExposicoes ce = new CentroExposicoes();
        Exposicao exp = new Exposicao();
        Candidatura can = new Candidatura();
        Demonstracao demonstracao = new Demonstracao("Codigo", "Designacao");
        exp.getListaDemonstracoes().addDemonstracao(demonstracao);
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce);
        instance.setCandidatura(can);
        instance.setExposicao(exp);
        instance.addDemonstracao(demonstracao);
        ListaDemonstracoes expResult = new ListaDemonstracoes();
        expResult.addDemonstracao(demonstracao);
        ListaDemonstracoes result = can.getListaDemonstracoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of registarCandidaturas method, of class
     * AlterarCandidaturaController.
     */
    @Test
    public void testRegistarCandidaturas() {
        System.out.println("registarCandidaturas");
        CentroExposicoes ce = new CentroExposicoes();
        Candidatura can = new Candidatura("nome", "morada", 911111111, 2, 2, new ArrayList<>());
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce);
        instance.setExposicao(new Exposicao());
        instance.setCandidatura(can);
        boolean expResult = true;
        boolean result = instance.registarCandidaturas();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDados method, of class AlterarCandidaturaController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String nomeEmpresa = "nomeEmpresa";
        String moradaEmpresa = "moradaEmpresa";
        double areaPretendida = 0.0;
        int telemovel = 0;
        int qtdConvites = 0;
        CentroExposicoes ce = new CentroExposicoes();
        Candidatura can = new Candidatura();
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce);
        instance.setCandidatura(can);
        instance.setDados(nomeEmpresa, moradaEmpresa, areaPretendida, telemovel, qtdConvites);
        Candidatura c1 = new Candidatura(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, qtdConvites, new ArrayList<>());
        assertEquals(c1, can);
    }

    /**
     * Test of getExposicao method, of class AlterarCandidaturaController.
     */
    @Test
    public void testGetExposicao() {
        System.out.println("getExposicao");
        CentroExposicoes ce = new CentroExposicoes();
        AlterarCandidaturaController instance = new AlterarCandidaturaController(ce);
        Exposicao expResult = new Exposicao();
        instance.setExposicao(new Exposicao());
        Exposicao result = instance.getExposicao();
        assertEquals(expResult, result);

    }

}
