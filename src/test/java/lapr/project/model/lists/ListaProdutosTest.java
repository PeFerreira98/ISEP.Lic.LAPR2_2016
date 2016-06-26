/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.submissions.Produto;
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
public class ListaProdutosTest {

    public ListaProdutosTest() {
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
     * Test of addProduto method, of class ListaProdutos.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        Produto produto = new Produto("designacao");
        ListaProdutos instance = new ListaProdutos();
        instance.getListaProdutos();
        boolean expResult = true;
        boolean result = instance.addProduto(produto);
        assertEquals(expResult, result);

    }

    /**
     * Test of getListaProdutos method, of class ListaProdutos.
     */
    @Test
    public void testGetListaProdutos() {
        System.out.println("getListaProdutos");
        Produto p = new Produto("designacao");
        ListaProdutos instance = new ListaProdutos();
        List<Produto> expResult = new ArrayList<>();
        expResult.add(p);
        instance.addProduto(p);
        List<Produto> result = instance.getListaProdutos();
        assertEquals(expResult, result);

    }

}
