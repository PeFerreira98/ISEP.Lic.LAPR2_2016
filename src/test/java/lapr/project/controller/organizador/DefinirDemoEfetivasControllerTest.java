/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.organizador;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.utils.Data;
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
public class DefinirDemoEfetivasControllerTest {

    public DefinirDemoEfetivasControllerTest() {
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
     * Test of getListaExposicoes method, of class
     * DefinirDemoEfetivasController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        CentroExposicoes centro = new CentroExposicoes();
        Exposicao exp = new Exposicao();
        DefinirDemoEfetivasController instance = new DefinirDemoEfetivasController(centro);
        centro.getListaExposicoes().addExposicao(exp);
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(exp);
        List<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaDemonstracoes method, of class
     * DefinirDemoEfetivasController.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        CentroExposicoes centro = new CentroExposicoes();
        Demonstracao demo = new Demonstracao();
        Exposicao expo = new Exposicao();
        expo.getListaDemonstracoes().addDemonstracao(demo);
        DefinirDemoEfetivasController instance = new DefinirDemoEfetivasController(centro);
        instance.setExposicao(expo);
        centro.getListaExposicoes().addExposicao(expo);
        List<Demonstracao> expResult = new ArrayList<>();
        expResult.add(demo);
        List<Demonstracao> result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);

    }

    /**
     * Test of setDemonstracaoEfetiva method, of class
     * DefinirDemoEfetivasController.
     */
    @Test
    public void testSetDemonstracaoEfetiva() {
        System.out.println("setDemonstracaoEfetiva");
        DefinirDemoEfetivasController instance = new DefinirDemoEfetivasController(new CentroExposicoes());
        Demonstracao demo = new Demonstracao();
        instance.setDemonstracao(demo);
        assertFalse(demo.isDemonstracaoEfetiva());
        instance.setDemonstracaoEfetiva();
        assertTrue(demo.isDemonstracaoEfetiva());

    }

    /**
     * Test of setData method, of class DefinirDemoEfetivasController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        String data = "08-11-1994";
        CentroExposicoes centro = new CentroExposicoes();
        Demonstracao demonstracao = new Demonstracao();
        DefinirDemoEfetivasController instance = new DefinirDemoEfetivasController(centro);
        instance.setDemonstracao(demonstracao);
        instance.setData(data);
        Data result = instance.getDate();
        Data expResult = instance.convertStringToData(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of getInfo method, of class DefinirDemoEfetivasController.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        CentroExposicoes ce = new CentroExposicoes();
        DefinirDemoEfetivasController instance = new DefinirDemoEfetivasController(ce);
        Demonstracao demo=new Demonstracao("codigo", "designacao");
        instance.setDemonstracao(demo);
        String expResult = "Código: codigo\nDesignação: designacao";
        String result = instance.getInfo();
        assertEquals(expResult, result);

    }

}
