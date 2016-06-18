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
import lapr.project.utils.Data;

/**
 *
 * @author Sara Silva
 */
public class DefinirDemoEfetivasController {

    private final CentroExposicoes centroExp;
    private Exposicao exposicao;
    private Demonstracao demonstracao;
    private Data date;

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

    public void setData(String data) {
        Data date = convertStringToData(data);
        demonstracao.setData(date);
    }

    public Data getDate() {
        return date;
    }

    public Data convertStringToData(String data) {
        final Data d;

        String[] aux = data.split("-");
        int dia = Integer.parseInt(aux[0]);
        int mes = Integer.parseInt(aux[1]);
        int ano = Integer.parseInt(aux[2]);

        d = new Data(ano, mes, dia);

        return d;
    }

}
