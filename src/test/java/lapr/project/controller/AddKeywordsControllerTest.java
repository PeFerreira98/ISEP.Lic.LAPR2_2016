/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.controller.representante.AddKeywordsController;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Keyword;
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
public class AddKeywordsControllerTest {
    
    public AddKeywordsControllerTest() {
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
     * Test of clear method, of class AddKeywordsController.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Candidatura candidatura = new Candidatura("nome", "morada", 918000000, 10, 2, new ArrayList<>());
        AddKeywordsController instance = new AddKeywordsController(candidatura);
        instance.clear();
    }

    /**
     * Test of addKeyword method, of class AddKeywordsController.
     */
    @Test
    public void testAddKeyword() {
        System.out.println("addKeyword");
        Keyword keyword = new Keyword("pass");
        Candidatura candidatura = new Candidatura("nome", "morada", 918000000, 10, 2, new ArrayList<>());
        AddKeywordsController instance = new AddKeywordsController(candidatura);
        instance.addKeyword(keyword);
    }
    
}
