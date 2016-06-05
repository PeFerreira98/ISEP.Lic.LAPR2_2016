/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.lists.ListaDemonstracoes;

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
    private CandidaturaState candidaturaStatus;
    private ListaDemonstracoes listaDemonstracoes;
    private List<Produto> listaProdutos;

    /**
     * Construtor de objecto Candidatura
     *
     * @param nomeEmpresa o nome da empresa
     * @param moradaEmpresa a morada da empresa
     * @param telemovel o numero de telemovel da empresa
     * @param areaPretendida a area pretendida para exposição
     * @param quantidadeConvites a quantidade de convites pretendida
     */
    public Candidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites) {
        this.nomeEmpresa = nomeEmpresa;
        this.moradaEmpresa = moradaEmpresa;
        this.telemovel = telemovel;
        this.areaPretendida = areaPretendida;
        this.qtdConvites = qtdConvites;
        this.listaDemonstracoes = listaDemonstracoes;
        this.listaProdutos = listaProdutos;
    }

    public Candidatura() {
        listaProdutos = new ArrayList<>();
        listaDemonstracoes = new ListaDemonstracoes();

        this.candidaturaStatus = CandidaturaState.IN_SUBMISSION;
    }

    public boolean addDemonstracao(Demonstracao demonstracao) {
        return this.listaDemonstracoes.addDemonstracao(demonstracao);
    }

    public boolean addProduto(Produto produto) {
        if (!this.listaProdutos.stream().noneMatch((p) -> (p.equals(produto)))) {
            return false;
        }
        return this.listaProdutos.add(produto);
    }

    public static boolean validaNomeEmpresa(String nomeEmpresa) {
        return !(nomeEmpresa == null || nomeEmpresa.trim().isEmpty());
    }

    public static boolean validaMoradaEmpresa(String moradaEmpresa) {
        return !(moradaEmpresa == null || moradaEmpresa.trim().isEmpty());
    }

    public static boolean validaTelemovel(int telemovel) {
        return (telemovel > 100000000 && telemovel < 999999999);
    }

    public static boolean validaAreaPretendida(double areaPretendida) {
        return (areaPretendida != 0);
    }

    public static boolean validaQuantidadeConvites(int quantidadeConvites) {
        return (quantidadeConvites != 0);
    }

    public String getNomeEmpresa() {
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
        this.listaProdutos = produtos;
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
        return listaProdutos;
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Método para comparar um objecto com outro do mesmo tipo
     *
     * @param obj objecto Candidatura a comparar
     * @return true se todos os parâmetros forem iguais. false caso contrário
     */
    public boolean equals(Candidatura obj) {

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Candidatura other = (Candidatura) obj;
        if (!Objects.equals(this.nomeEmpresa, other.nomeEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.moradaEmpresa, other.moradaEmpresa)) {
            return false;
        }
        if (this.telemovel != other.telemovel) {
            return false;
        }
        if (Double.doubleToLongBits(this.areaPretendida) != Double.doubleToLongBits(other.areaPretendida)) {
            return false;
        }
        if (this.qtdConvites != other.qtdConvites) {
            return false;
        }

        return true;
    }

    public void addProduto(String produto) {
        listaProdutos.add(new Produto(produto));
    }

    @Override
    public String toString() {
        return "\nCandidatura{" + "nomeEmpresa=" + nomeEmpresa + ", moradaEmpresa=" + moradaEmpresa + ", telemovel=" + telemovel + ", areaPretendida=" + areaPretendida + ", quantidadeConvites="
                + qtdConvites + ", candidaturaState=" + candidaturaStatus + ",\n listaDemonstracoes=" + listaDemonstracoes + ",\n listaProdutos=" + listaProdutos + '}';
    }

}
