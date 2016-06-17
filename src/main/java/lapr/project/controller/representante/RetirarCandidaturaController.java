/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.representante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.submissions.Retiravel;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;

/**
 *
 * @author zero_
 */
public class RetirarCandidaturaController implements Serializable{

    private CentroExposicoes centroExposicoes;
    private List<Retiravel> lRetiraveis;

    public RetirarCandidaturaController(CentroExposicoes centroExposicoes) {
        this.centroExposicoes = centroExposicoes;
        this.lRetiraveis = new ArrayList<>();
    }

    public List<Retiravel> getListaRetiraveis() {
        createListaRetiraveis();
        return this.lRetiraveis;
    }

    private void createListaRetiraveis() {
        List<Retiravel> lRetiraveisTemp = new ArrayList<>();

        //Add candidaturas de exposicoes retiraveis
        lRetiraveisTemp = this.centroExposicoes.getListaExposicoes().getCandidaturasExposicoesRetiraveis();
        this.lRetiraveis.addAll(lRetiraveisTemp);

        lRetiraveisTemp = new ArrayList<>();

        //Add candidaturas de demonstracoes retiraveis
        for (Exposicao e : this.centroExposicoes.getListaExposicoes().getListaExposicoes()) {
            lRetiraveisTemp = e.getCandidaturasDemonstracoesRetiraveis();
            this.lRetiraveis.addAll(lRetiraveisTemp);
        }

    }

    public boolean retirarCandidatura(Retiravel retiravel) {
        return retiravel.setRetirada();
    }

}
