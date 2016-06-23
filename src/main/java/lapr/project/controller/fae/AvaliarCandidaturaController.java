/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.fae;

import java.io.Serializable;
import lapr.project.model.submissions.Avaliacao;
import lapr.project.model.submissions.Candidatura;

/**
 *
 * @author Marcos
 */
public class AvaliarCandidaturaController implements Serializable{
    
    private Candidatura candidatura;
    
    public AvaliarCandidaturaController(Candidatura c){
        this.candidatura = c;
    }
    
//    public void avaliarCandidatura(String decisao, String justificacao){
//        Avaliacao a = new Avaliacao();
//        a.setDecisao(decisao);
//        a.setJustificacao(justificacao);
//        
//        this.candidatura.addAvaliacao(a);
//    }
    
    public boolean avaliarCandidatura(String texto, int conhecimentoFAE, int adequacaoExpo, int adequacaoDemo, int adequacaoConvites, int recomendacao){
        Avaliacao a = new Avaliacao(texto, conhecimentoFAE, adequacaoExpo, adequacaoDemo, adequacaoConvites, recomendacao);
        if(a.valida()){
            this.candidatura.addAvaliacao(a);
            return true;
        }
        return false;
    }
    
}
