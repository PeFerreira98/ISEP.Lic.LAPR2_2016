/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

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
        Exposicao exposicao = new Exposicao("expo 1", "chinelos", data1, data2, data3, data4, "exponor", listaOrganizadores, listaFAE);
        CriarExposicaoController instance = new CriarExposicaoController();
        boolean expResult = true;
        boolean result = instance.novaExposicao(exposicao);
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
        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();
        Utilizador u1 = new Utilizador("user", "user", "password", "email", "fae");
        registoUtilizadores.addUtilizadorNaoRegistado(u1);
        CriarExposicaoController instance = new CriarExposicaoController();        
        Utilizador result = instance.getUtilizador("user");
        Utilizador expResult =  u1;
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
        Utilizador u1 = new Utilizador("user", "user", "pw", "email", "organizador");
        Utilizador u2 = new Utilizador("user2", "user2", "pw2", "email2", "fae");
        FAE fae = new FAE(u2);
        ListaOrganizadores listaOrganizadores = new ListaOrganizadores();
        listaOrganizadores.addOrganizador(u1);
        ListaFAE listaFAE = new ListaFAE();
        listaFAE.addFAE(fae);        
        Data data1 = new Data(2010, 5, 21);
        Data data2 = new Data(2010, 5, 30);
        Data data3 = new Data(2009, 8, 10);
        Data data4 = new Data(2010, 1, 30);
        CriarExposicaoController instance = new CriarExposicaoController();
        instance.setDados("nome", "descricao", data1, data2, data3, data4, "local", listaOrganizadores, listaFAE);
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
        ListaOrganizadores listaOrganizadores = new ListaOrganizadores();
        Utilizador u = new Utilizador("user", "user", "pass", "email", "fae");
        ListaFAE listaFAE = new ListaFAE();
        Data data1 = new Data(2010, 5, 21);
        Data data2 = new Data(2010, 5, 30);
        Data data3 = new Data(2009, 8, 10);
        Data data4 = new Data(2010, 1, 30);
        CriarExposicaoController instance = new CriarExposicaoController();
        listaOrganizadores.addOrganizador(null);
        instance.setDados("nome", "descricao", data1, data2, data3, data4, "local", listaOrganizadores, listaFAE);
        boolean expResult = true;
        boolean result = instance.registaExposicao();
        assertEquals(expResult, result);
    }

}
