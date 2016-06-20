/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.util.ArrayList;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Utilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TiagoSilvestre
 */
public class ConflitoTest {

    public ConflitoTest() {
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
     * Test of isFrom method, of class Conflito.
     */
    @Test
    public void testIsFrom() {
        System.out.println("isFrom");
        Utilizador utilizador = new Utilizador("Exp", "username", "passwod", "email");
        FAE fae = new FAE(utilizador);
        Candidatura candidatura = new Candidatura("nome", "morada", 910000000, 12, 10, new ArrayList<>());
        Conflito instance = new Conflito(fae, candidatura);
        boolean expResult = true;
        boolean result = instance.isFrom(candidatura);
        assertEquals(expResult, result);
    }

    /**
     * Test of isFrom method, of class Conflito.
     */
    @Test
    public void testIsFromFail() {
        System.out.println("isFrom");
        Utilizador utilizador = new Utilizador("Exp", "username", "passwod", "email");
        FAE fae = new FAE(utilizador);
        Candidatura candidatura = new Candidatura("nome", "morada", 910000000, 12, 10, new ArrayList<>());
        Candidatura candidatura2 = new Candidatura("nome2", "morada2", 910000000, 12, 10, new ArrayList<>());
        Conflito instance = new Conflito(fae, candidatura);
        boolean expResult = false;
        boolean result = instance.isFrom(candidatura2);
        assertEquals(expResult, result);
    }

    /**
     * Test of toStringList method, of class Conflito.
     */
    @Test
    public void testToStringList() {
        System.out.println("toStringList");
        Utilizador utilizador = new Utilizador("Exp", "username", "passwod", "email");
        FAE fae = new FAE(utilizador);
        Candidatura candidatura = new Candidatura("nome", "morada", 910000000, 12, 10, new ArrayList<>());
        Conflito instance = new Conflito(fae, candidatura);
        String expResult = "username - nome - SemDescricao";
        String result = instance.toStringList();
        assertEquals(expResult, result);
    }

}
