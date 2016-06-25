/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import lapr.project.model.users.FAE;
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
public class AvaliacaoTest {

    public AvaliacaoTest() {
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
     * Test of setTexto method, of class Avaliacao.
     */
    @Test
    public void testSetGetTexto() {
        System.out.println("setTexto");
        String texto = "Texto";
        Avaliacao instance = new Avaliacao();
        instance.setTexto(texto);
        String result = instance.getTexto();
        assertEquals(texto, result);

    }

    /**
     * Test of getRecomendacao method, of class Avaliacao.
     */
    @Test
    public void testGetRecomendacao() {
        System.out.println("getRecomendacao");
        Avaliacao instance = new Avaliacao("texto", 2, 2, 4, 1, 3, new Atribuicao(new FAE()));
        int expResult = 3;
        int result = instance.getRecomendacao();
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class Avaliacao.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Avaliacao instance = new Avaliacao();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Avaliacao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Avaliacao instance = new Avaliacao("texto", 2, 2, 4, 1, 3, new Atribuicao(new FAE()));
        Avaliacao av = new Avaliacao("texto", 2, 2, 4, 1, 3, new Atribuicao(new FAE()));
        int expResult = av.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Avaliacao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Object();
        Avaliacao instance = new Avaliacao("texto", 2, 2, 4, 1, 3, new Atribuicao(new FAE()));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        Avaliacao av = new Avaliacao("texto", 2, 2, 4, 1, 3, new Atribuicao(new FAE()));
        expResult = true;
        result = instance.equals(av);
        assertEquals(expResult, result);
    }

}
