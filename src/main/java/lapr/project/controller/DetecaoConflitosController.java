/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.TipoConflito;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.mecanismos.MecanismoDetecaoConflito;

/**
 *
 * @author zero_
 */
public class DetecaoConflitosController {

    private List<Exposicao> listExposicoesCandidaturaTerminada;
    private List<Demonstracao> listDemonstracoesCandidaturaTerminada;
    private List<TipoConflito> listTiposConflito;

    public DetecaoConflitosController(CentroExposicoes centroExposicoes) {
        this.listExposicoesCandidaturaTerminada = centroExposicoes.getListaExposicoes().getListaExposicoesCandidaturaTerminada();
        this.listDemonstracoesCandidaturaTerminada = new ArrayList<>();
        for (Exposicao expo : centroExposicoes.getListaExposicoes().getListaExposicoes()) {
            this.listDemonstracoesCandidaturaTerminada.addAll(expo.getListaDemonstracoes().getListaDemonstracoesCandidaturaTerminada());
        }
        this.listTiposConflito = centroExposicoes.getListaTipoConflito().getListaTipoConflito();
    }

    public void processoDeteccaoConflito() {
        for (Exposicao exposicao : listExposicoesCandidaturaTerminada) {
            processoDeteccaoConflitoExposicao(exposicao);

        }

        for (Demonstracao demo : listDemonstracoesCandidaturaTerminada) {
            processoDeteccaoConflitoDemonstracao(demo);
        }
    }

    private void processoDeteccaoConflitoExposicao(Exposicao exposicao) {
        for (TipoConflito tipoconflito : listTiposConflito) {
            final MecanismoDetecaoConflito mdc = tipoconflito.getMecanismoDetecaoConflito();
            mdc.detectConflitos(exposicao);
        }
    }

    private void processoDeteccaoConflitoDemonstracao(Demonstracao demonstracao) {
        for (TipoConflito tipoconflito : listTiposConflito) {
            final MecanismoDetecaoConflito mdc = tipoconflito.getMecanismoDetecaoConflito();
            mdc.detectConflitos(demonstracao);
        }
    }

}
