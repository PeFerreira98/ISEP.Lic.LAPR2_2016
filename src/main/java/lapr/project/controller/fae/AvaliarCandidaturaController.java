/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.fae;

import lapr.project.model.submissions.Avaliacao;
import lapr.project.model.submissions.Candidatura;

/**
 *
 * @author Marcos
 */
public class AvaliarCandidaturaController {
    
    private Candidatura candidatura;
    
    public AvaliarCandidaturaController(Candidatura c){
        this.candidatura = c;
    }
    
    public void avaliarCandidatura(String decisao, String justificacao){
        Avaliacao a = new Avaliacao();
        a.setDecisao(decisao);
        a.setJustificacao(justificacao);
        
        this.candidatura.addAvaliacao(a);
    }
    
}
