/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.fae;

import java.util.ArrayList;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.submissions.Avaliacao;
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
        
        String texto = "blablabla";
        int[] array = new int[5];
        for(int i = 0; i < 5; i++){
            array[i] = 2;
        }
        String nomeEmpresa = "nome";
        String moradaEmpresa = "morada";
        int telemovel = 914796854;
        double areaPretendida = 15.4;
        int quantidadeConvites = 50;

        Candidatura c = new Candidatura(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, quantidadeConvites, new ArrayList<>());
        Atribuicao atribuicao = new Atribuicao(new FAE(), c);
        AvaliarCandidaturaController instance = new AvaliarCandidaturaController(c, atribuicao);

        instance.avaliarCandidatura(texto, array[0], array[1], array[2], array[3], array[4]);
        Avaliacao expResult = new Avaliacao(texto, array[0], array[1], array[2], array[3], array[4], atribuicao);
        Avaliacao result = c.getLstAvaliacoes().get(0);
        assertEquals(expResult, result);

    }

}
