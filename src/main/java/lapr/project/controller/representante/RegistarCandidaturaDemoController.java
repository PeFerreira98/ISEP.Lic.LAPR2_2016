/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.representante;

import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaProdutos;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Keyword;
import lapr.project.model.submissions.Produto;

/**
 *
 * @author Sara Silva
 */
public class RegistarCandidaturaDemoController {

    private final CentroExposicoes centroExp;
    private Exposicao exposicao;
    private Candidatura candidatura;
    private Demonstracao demo;
    private ListaProdutos listaProdutos;

    public RegistarCandidaturaDemoController(CentroExposicoes ce) {
        this.centroExp = ce;
    }

    public List<Exposicao> getListaExposicoes() {
        return centroExp.getListaExposicoes().getListaExposicoes();
    }

    public List<Demonstracao> getListaDemonstracoes() {
        return exposicao.getListaDemonstracoes().getListaDemonstracoes();
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

    public void setDemonstracao(Demonstracao demonstracao) {
        this.demo = demonstracao;
    }

    public void novaCandidatura() {
        this.candidatura = new Candidatura();
    }

    public boolean registarCandidatura() {
        return this.demo.addCandidatura(candidatura);
    }

    public void addKeyword(String keyword) {
        candidatura.addKeyword(new Keyword(keyword));
    }

    public boolean addProduto(String designacao) {
        return candidatura.addProduto(new Produto(designacao));
    }

    public boolean setDados(String nomeEmpresa, String moradaEmpresa, double areaPretendida, int telemovel, int qtdConvites) {

        candidatura.setNomeEmpresa(nomeEmpresa);
        candidatura.setMoradaEmpresa(moradaEmpresa);
        candidatura.setAreaPretendida(areaPretendida);
        candidatura.setTelemovel(telemovel);
        candidatura.setQuantidadeConvites(qtdConvites);
        candidatura.setListaProdutos(listaProdutos);
        return candidatura.valida();
    }

}
