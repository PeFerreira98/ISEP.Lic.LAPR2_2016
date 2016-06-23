/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.states.candidatura.EstadoCandidaturaEmSubmissao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Retiravel;
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
public class ListaCandidaturasTest {

    public ListaCandidaturasTest() {
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
     * Test of registaCandidatura method, of class ListaCandidaturas.
     */
    @Test
    public void testRegistaCandidatura() {
        System.out.println("registaCandidatura");
        Candidatura candidatura = new Candidatura("nomeEmpresa", "moradaEmpresa", 911111111, 16.54, 5, new ArrayList<>());
        ListaCandidaturas instance = new ListaCandidaturas();
        boolean expResult = true;
        boolean result = instance.registaCandidatura(candidatura);
        assertEquals(expResult, result);
        List<Candidatura> lst = new ArrayList<>();
        lst.add(candidatura);
        List<Candidatura> lst1 = instance.getListaCandidaturas();
        assertEquals(lst, lst1);

    }

    /**
     * Test of novaCandidatura method, of class ListaCandidaturas.
     */
    @Test
    public void testNovaCandidatura() {
        System.out.println("novaCandidatura");
        ListaCandidaturas instance = new ListaCandidaturas();
        Candidatura expResult = new Candidatura();
        Candidatura result = instance.novaCandidatura();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaCandidaturas method, of class ListaCandidaturas.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        ListaCandidaturas instance = new ListaCandidaturas();
        List<Candidatura> expResult = new ArrayList<>();
        Candidatura can = new Candidatura("nomeEmpresa", "moradaEmpresa", 911111111, 16.54, 5, new ArrayList<>());
        expResult.add(can);
        instance.registaCandidatura(can);
        List<Candidatura> result = instance.getListaCandidaturas();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCandidaturasRetiraveis method, of class ListaCandidaturas.
     */
    @Test
    public void testGetCandidaturasRetiraveis() {
        System.out.println("getCandidaturasRetiraveis");
        ListaCandidaturas instance = new ListaCandidaturas();
        List<Retiravel> expResult = new ArrayList<>();
        Candidatura can = new Candidatura("nomeEmpresa", "moradaEmpresa", 911111111, 16.54, 5, new ArrayList<>());
        expResult.add(can);
        instance.registaCandidatura(can);
        can.setEstado(new EstadoCandidaturaEmSubmissao(can));
        List<Retiravel> result = instance.getCandidaturasRetiraveis();
        assertEquals(expResult, result);

    }

    /**
     * Test of hashCode method, of class ListaCandidaturas.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ListaCandidaturas instance = new ListaCandidaturas();
        ListaCandidaturas lst = new ListaCandidaturas();
        int expResult = lst.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class ListaCandidaturas.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Object();
        ListaCandidaturas instance = new ListaCandidaturas();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        ListaCandidaturas lst = new ListaCandidaturas();
        expResult = true;
        result = instance.equals(lst);
        assertEquals(expResult, result);

    }

}
