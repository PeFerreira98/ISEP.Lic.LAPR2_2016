/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.Keyword;
import lapr.project.model.Produto;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaProdutos;

/**
 *
 * @author Sara Silva
 */
public class AlterarCandidaturaController {
    
    private final CentroExposicoes centroExp;
    private Exposicao exposicao;
    private Candidatura candidatura;
    private ListaCandidaturas listaCandidaturas;
    private ListaProdutos listaProdutos;
    private ListaDemonstracoes listaDemonstracoes;
    
    public AlterarCandidaturaController(CentroExposicoes ce) {
        this.centroExp = ce;
    }
    
    public List<Exposicao> getListaExposicoes() {
        return centroExp.getListaExposicoes().getListaExposicoes();
    }
    
    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
        listaCandidaturas= exposicao.getListaCandidaturas();
    }
    
    public void setCandidatura(Candidatura candidatura) {
        this.candidatura = candidatura;
        listaProdutos=candidatura.getListaProdutos();
    }
    
    public List<Candidatura> getListaCandidaturas() {
        return centroExp.getListaCandidaturas().getListaCandidaturas();
    }
    
    public void addProduto(String produto) {
        listaProdutos.addProduto(new Produto(produto));
    }
     
    public void addKeyword(String keyword){
        Keyword kw = new Keyword(keyword);
        candidatura.addKeyword(kw);
    }
    
    public void addDemonstracao(String demo) {
        listaDemonstracoes.addDemonstracao(new Demonstracao(demo));
    }
    
    public boolean registarCandidaturas() {
        return listaCandidaturas.addCandidatura(candidatura);
    }
    
    public void setDados(String nomeEmpresa, String moradaEmpresa, double areaPretendida, int telemovel, int qtdConvites) {
        candidatura.setNomeEmpresa(nomeEmpresa);
        candidatura.setMoradaEmpresa(moradaEmpresa);
        candidatura.setAreaPretendida(areaPretendida);
        candidatura.setTelemovel(telemovel);
        candidatura.setQuantidadeConvites(qtdConvites);
        candidatura.setListaProdutos(listaProdutos);
        
    }
    
}
