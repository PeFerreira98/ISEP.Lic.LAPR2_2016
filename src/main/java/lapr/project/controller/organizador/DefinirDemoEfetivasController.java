/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.organizador;

import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;

/**
 *
 * @author Sara Silva
 */
public class DefinirDemoEfetivasController {

    private final CentroExposicoes centroExp;
    private Exposicao exposicao;
    private Demonstracao demonstracao;

    public DefinirDemoEfetivasController(CentroExposicoes ce) {
        this.centroExp = ce;
    }

    public List<Exposicao> getListaExposicoes() {
        return centroExp.getListaExposicoes().getListaExposicoes();
    }

    public List<Demonstracao> getListaDemonstracoes() {
        return exposicao.getListaDemonstracoes().getListaDemonstracoes();
    }

    public void setDemonstracao(Demonstracao demonstracao) {
        this.demonstracao = demonstracao;
    }

    public void setDemonstracaoEfetiva() {
        demonstracao.setDemonstracaoEfetiva(true);
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

}
