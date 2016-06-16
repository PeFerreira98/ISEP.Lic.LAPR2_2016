/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Organizador;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class ExposicaoTest {

    public ExposicaoTest() {
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
     * Test of addCandidatura method, of class Exposicao.
     */
    @Test
    public void testAddCandidatura() {
        System.out.println("addCandidatura");

        Candidatura candidatura = new Candidatura("EfoCorp", "Rua do queijo", 916658064, 20, 100, new ArrayList<>());

        Exposicao instance = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");

        boolean expResult = true;
        boolean result = instance.addCandidatura(candidatura);

        assertEquals(expResult, result);
    }

    /**
     * Test of valida method, of class Exposicao.
     */
    @Test
    public void testValida() {
        System.out.println("valida");

        Utilizador utilizador2 = new Utilizador("Dummy3", "FAE", "FAE", "fae@domain.pt", "FAE");
        Utilizador utilizador4 = new Utilizador("Dummy5", "organizador", "organizador", "organizador@domain.pt", "ORGANIZADOR");

        Exposicao instance = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");

        instance.getListaFAE().addFAE(new FAE(utilizador2));
        instance.getListaOrganizadores().addOrganizador(utilizador4);

        boolean expResult = true;
        boolean result = instance.valida();

        assertEquals(expResult, result);
    }

    /**
     * Test of getFAE method, of class Exposicao.
     */
    @Test
    public void testGetFAE() {
        System.out.println("getFAE");

        String username = "FAE";
        Utilizador utilizador2 = new Utilizador("Dummy3", "FAE", "FAE", "fae@domain.pt", "FAE");
        FAE fae = new FAE(utilizador2);

        Exposicao instance = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        instance.getListaFAE().addFAE(fae);

        FAE expResult = fae;
        FAE result = instance.getFAE(username);

        assertEquals(expResult, result);
    }

    /**
     * Test of hasFAE method, of class Exposicao.
     */
    @Test
    public void testHasFAE() {
        System.out.println("hasFAE");

        String username = "FAE";
        Utilizador utilizador2 = new Utilizador("Dummy3", "FAE", "FAE", "fae@domain.pt", "FAE");
        FAE fae = new FAE(utilizador2);

        Exposicao instance = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        instance.getListaFAE().addFAE(fae);

        boolean expResult = true;
        boolean result = instance.hasFAE(username);

        assertEquals(expResult, result);
    }

    /**
     * Test of hasOrganizador method, of class Exposicao.
     */
    @Test
    public void testHasOrganizador() {
        System.out.println("hasOrganizador");

        String username = "ORGANIZADOR";
        Utilizador utilizador2 = new Utilizador("Dummy3", "ORGANIZADOR", "ORGANIZADOR", "fae@domain.pt", "ORGANIZADOR");

        Exposicao instance = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        instance.getListaOrganizadores().addOrganizador(utilizador2);

        boolean expResult = true;
        boolean result = instance.hasOrganizador(username);

        assertEquals(expResult, result);
    }

    /**
     * Test of isOrganizador method, of class Exposicao.
     */
    @Test
    public void testIsOrganizador() {
        System.out.println("isOrganizador");

        String username = "ORGANIZADOR";
        Utilizador utilizador2 = new Utilizador("Dummy3", "ORGANIZADOR", "ORGANIZADOR", "fae@domain.pt", "ORGANIZADOR");
        Organizador org = new Organizador(utilizador2);
        Exposicao instance = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        instance.getListaOrganizadores().addOrganizador(utilizador2);

        boolean expResult = true;
        boolean result = instance.isOrganizador(org);

        assertEquals(expResult, result);
    }

}
