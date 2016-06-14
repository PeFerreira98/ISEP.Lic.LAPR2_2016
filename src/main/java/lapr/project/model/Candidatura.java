/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.states.CandidaturaState;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaProdutos;

/**
 *
 * @author TiagoSilvestre
 */
public class Candidatura {

    private String nomeEmpresa;
    private String moradaEmpresa;
    private int telemovel;
    private double areaPretendida;
    private int quantidadeConvites;

    private CandidaturaState candidaturaState;
    private ListaDemonstracoes listaDemonstracoes;
    private ListaProdutos listaProdutos;

    private List<Avaliacao> lstAvaliacoes;
    private final List<Keyword> keywordList = new ArrayList<>();

    /**
     * Construtor de objecto Candidatura
     *
     * @param nomeEmpresa o nome da empresa
     * @param moradaEmpresa a morada da empresa
     * @param telemovel o numero de telemovel da empresa
     * @param areaPretendida a area pretendida para exposição
     * @param quantidadeConvites a quantidade de convites pretendida
     */
    public Candidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites, List<Keyword> keywordList) {
        this.nomeEmpresa = nomeEmpresa;
        this.moradaEmpresa = moradaEmpresa;
        this.telemovel = telemovel;
        this.areaPretendida = areaPretendida;
        this.quantidadeConvites = quantidadeConvites;

        this.candidaturaState = CandidaturaState.IN_SUBMISSION;
        this.listaDemonstracoes = new ListaDemonstracoes();
        this.listaProdutos = new ListaProdutos();

        this.lstAvaliacoes = new ArrayList<>();
        this.keywordList.addAll(keywordList);
    }

    public Candidatura() {
        this.candidaturaState = CandidaturaState.IN_SUBMISSION;
        this.listaDemonstracoes = new ListaDemonstracoes();
        this.listaProdutos = new ListaProdutos();
        this.lstAvaliacoes = new ArrayList<>();
    }

    public void addAvaliacao(Avaliacao a) {
        this.lstAvaliacoes.add(a);
    }

    public void changeState(CandidaturaState cs) {
        this.candidaturaState = cs;
    }

    public boolean addDemonstracao(Demonstracao demonstracao) {
        return this.listaDemonstracoes.addDemonstracao(demonstracao);
    }

    public boolean addProduto(Produto produto) {
        return this.listaProdutos.addProduto(produto);
    }

    /**
     * Add a keyword to Candidatura.
     *
     * @param keyword Keyword to be added.
     */
    public void addKeyword(Keyword keyword) {
        getKeywordList().add(keyword);
    }

    /**
     * Obtain the list of existing keywords.
     *
     * @return A list of existing keywords.
     */
    public List<Keyword> getKeywordList() {
        return keywordList;
    }

    public static boolean validaNomeEmpresa(String nomeEmpresa) {
        return !(nomeEmpresa == null || nomeEmpresa.trim().isEmpty());
    }

    public static boolean validaMoradaEmpresa(String moradaEmpresa) {
        return !(moradaEmpresa == null || moradaEmpresa.trim().isEmpty());
    }

    public static boolean validaTelemovel(int telemovel) {
        return telemovel > 100000000 && telemovel < 999999999;
    }

    public static boolean validaAreaPretendida(double areaPretendida) {
        return areaPretendida != 0;
    }

    public static boolean validaQuantidadeConvites(int quantidadeConvites) {
        return quantidadeConvites != 0;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public String getMoradaEmpresa() {
        return moradaEmpresa;
    }

    public double getAreaPretendida() {
        return areaPretendida;
    }

    public int getQuantidadeConvites() {
        return quantidadeConvites;
    }

    public ListaProdutos getListaProdutos() {
        return listaProdutos;
    }

    public ListaDemonstracoes getListaDemonstracoes() {
        return listaDemonstracoes;
    }

    public void setMoradaEmpresa(String moradaEmpresa) {
        this.moradaEmpresa = moradaEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setAreaPretendida(double areaPretendida) {
        this.areaPretendida = areaPretendida;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public void setQuantidadeConvites(int quantidadeConvites) {
        this.quantidadeConvites = quantidadeConvites;
    }

    public void setListaProdutos(ListaProdutos listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public List<Avaliacao> getLstAvaliacoes() {
        return lstAvaliacoes;
    }

    public boolean valida() {
        if (nomeEmpresa == null || nomeEmpresa.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        if (moradaEmpresa == null || moradaEmpresa.trim().isEmpty()) {
            throw new IllegalArgumentException("Morada inválida!");
        }
        if (quantidadeConvites < 0) {
            throw new IllegalArgumentException("Convites inválidos!");
        }
        if (telemovel < 100000000 || telemovel > 999999999) {
            throw new IllegalArgumentException("Número de telemóvel inválido!");
        }
        if (areaPretendida <= 0) {
            throw new IllegalArgumentException("Área expositor inválids!");
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.nomeEmpresa);
        hash = 53 * hash + Objects.hashCode(this.moradaEmpresa);
        hash = 53 * hash + this.telemovel;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.areaPretendida) ^ (Double.doubleToLongBits(this.areaPretendida) >>> 32));
        hash = 53 * hash + this.quantidadeConvites;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Candidatura other = (Candidatura) obj;
        if (this.telemovel != other.telemovel) {
            return false;
        }
        if (this.quantidadeConvites != other.quantidadeConvites) {
            return false;
        }
        if (!Objects.equals(this.nomeEmpresa, other.nomeEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.moradaEmpresa, other.moradaEmpresa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nCandidatura{" + "nomeEmpresa=" + nomeEmpresa + ", moradaEmpresa=" + moradaEmpresa + ", telemovel=" + telemovel + ", areaPretendida=" + areaPretendida + ", quantidadeConvites="
                + quantidadeConvites + ", candidaturaState=" + candidaturaState + ",\n listaDemonstracoes=" + listaDemonstracoes + ",\n listaProdutos=" + listaProdutos + '}';
    }

}
