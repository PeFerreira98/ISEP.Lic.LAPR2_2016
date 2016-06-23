/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class ListaAtribuicoesTest {

    public ListaAtribuicoesTest() {
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
     * Test of addAtribuicoes method, of class ListaAtribuicoes.
     */
    @Test
    public void testAddAtribuicoes() {
        System.out.println("addAtribuicoes");
        List<Atribuicao> atrs = new ArrayList<>();
        FAE f = new FAE();
        Candidatura c = new Candidatura();
        Atribuicao atr = new Atribuicao(f, c);
        atrs.add(atr);
        ListaAtribuicoes instance = new ListaAtribuicoes();
        boolean expResult = true;
        boolean result = instance.addAtribuicoes(atrs);
        assertEquals(expResult, result);
        List<Atribuicao> lst = instance.getListaAtribuicoes();
        assertEquals(lst, atrs);
    }

    /**
     * Test of addAtribuicao method, of class ListaAtribuicoes.
     */
    @Test
    public void testAddAtribuicao() {
        System.out.println("addAtribuicao");
        FAE f = new FAE();
        Candidatura c = new Candidatura();
        Atribuicao atribuicao = new Atribuicao(f, c);
        ListaAtribuicoes instance = new ListaAtribuicoes();
        boolean expResult = true;
        boolean result = instance.addAtribuicao(atribuicao);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaAtribuicoes method, of class ListaAtribuicoes.
     */
    @Test
    public void testGetListaAtribuicoes() {
        System.out.println("getListaAtribuicoes");
        ListaAtribuicoes instance = new ListaAtribuicoes();
        FAE f = new FAE();
        Candidatura c = new Candidatura();
        Atribuicao atr = new Atribuicao(f, c);
        instance.addAtribuicao(atr);
        List<Atribuicao> expResult = new ArrayList<>();
        expResult.add(atr);
        List<Atribuicao> result = instance.getListaAtribuicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class ListaAtribuicoes.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ListaAtribuicoes instance = new ListaAtribuicoes();
        ListaAtribuicoes instance1 = new ListaAtribuicoes();
        int expResult = instance1.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class ListaAtribuicoes.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Object();
        ListaAtribuicoes instance = new ListaAtribuicoes();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        ListaAtribuicoes lst = new ListaAtribuicoes();
        expResult = true;
        result = instance.equals(lst);
        assertEquals(expResult, result);

    }

    /**
     * Test of exportContentToXMLNode method, of class ListaAtribuicoes.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        ListaAtribuicoes instance = new ListaAtribuicoes();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class ListaAtribuicoes.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        ListaAtribuicoes instance = new ListaAtribuicoes();
        ListaAtribuicoes expResult = null;
        ListaAtribuicoes result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
