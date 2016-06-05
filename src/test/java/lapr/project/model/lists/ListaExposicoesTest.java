/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.List;
import lapr.project.model.exhibitions.Exposicao;
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
 * @author zero_
 */
public class ListaExposicoesTest {

    public ListaExposicoesTest() {
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
     * Test of addExposicao method, of class ListaExposicoes.
     */
    @Test
    public void testAddExposicao() {
        System.out.println("addExposicao");

        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        ListaExposicoes instance = new ListaExposicoes();

        boolean expResult = true;
        boolean result = instance.addExposicao(exposicao);

        assertEquals(expResult, result);
    }

    /**
     * Test of validaExposicao method, of class ListaExposicoes.
     */
    @Test
    public void testValidaExposicao() {
        System.out.println("validaExposicao");

        Utilizador utilizador2 = new Utilizador("Dummy3", "FAE", "FAE", "fae@domain.pt", "FAE");
        Utilizador utilizador4 = new Utilizador("Dummy5", "organizador", "organizador", "organizador@domain.pt", "ORGANIZADOR");

        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        ListaExposicoes instance = new ListaExposicoes();

        exposicao.getListaFAE().addFAE(new FAE(utilizador2));
        exposicao.getListaOrganizadores().addOrganizador(utilizador4);

        boolean expResult = true;
        boolean result = instance.validaExposicao(exposicao);

        assertEquals(expResult, result);
    }

    /**
     * Test of registaExposicao method, of class ListaExposicoes.
     */
    @Test
    public void testRegistaExposicao() {
        System.out.println("registaExposicao");

        Utilizador utilizador2 = new Utilizador("Dummy3", "FAE", "FAE", "fae@domain.pt", "FAE");
        Utilizador utilizador4 = new Utilizador("Dummy5", "organizador", "organizador", "organizador@domain.pt", "ORGANIZADOR");

        Exposicao exposicao = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        ListaExposicoes instance = new ListaExposicoes();

        exposicao.getListaFAE().addFAE(new FAE(utilizador2));
        exposicao.getListaOrganizadores().addOrganizador(utilizador4);

        boolean expResult = true;
        boolean result = instance.registaExposicao(exposicao);

        assertEquals(expResult, result);
    }

}
