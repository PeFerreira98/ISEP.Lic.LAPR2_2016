/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.gestor;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Stand;
import lapr.project.model.exhibitions.CentroExposicoes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Silva
 */
public class DefinirStandCentroControllerTest {

    public DefinirStandCentroControllerTest() {
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
     * Test of addStandByObject method, of class DefinirStandCentroController.
     */
    @Test
    public void testAddStandByObject() {
        System.out.println("addStandByObject");
        Stand stand = new Stand("descricao");
        CentroExposicoes centroExp = new CentroExposicoes();
        DefinirStandCentroController instance = new DefinirStandCentroController(centroExp);
        boolean expResult = true;
        boolean result = instance.addStandByObject(stand);
        assertEquals(expResult, result);

    }

    /**
     * Test of addStand method, of class DefinirStandCentroController.
     */
    @Test
    public void testAddStand() {
        System.out.println("addStand");
        String stand = "descricao";
        CentroExposicoes centroExp = new CentroExposicoes();
        DefinirStandCentroController instance = new DefinirStandCentroController(centroExp);
        boolean expResult = true;
        boolean result = instance.addStand(stand);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaStands method, of class DefinirStandCentroController.
     */
    @Test
    public void testGetListaStands() {
        System.out.println("getListaStands");
        CentroExposicoes centroExp = new CentroExposicoes();
        Stand s = new Stand("descricao");
        DefinirStandCentroController instance = new DefinirStandCentroController(centroExp);
        List<Stand> expResult = new ArrayList<>();
        expResult.add(s);
        instance.addStandByObject(s);
        List<Stand> result = instance.getListaStands();
        assertEquals(expResult, result);

    }

}
