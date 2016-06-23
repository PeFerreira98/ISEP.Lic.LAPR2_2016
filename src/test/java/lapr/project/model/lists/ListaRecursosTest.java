/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Recurso;
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
public class ListaRecursosTest {

    public ListaRecursosTest() {
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
     * Test of getListaRecursos method, of class ListaRecursos.
     */
    @Test
    public void testGetListaRecursos() {
        System.out.println("getListaRecursos");
        Recurso r = new Recurso();
        ListaRecursos instance = new ListaRecursos();
        List<Recurso> expResult = new ArrayList<>();
        expResult.add(r);
        instance.addRecurso(r);
        List<Recurso> result = instance.getListaRecursos();
        assertEquals(expResult, result);

    }

    /**
     * Test of addRecurso method, of class ListaRecursos.
     */
    @Test
    public void testAddRecurso() {
        System.out.println("addRecurso");
        Recurso recurso = new Recurso();
        ListaRecursos instance = new ListaRecursos();
        instance.getListaRecursos();
        boolean expResult = true;
        boolean result = instance.addRecurso(recurso);
        assertEquals(expResult, result);

    }

}
