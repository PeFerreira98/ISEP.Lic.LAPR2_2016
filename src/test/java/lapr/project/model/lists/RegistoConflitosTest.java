/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.exhibitions.Conflito;
import lapr.project.model.exhibitions.TipoConflito;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Utilizador;
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
public class RegistoConflitosTest {

    public RegistoConflitosTest() {
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
     * Test of registarConflito method, of class RegistoConflitos.
     */
    @Test
    public void testRegistarConflito_FAE_Candidatura() {
        System.out.println("registarConflito");
        FAE fae = new FAE();
        Candidatura candidatura = new Candidatura();
        RegistoConflitos instance = new RegistoConflitos();
        boolean expResult = true;
        boolean result = instance.registarConflito(fae, candidatura);
        assertEquals(expResult, result);
        List<Conflito> lst = instance.getConflitos(candidatura);
        assertFalse(lst.isEmpty());

    }

    /**
     * Test of registarConflito method, of class RegistoConflitos.
     */
    @Test
    public void testRegistarConflito_3args() {
        System.out.println("registarConflito");
        FAE fae = new FAE();
        Candidatura candidatura = new Candidatura();
        TipoConflito tipoConflito = new TipoConflito();
        RegistoConflitos instance = new RegistoConflitos();
        boolean expResult = true;
        boolean result = instance.registarConflito(fae, candidatura, tipoConflito);
        assertEquals(expResult, result);
        List<Conflito> lst = instance.getConflitos(candidatura);
        assertFalse(lst.isEmpty());

    }

    /**
     * Test of deleteConflito method, of class RegistoConflitos.
     */
    @Test
    public void testDeleteConflito() {
        System.out.println("deleteConflito");
        FAE fae = new FAE(new Utilizador("nome", "username", "password", "email"));
        Candidatura c = new Candidatura("nomeEmpresa", "moradaEmpresa", 911111111, 65.2, 5, new ArrayList<>());
        TipoConflito tc = new TipoConflito("Descricao");
        Conflito conflito = new Conflito(fae, c, tc);
        RegistoConflitos instance = new RegistoConflitos();
        boolean expResult = false;
        boolean result = instance.deleteConflito(conflito);
        assertEquals(expResult, result);
        instance.registarConflito(fae, c, tc);
        expResult = true;
        result = instance.deleteConflito(conflito);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasConflitos method, of class RegistoConflitos.
     */
    @Test
    public void testHasConflitos() {
        System.out.println("hasConflitos");
        RegistoConflitos instance = new RegistoConflitos();
        boolean expResult = false;
        boolean result = instance.hasConflitos();
        assertEquals(expResult, result);
        instance.registarConflito(new FAE(), new Candidatura());
        expResult = true;
        result = instance.hasConflitos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getConflitos method, of class RegistoConflitos.
     */
    @Test
    public void testGetConflitos() {
        System.out.println("getConflitos");
        Candidatura candidatura = new Candidatura();
        RegistoConflitos instance = new RegistoConflitos();
        instance.registarConflito(new FAE(), candidatura);
        List<Conflito> result = instance.getConflitos(candidatura);
        assertFalse(result.isEmpty());

    }

    /**
     * Test of exportContentToXMLNode method, of class RegistoConflitos.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        RegistoConflitos instance = new RegistoConflitos();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class RegistoConflitos.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        RegistoConflitos instance = new RegistoConflitos();
        RegistoConflitos expResult = null;
        RegistoConflitos result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
