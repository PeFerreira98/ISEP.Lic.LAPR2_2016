/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mecanismos.atribuicao;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Atribuicao;
import lapr.project.model.Candidatura;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.mecanismos.MecanismoAtribuicao;
import lapr.project.model.users.FAE;

/**
 *
 * @author zero_
 */
public class MecanismoAtribuicao1 implements MecanismoAtribuicao{

    private List<Atribuicao> listaAtribuicoesTemp;
    
    private ListaCandidaturas listaCandidaturas;
    private ListaFAE listaFAE;
    
    @Override
    public String getDescricao() {
        return "MecanismoAtribuicao1Teste";
    }
    
    @Override
    public List<Atribuicao> getListaAtribuicoes(Exposicao exposicao) {
        listaAtribuicoesTemp = new ArrayList<>();        
        this.listaCandidaturas = exposicao.getListaCandidaturas();
        this.listaFAE = exposicao.getListaFAE();
        
        defineAssociacoes();
        
        return this.listaAtribuicoesTemp;
    }
    
    private void defineAssociacoes(){
        for (FAE fae : listaFAE.getListaFAE()) {
            for (Candidatura candidatura : listaCandidaturas.getListaCandidaturas()) {
                listaAtribuicoesTemp.add(new Atribuicao(fae, candidatura));
            }
        }
    }

    
        
}
