/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.Produto;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaProdutos;

/**
 *
 * @author zero_
 */
public class CriarCandidaturaController {

    private Exposicao exposicao;

    private Candidatura candidatura;
    private ListaDemonstracoes listaDemonstracoes;
    private ListaProdutos listaProdutos;

    public CriarCandidaturaController(Exposicao exposicao) {
        this.exposicao = exposicao;
        this.listaDemonstracoes = new ListaDemonstracoes();
        this.listaProdutos = new ListaProdutos();
    }

    public boolean createCandidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites) {
        System.out.println(nomeEmpresa + " - " + moradaEmpresa + " - " + telemovel
                + " - " + areaPretendida + " - " + quantidadeConvites);

        if (validate(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, quantidadeConvites)) {
            this.candidatura = new Candidatura(nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, quantidadeConvites);
            return true;
        }
        return false;
    }

    private boolean validate(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites) {
        if (Candidatura.validaNomeEmpresa(nomeEmpresa)
                && Candidatura.validaMoradaEmpresa(moradaEmpresa)
                && Candidatura.validaTelemovel(telemovel)
                && Candidatura.validaAreaPretendida(areaPretendida)
                && Candidatura.validaQuantidadeConvites(quantidadeConvites)){
            
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

    public boolean addDemonstracao(Demonstracao demonstracao) {
        if (demonstracao != null) {
            return this.listaDemonstracoes.addDemonstracao(demonstracao);
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

    private void addDemonstracoesToCandidatura() {
        //Não usar func operations, SonarCube não gosta...
        for (Demonstracao d : listaDemonstracoes.getListaDemonstracoes()) {
            this.candidatura.addDemonstracao(d);
        }
    }

    public boolean addCandidaturaToExposicao() {
        if (this.candidatura != null) {
            //adiciona as demonstraçoes da lista temporária na lista dentro da candidatura
            if (!this.listaDemonstracoes.getListaDemonstracoes().isEmpty()) {
                addDemonstracoesToCandidatura();
            }

            //adiciona os produtos da lista temporaria a lista dentro da candidatura
            if (!this.listaProdutos.getListaProdutos().isEmpty()) {
                addProdutosToCandidatura();
            }

            return exposicao.addCandidatura(this.candidatura);
        }

        return false;

    }

}
