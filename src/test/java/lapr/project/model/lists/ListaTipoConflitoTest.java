/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.exhibitions.TipoConflito;
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
public class ListaTipoConflitoTest {

    public ListaTipoConflitoTest() {
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
     * Test of getListaTipoConflito method, of class ListaTipoConflito.
     */
    @Test
    public void testGetListaTipoConflito() {
        System.out.println("getListaTipoConflito");
        TipoConflito tp = new TipoConflito();
        ListaTipoConflito instance = new ListaTipoConflito();
        List<TipoConflito> expResult = new ArrayList<>();
        expResult.add(tp);
        instance.addTipoConflito(tp);
        List<TipoConflito> result = instance.getListaTipoConflito();
        assertEquals(expResult, result);

    }

    /**
     * Test of addTipoConflito method, of class ListaTipoConflito.
     */
    @Test
    public void testAddTipoConflito() {
        System.out.println("addTipoConflito");
        TipoConflito tipoConflito = new TipoConflito();
        ListaTipoConflito instance = new ListaTipoConflito();
        instance.getListaTipoConflito();
        boolean expResult = true;
        boolean result = instance.addTipoConflito(tipoConflito);
        assertEquals(expResult, result);

    }

}
