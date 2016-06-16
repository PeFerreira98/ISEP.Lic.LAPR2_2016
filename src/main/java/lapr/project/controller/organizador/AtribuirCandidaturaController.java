/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.organizador;

import java.util.List;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.mecanismos.MecanismoAtribuicao;

/**
 *
 * @author Sara Silva
 */
public class AtribuirCandidaturaController {

    private final CentroExposicoes centroExp;
    
    private Exposicao exposicao;
    private MecanismoAtribuicao mecanismo;
    private ListaAtribuicoes listaAtribuicoes;
    
    private List<Atribuicao> atribuicoesTemporaria;

    public AtribuirCandidaturaController(CentroExposicoes ce) {
        this.centroExp = ce;
    }
    
    public List<Exposicao> getListaExposicoes(){
        return centroExp.getListaExposicoes().getListaExposicoes();
    }

    public List<MecanismoAtribuicao> getListaMecanismos() {
        return centroExp.getListaMecanismos();
    }
    
    public List<Atribuicao> getListaAtribuicoes() {
        this.atribuicoesTemporaria = mecanismo.getListaAtribuicoes(this.exposicao);
        return this.atribuicoesTemporaria;
    }
    
    public boolean registarAtribuicoes(){
        return listaAtribuicoes.addAtribuicoes(this.atribuicoesTemporaria);
    }
    
    public void setExposicao(Exposicao exposicao){
        this.exposicao = exposicao;
        this.listaAtribuicoes = this.exposicao.getListaAtribuicoes();
    }
    
    public void setMecanismo(MecanismoAtribuicao mecanismo){
        this.mecanismo = mecanismo;
    }
    
}
