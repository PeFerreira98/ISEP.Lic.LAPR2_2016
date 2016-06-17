/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;


import lapr.project.controller.gestor.CriarExposicaoController;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.GestorExposicoes;
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
 * @author Marcos
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
     * Test of convertStringToData method, of class CriarExposicaoController.
     */
    @Test
    public void testConvertStringToData() {
        System.out.println("convertStringToData");
        String data = "03-12-2016";
        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();
        ListaExposicoes listaExposicoes = new ListaExposicoes();
        CentroExposicoes centroExpo = new CentroExposicoes(registoUtilizadores, listaExposicoes);
        CriarExposicaoController instance = new CriarExposicaoController(centroExpo);
        Data expResult = new Data(2016, 12, 03);
        Data result = instance.convertStringToData(data);
        assertEquals(expResult, result);

    }

    /**
     * Test of addListaOrganizador method, of class CriarExposicaoController.
     */
    @Test
    public void testAddListaOrganizador() {
        System.out.println("addListaOrganizador");
        ListaOrganizadores lst = new ListaOrganizadores();

        Utilizador u = new Utilizador("Marcos", "1140956", "pw", "1140956@isep.ipp.pt");
        lst.addOrganizador(u);
        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();

        ListaExposicoes listaExposicoes = new ListaExposicoes();
        CentroExposicoes centroExpo = new CentroExposicoes(registoUtilizadores, listaExposicoes);
        CriarExposicaoController instance = new CriarExposicaoController(centroExpo);
        instance.addListaOrganizador(lst);
        ListaOrganizadores result = instance.getExposicao().getListaOrganizadores();
        Object expResult = lst;
        assertEquals(expResult, result);
    }

    /**
     * Test of addGestor method, of class CriarExposicaoController.
     */
    @Test
    public void testAddGestor() {
        System.out.println("addGestor");
        Utilizador utilizador = new Utilizador("Marcos", "1140956", "xpto", "1140956@isep.ipp.pt");

        GestorExposicoes g = new GestorExposicoes(utilizador);
        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();
        ListaExposicoes listaExposicoes = new ListaExposicoes();

        CentroExposicoes centroExpo = new CentroExposicoes(registoUtilizadores, listaExposicoes);

        CriarExposicaoController instance = new CriarExposicaoController(centroExpo);
        instance.addGestor(g);
        GestorExposicoes result = instance.getExposicao().getGestor();
        GestorExposicoes expResult = new GestorExposicoes(utilizador);
        assertEquals(expResult, result);

    }

    /**
     * Test of criarExpo method, of class CriarExposicaoController.
     */
    @Test
    public void testCriarExpo() {
        System.out.println("criarExpo");
        String titulo = "titulo";
        String desc = "descricao";
        String local = "local";
        Data dataInicioRealizacao = new Data();
        Data dataFimRealizacao = new Data();
        Data dataInicioSubmissao = new Data();
        Data dataFimSubmissao = new Data();
        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();
        ListaExposicoes listaExposicoes = new ListaExposicoes();

        CentroExposicoes centroExpo = new CentroExposicoes(registoUtilizadores, listaExposicoes);

        CriarExposicaoController instance = new CriarExposicaoController(centroExpo);
        instance.criarExpo(titulo, desc, local, dataInicioRealizacao, dataFimRealizacao, dataInicioSubmissao, dataFimSubmissao);
        Exposicao result = instance.getExposicao();

        Exposicao expResult = new Exposicao(titulo, desc, dataInicioRealizacao, dataFimRealizacao, dataInicioSubmissao, dataFimSubmissao, local);

        assertEquals(expResult, result);
    }

}
