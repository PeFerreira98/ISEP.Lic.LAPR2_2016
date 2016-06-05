/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TiagoSilvestre
 */
public class Candidatura {

    private String nomeEmpresa;
    private String moradaEmpresa;
    private double areaPretendida;
    private int telemovel;
    private int qtdConvites;
    private List<Produto> produtos;
    private List<Demonstracao> demonstracoes;
    private CandidaturaState candidaturaStatus;

    public Candidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int qtdConvites, List<Produto> listaProdutos, List<Demonstracao> listaDemonstracoes) {
        this.nomeEmpresa = nomeEmpresa;
        this.moradaEmpresa = moradaEmpresa;
        this.telemovel = telemovel;
        this.areaPretendida = areaPretendida;
        this.qtdConvites = qtdConvites;
        this.demonstracoes = listaDemonstracoes;
        this.produtos = listaProdutos;
    }

    public Candidatura() {
        produtos = new ArrayList<>();
        demonstracoes = new ArrayList<>();
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nomeEmpresa;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return moradaEmpresa;
    }

    public void setAreaPretendida(double areaPretendida) {
        this.areaPretendida = areaPretendida;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setQtdConvites(int qtdConvites) {
        this.qtdConvites = qtdConvites;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nomeEmpresa = nome;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.moradaEmpresa = morada;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public int getQtdConvites() {
        return qtdConvites;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Demonstracao> getDemonstracoes() {
        return demonstracoes;
    }

    public double getAreaPretendida() {
        return areaPretendida;
    }

    public boolean valida() {
        if (nomeEmpresa == null || nomeEmpresa.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        } else if (moradaEmpresa == null || moradaEmpresa.trim().isEmpty()) {
            throw new IllegalArgumentException("Morada inválida!");
        } else if (qtdConvites < 0) {
            throw new IllegalArgumentException("Convites inválidos!");
        } else if (telemovel < 100000000 || telemovel > 999999999) {
            throw new IllegalArgumentException("Número de telemóvel inválido!");
        } else if (areaPretendida <= 0) {
            throw new IllegalArgumentException("Área expositor inválids!");
        }
        return true;
    }

    public void addProduto(String produto) {
        produtos.add(new Produto(produto));
    }

    public void addDemonstracao(Demonstracao demo) {
        demonstracoes.add(demo);
    }

    public boolean equals(Candidatura c) {
        if (this == c) {
            return true;
        }
        if (c == null || getClass() != c.getClass()) {
            return false;
        }
        Candidatura outraCandidatura = (Candidatura) c;

        return nomeEmpresa.equalsIgnoreCase(outraCandidatura.nomeEmpresa) && moradaEmpresa.equals(outraCandidatura.moradaEmpresa) && telemovel == outraCandidatura.telemovel
                && qtdConvites == outraCandidatura.qtdConvites && areaPretendida == outraCandidatura.areaPretendida;
    }

}
