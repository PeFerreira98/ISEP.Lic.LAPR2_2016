/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.fae;

import java.io.Serializable;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.submissions.Avaliacao;
import lapr.project.model.submissions.Candidatura;

/**
 *
 * @author Marcos
 */
public class AvaliarCandidaturaController implements Serializable{
    
    private Candidatura candidatura;
    private Atribuicao atribuicao;
    
    public AvaliarCandidaturaController(Candidatura c, Atribuicao atribuicao){
        this.candidatura = c;
        this.atribuicao = atribuicao;
    }
    
    public boolean avaliarCandidatura(String texto, int conhecimentoFAE, int adequacaoExpo, int adequacaoDemo, int adequacaoConvites, int recomendacao){
        Avaliacao a = new Avaliacao(texto, conhecimentoFAE, adequacaoExpo, adequacaoDemo, adequacaoConvites, recomendacao, this.atribuicao);
        if(a.valida()){
            this.candidatura.addAvaliacao(a);
            return true;
        }
        return false;
    }
    
}
