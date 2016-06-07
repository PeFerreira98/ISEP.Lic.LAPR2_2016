/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
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
    private ListaAtribuicoes atribuicoes;

    public AtribuirCandidaturaController(CentroExposicoes ce) {
        this.centroExp = ce;
    }

    public List<MecanismoAtribuicao> getListaMecanismos() {
        return centroExp.getListaMecanismos();
    }
    
    
}
