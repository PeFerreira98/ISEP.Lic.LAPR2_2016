/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.TipoConflito;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.mecanismos.MecanismoDetecaoConflito;

/**
 *
 * @author zero_
 */
public class DetecaoConflitosController {

    private List<Exposicao> listExposicoesCandidaturaTerminada;
    private List<TipoConflito> listTiposConflito;

    public DetecaoConflitosController(CentroExposicoes centroExposicoes) {
        this.listExposicoesCandidaturaTerminada = centroExposicoes.getListaExposicoes().getListaExposicoesCandidaturaTerminada();
        this.listTiposConflito = centroExposicoes.getListaTipoConflito().getListaTipoConflito();
    }

    public void processoDeteccaoConflito() {
        for (Exposicao exposicao : listExposicoesCandidaturaTerminada) {
            processoDeteccaoConflito(exposicao);
        }
    }

    public void processoDeteccaoConflito(Exposicao exposicao) {
        for (TipoConflito tipoconflito : listTiposConflito) {
            final MecanismoDetecaoConflito mdc = tipoconflito.getMecanismoDetecaoConflito();
            mdc.detectConflitos(exposicao);
        }
    }

}
