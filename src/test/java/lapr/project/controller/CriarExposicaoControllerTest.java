/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoUtilizadores;
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
public class CriarExposicaoControllerTest {

    public CriarExposicaoControllerTest() {
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
     * Test of novaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testNovaExposicao() {
        System.out.println("novaExposicao");
        ListaOrganizadores listaOrganizadores = new ListaOrganizadores();
        ListaFAE listaFAE = new ListaFAE();
        Data data1 = new Data(2010, 5, 21);
        Data data2 = new Data(2010, 5, 30);
        Data data3 = new Data(2009, 8, 10);
        Data data4 = new Data(2010, 1, 30);
        CriarExposicaoController instance = new CriarExposicaoController();
        instance.setDados("expo 1", "chinelos", data1, data2, data3, data4, "exponor", listaOrganizadores, listaFAE);
        boolean expResult = true;
        boolean result = instance.novaExposicao();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDados method, of class CriarExposicaoController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String nomeExposicao = "expo1";
        String descricaoExposicao = "chinelos";
        Data dataInicioRealizacao = new Data(2010, 5, 10);
        Data dataFimRealizacao = new Data(2010, 5, 30);
        Data dataInicioSubmissao = new Data(2009, 8, 10);
        Data dataFimSubmissao = new Data(2010, 1, 30);;
        String local = "exponor";
        ListaOrganizadores listaOrganizadores = new ListaOrganizadores();
        ListaFAE listaFAE = new ListaFAE();
        CriarExposicaoController instance = new CriarExposicaoController();
        instance.setDados(nomeExposicao, descricaoExposicao, dataInicioRealizacao, dataFimRealizacao, dataInicioSubmissao, dataFimSubmissao, local, listaOrganizadores, listaFAE);
    }

    /**
     * Test of getUtilizador method, of class CriarExposicaoController.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        CentroExposicoes centro = new CentroExposicoes();
        Utilizador u1 = new Utilizador("user", "user", "password", "email", "fae");
        Utilizador u2 = new Utilizador("user1", "user1", "password1", "email1", "organizador");
        centro.getRegistoUtilizadores().addUtilizadorNaoRegistado(u1);
        centro.getRegistoUtilizadores().addUtilizadorNaoRegistado(u2);

        CriarExposicaoController instance = new CriarExposicaoController();
        instance.getRegistoUtilizadores().addUtilizadorNaoRegistado(u1);

        Utilizador expResult = u1;
        Utilizador result = instance.getUtilizador("user");
        assertEquals(expResult, result);
    }

    /**
     * Test of addOrganizador method, of class CriarExposicaoController.
     */
    @Test
    public void testAddOrganizador() {
        System.out.println("addOrganizador");
        Utilizador utilizador = new Utilizador("user", "user", "password", "email", "fae");
        CriarExposicaoController instance = new CriarExposicaoController();
        instance.addOrganizador(utilizador);
    }

    /**
     * Test of validaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testValidaExposicao() {
        System.out.println("validaExposicao");
        Utilizador utilizador2 = new Utilizador("Dummy3", "FAE", "FAE", "fae@domain.pt", "FAE");
        Utilizador utilizador4 = new Utilizador("Dummy5", "organizador", "organizador", "organizador@domain.pt", "ORGANIZADOR");

        Exposicao exposicao = new Exposicao();

        exposicao.getListaFAE().addFAE(new FAE(utilizador2));
        exposicao.getListaOrganizadores().addOrganizador(utilizador4);

        CriarExposicaoController instance = new CriarExposicaoController();

        instance.setDados("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House", exposicao.getListaOrganizadores(), exposicao.getListaFAE());

        boolean expResult = true;
        boolean result = instance.validaExposicao();

        assertEquals(expResult, result);
    }

    /**
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testRegistaExposicao() {
        System.out.println("registaExposicao");
        Utilizador utilizador2 = new Utilizador("Dummy3", "FAE", "FAE", "fae@domain.pt", "FAE");
        Utilizador utilizador4 = new Utilizador("Dummy5", "organizador", "organizador", "organizador@domain.pt", "ORGANIZADOR");

        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        exposicao.getListaFAE().addFAE(new FAE(utilizador2));
        exposicao.getListaOrganizadores().addOrganizador(utilizador4);
        CriarExposicaoController instance = new CriarExposicaoController();
        instance.setDados(exposicao.getTitle(), exposicao.getDescription(), exposicao.getDataInicioRealizacao(),
                exposicao.getDataFimRealizacao(), exposicao.getDataInicioSubmissao(), exposicao.getDataFimSubmissao(),
                exposicao.getLocal(), exposicao.getListaOrganizadores(), exposicao.getListaFAE());
        boolean expResult = true;
        boolean result = instance.registaExposicao();
        assertEquals(expResult, result);
    }

}
