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
public class AtribuicaoTest {

    public AtribuicaoTest() {
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
     * Test of getFae method, of class Atribuicao.
     */
    @Test
    public void testGetFae() {
        System.out.println("getFae");
        FAE f = new FAE();
        Atribuicao instance = new Atribuicao(f);
        FAE expResult = f;
        FAE result = instance.getFae();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCandidatura method, of class Atribuicao.
     */
    @Test
    public void testGetCandidatura() {
        System.out.println("getCandidatura");
        FAE f = new FAE();
        Candidatura c = new Candidatura();
        Atribuicao instance = new Atribuicao(f, c);
        Candidatura expResult = c;
        Candidatura result = instance.getCandidatura();
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class Atribuicao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        FAE f = new FAE();
        Atribuicao instance = new Atribuicao(f);
        Atribuicao atr = new Atribuicao(f);
        int expResult = atr.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Atribuicao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Object();
        FAE f = new FAE();
        Atribuicao instance = new Atribuicao(f);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        Atribuicao atr = new Atribuicao(f);
        expResult = true;
        result = instance.equals(atr);
        assertEquals(expResult, result);

    }

}
