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
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaProdutos;

/**
 *
 * @author zero_
 */
public class CriarCandidaturaExpoController implements Serializable {

    private Exposicao exposicao;

    private Candidatura candidatura;
    private ListaProdutos listaProdutos;
    private final List<Keyword> keywordList = new ArrayList<>();

    public CriarCandidaturaExpoController(Exposicao exposicao) {
        this.exposicao = exposicao;
        this.listaProdutos = new ListaProdutos();
    }

    public Candidatura getCandidatura() {
        return candidatura;
    }

//    public boolean createCandidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites) {
//        System.out.println(nomeEmpresa + " - " + moradaEmpresa + " - " + telemovel
//                + " - " + areaPretendida + " - " + quantidadeConvites);
//
//        if (validate(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, quantidadeConvites)) {
//            this.candidatura = new Candidatura(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, quantidadeConvites);
//            return true;
//        }
//        return false;
//    }
//
//    private boolean validate(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites) {
//        if (Candidatura.validaNomeEmpresa(nomeEmpresa)
//                && Candidatura.validaMoradaEmpresa(moradaEmpresa)
//                && Candidatura.validaTelemovel(telemovel)
//                && Candidatura.validaAreaPretendida(areaPretendida)
//                && Candidatura.validaQuantidadeConvites(quantidadeConvites)) {
//
//            return true;
//        }
//        return false;
//    }
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

    public boolean registarCandidatura() {
        return exposicao.addCandidatura(candidatura);
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

    public List<Demonstracao> getListaDemonstracoesExposicao() {
        return this.exposicao.getListaDemonstracoes().getListaDemonstracoes();
    }

    private void addProdutosToCandidatura() {
        //Não usar func operations, SonarCube não gosta...
        for (Produto p : listaProdutos.getListaProdutos()) {
            this.candidatura.addProduto(p);
        }
    }

    public boolean addCandidaturaToExposicao() {
        if (this.candidatura != null) {
//adiciona os produtos da lista temporaria a lista dentro da candidatura
            if (!this.listaProdutos.getListaProdutos().isEmpty()) {
                addProdutosToCandidatura();
            }

            return exposicao.addCandidatura(this.candidatura);
        }

        return false;

    }

}
