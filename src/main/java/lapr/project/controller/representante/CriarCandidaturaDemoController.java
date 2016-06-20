/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.representante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.submissions.Keyword;
import lapr.project.model.submissions.Produto;
import lapr.project.model.lists.ListaProdutos;

/**
 *
 * @author zero_
 */
public class CriarCandidaturaDemoController implements Serializable{

    private Demonstracao demo;

    private Candidatura candidatura;
    private ListaProdutos listaProdutos;
    private final List<Keyword> keywordList = new ArrayList<>();

    public CriarCandidaturaDemoController(Demonstracao d) {
        this.demo = d;
        this.listaProdutos = new ListaProdutos();
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

    public void addKeyword(String keyword) {
        Keyword kw = new Keyword(keyword);
        candidatura.addKeyword(kw);
    }

    public void novaCandidatura() {
        this.candidatura = new Candidatura();
    }

    public Candidatura getCandidatura() {
        return candidatura;
    }

    public boolean registarCandidatura() {
        return this.demo.addCandidatura(candidatura);
    }

    private boolean validate(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites) {
        boolean condicao1 = Candidatura.validaNomeEmpresa(nomeEmpresa) && Candidatura.validaMoradaEmpresa(moradaEmpresa);
        boolean condicao2 = Candidatura.validaTelemovel(telemovel) && Candidatura.validaAreaPretendida(areaPretendida);
        boolean condicao3 = Candidatura.validaQuantidadeConvites(quantidadeConvites);
        if (condicao1 && condicao2 && condicao3) {
            return true;
        }
        return false;
    }

    public boolean addProduto(String designacao) {
        final Produto prod;

        if (Produto.validaDesignacao(designacao)) {
            prod = new Produto(designacao);
            return this.listaProdutos.addProduto(prod);
        }

        return false;
    }

    private void addProdutosToCandidatura() {
        //Não usar func operations, SonarCube não gosta...
        for (Produto p : listaProdutos.getListaProdutos()) {
            this.candidatura.addProduto(p);
        }
    }

    public boolean addCandidaturaToDemo() {
        if (this.candidatura != null) {
//adiciona os produtos da lista temporaria a lista dentro da candidatura
            if (!this.listaProdutos.getListaProdutos().isEmpty()) {
                addProdutosToCandidatura();
            }

            return this.demo.addCandidatura(this.candidatura);
        }

        return false;

    }

}
