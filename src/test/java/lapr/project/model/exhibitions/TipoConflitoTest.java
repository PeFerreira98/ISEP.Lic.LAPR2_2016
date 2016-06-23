/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import lapr.project.model.mecanismos.MecanismoDetecaoConflito;
import lapr.project.model.mecanismos.detecaoconflito.MecanismoDetecaoConflito1;
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
public class TipoConflitoTest {

    public TipoConflitoTest() {
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
     * Test of getDescricao method, of class TipoConflito.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        TipoConflito instance = new TipoConflito();
        String expResult = "Descricao";
        instance.setDescricao("Descricao");
        String result = instance.getDescricao();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMecanismoDetecaoConflito method, of class TipoConflito.
     */
    @Test
    public void testGetMecanismoDetecaoConflito() {
        System.out.println("getMecanismoDetecaoConflito");
        MecanismoDetecaoConflito expResult = new MecanismoDetecaoConflito1();
        TipoConflito instance = new TipoConflito("Tipo Conflitos", expResult);
        MecanismoDetecaoConflito result = instance.getMecanismoDetecaoConflito();
        assertEquals(expResult, result);

    }

}
