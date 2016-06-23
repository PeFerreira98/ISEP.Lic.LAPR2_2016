/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.fae;

import java.util.ArrayList;
import lapr.project.model.submissions.Avaliacao;
import lapr.project.model.submissions.Candidatura;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos
 */
public class AvaliarCandidaturaControllerTest {
    
    public AvaliarCandidaturaControllerTest() {
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
     * Test of avaliarCandidatura method, of class AvaliarCandidaturaController.
     */
    @Test
    public void testAvaliarCandidatura() {
        System.out.println("avaliarCandidatura");
        String decisao = "decisao";
        String justificacao = "justificacao";
        String nomeEmpresa = "nome";
        String moradaEmpresa = "morada";
        int telemovel = 914796854;
        double areaPretendida = 15.4;
        int quantidadeConvites = 50;

        Candidatura c = new Candidatura(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, quantidadeConvites, new ArrayList<>());
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(c);

        instance.avaliarCandidatura(decisao, justificacao);
        Avaliacao expResult = new Avaliacao();
        expResult.setDecisao(decisao);
        expResult.setJustificacao(justificacao);
        Avaliacao result = c.getLstAvaliacoes().get(0);
        assertEquals(expResult, result);
    }
    
}
