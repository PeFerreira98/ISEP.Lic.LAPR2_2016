/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

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
public class RecursoTest {

    public RecursoTest() {
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
     * Test of setDescricao method, of class Recurso.
     */
    @Test
    public void testSetGetDescricao() {
        System.out.println("setDescricao");
        String descricao = "Agua";
        Recurso instance = new Recurso(descricao);
        instance.setDescricao(descricao);
        String expResult = "Agua";
        String result = instance.getDescricao();
        assertEquals(expResult, result);

    }

}
