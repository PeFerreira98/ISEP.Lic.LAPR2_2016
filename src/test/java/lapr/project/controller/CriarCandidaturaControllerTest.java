/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaFAE;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zero_
 */
public class CriarCandidaturaControllerTest {

    public CriarCandidaturaControllerTest() {
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
     * Test of createCandidatura method, of class CriarCandidaturaController.
     */
    @Test
    public void testCreateCandidatura() {
        System.out.println("createCandidatura");

        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");

        String nomeEmpresa = "nabaCorp";
        String moradaEmpresa = "rua do queijo";
        int telemovel = 917320606;
        double areaPretendida = 5666;
        int quantidadeConvites = 100;
        CriarCandidaturaController instance = new CriarCandidaturaController(exposicao);
        instance.novaCandidatura();
        boolean expResult = true;
        boolean result = instance.setDados(nomeEmpresa, moradaEmpresa, areaPretendida, telemovel, quantidadeConvites);

        assertEquals(expResult, result);
    }

    /**
     * Test of addProduto method, of class CriarCandidaturaController.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");

        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");

        String designacao = "produto1";
        CriarCandidaturaController instance = new CriarCandidaturaController(exposicao);

        boolean expResult = true;
        boolean result = instance.addProduto(designacao);

        assertEquals(expResult, result);
    }

    /**
     * Test of addDemonstracao method, of class CriarCandidaturaController.
     */
    @Test
    public void testAddDemonstracao() {
        System.out.println("addDemonstracao");

        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");

        Demonstracao demonstracao = new Demonstracao("demo1");
        CriarCandidaturaController instance = new CriarCandidaturaController(exposicao);

        boolean expResult = true;
        boolean result = instance.addDemonstracao(demonstracao);

        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDemonstracoesExposicao method, of class
     * CriarCandidaturaController.
     */
    @Test
    public void testGetListaDemonstracoesExposicao() {
        System.out.println("getListaDemonstracoesExposicao");

        Demonstracao demo1 = new Demonstracao("demo1");
        Demonstracao demo2 = new Demonstracao("demo2");
        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        exposicao.getListaDemonstracoes().addDemonstracao(demo1);
        exposicao.getListaDemonstracoes().addDemonstracao(demo2);

        CriarCandidaturaController instance = new CriarCandidaturaController(exposicao);

        List<Demonstracao> expResult = exposicao.getListaDemonstracoes().getListaDemonstracoes();
        List<Demonstracao> result = instance.getListaDemonstracoesExposicao();

        assertEquals(expResult, result);
    }

    /**
     * Test of addCandidaturaToExposicao method, of class
     * CriarCandidaturaController.
     */
    @Test
    public void testAddCandidaturaToExposicao() {
        System.out.println("addCandidaturaToExposicao");

        String nomeEmpresa = "nabaCorp";
        String moradaEmpresa = "rua do queijo";
        int telemovel = 917320606;
        double areaPretendida = 5666;
        int quantidadeConvites = 100;
        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        CriarCandidaturaController instance = new CriarCandidaturaController(exposicao);
        instance.novaCandidatura();
        instance.setDados(nomeEmpresa, moradaEmpresa, areaPretendida, telemovel, quantidadeConvites);

        boolean expResult = true;
        boolean result = instance.addCandidaturaToExposicao();

        assertEquals(expResult, result);
    }

}
