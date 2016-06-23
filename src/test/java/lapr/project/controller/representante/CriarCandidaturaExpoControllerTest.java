/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.representante;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
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
 * @author Marcos
 */
public class CriarCandidaturaExpoControllerTest {

    public CriarCandidaturaExpoControllerTest() {
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
     * Test of getCandidatura method, of class CriarCandidaturaExpoController.
     */
    @Test
    public void testGetCandidatura() {
        System.out.println("getCandidatura");
        Exposicao exposicao = new Exposicao();
        CriarCandidaturaExpoController instance = new CriarCandidaturaExpoController(exposicao);
        instance.novaCandidatura();
        instance.setDados("EmpresaM", "Rua", 20, 916263189, 100);
        Candidatura expResult = new Candidatura("EmpresaM", "Rua", 916263189, 20, 100, new ArrayList<>());
        Candidatura result = instance.getCandidatura();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDados method, of class CriarCandidaturaExpoController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String nomeEmpresa = "nomeEmpresa";
        String moradaEmpresa = "moradaEmpresa";
        double areaPretendida = 5.4;
        int telemovel = 914796264;
        int qtdConvites = 5;

        Exposicao exposicao = new Exposicao();
        CriarCandidaturaExpoController instance = new CriarCandidaturaExpoController(exposicao);
        instance.novaCandidatura();
        boolean result = instance.setDados(nomeEmpresa, moradaEmpresa, areaPretendida, telemovel, qtdConvites);
        boolean expResult = true;

        assertEquals(expResult, result);
    }

    /**
     * Test of addKeyword method, of class CriarCandidaturaExpoController.
     */
    @Test
    public void testAddKeyword() {
        System.out.println("addKeyword");
        String keyword = "123";
        Exposicao exposicao = new Exposicao();
        CriarCandidaturaExpoController instance = new CriarCandidaturaExpoController(exposicao);
        instance.novaCandidatura();
        instance.addKeyword(keyword);
        Keyword result = instance.getCandidatura().getKeywordList().get(0);
        Keyword expResult = new Keyword(keyword);
        assertEquals(expResult, result);
    }

    /**
     * Test of novaCandidatura method, of class CriarCandidaturaExpoController.
     */
    @Test
    public void testNovaCandidatura() {
        System.out.println("novaCandidatura");
        Exposicao exposicao = new Exposicao();
        CriarCandidaturaExpoController instance = new CriarCandidaturaExpoController(exposicao);
        instance.novaCandidatura();
        Candidatura result = instance.getCandidatura();
        Candidatura expResult = new Candidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of registarCandidatura method, of class
     * CriarCandidaturaExpoController.
     */
    @Test
    public void testRegistarCandidatura() {
        System.out.println("registarCandidatura");
        Exposicao exposicao = new Exposicao();
        CriarCandidaturaExpoController instance = new CriarCandidaturaExpoController(exposicao);
        instance.novaCandidatura();
        instance.setDados("nomeEmpresa", "moradaEmpresa", 5, 911111111, 9);
        boolean expResult = true;
        boolean result = instance.registarCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of addProduto method, of class CriarCandidaturaExpoController.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        String designacao = "designacao";
        Exposicao exposicao = new Exposicao();
        CriarCandidaturaExpoController instance = new CriarCandidaturaExpoController(exposicao);
        boolean expResult = true;
        boolean result = instance.addProduto(designacao);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaDemonstracoesExposicao method, of class
     * CriarCandidaturaExpoController.
     */
    @Test
    public void testGetListaDemonstracoesExposicao() {
        System.out.println("getListaDemonstracoesExposicao");
        Exposicao exposicao = new Exposicao();
        CriarCandidaturaExpoController instance = new CriarCandidaturaExpoController(exposicao);
        List<Demonstracao> expResult = new ArrayList<>();
        List<Demonstracao> result = instance.getListaDemonstracoesExposicao();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of addCandidaturaToExposicao method, of class
     * CriarCandidaturaExpoController.
     */
    @Test
    public void testAddCandidaturaToExposicao() {
        System.out.println("addCandidaturaToExposicao");
        Exposicao exposicao = new Exposicao();
        CriarCandidaturaExpoController instance = new CriarCandidaturaExpoController(exposicao);
        instance.novaCandidatura();
        instance.setDados("EmpresaM", "Rua", 20, 916263189, 100);
        boolean expResult = true;
        boolean result = instance.addCandidaturaToExposicao();
        assertEquals(expResult, result);
        
    }

}
