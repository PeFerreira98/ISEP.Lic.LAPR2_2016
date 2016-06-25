/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.Demonstracao;
import lapr.project.model.Stand;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaProdutos;
import lapr.project.model.states.EstadoCandidatura;
import lapr.project.model.states.candidatura.EstadoCandidaturaEmSubmissao;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Representante;

/**
 *
 * @author TiagoSilvestre
 */
public class Candidatura implements Retiravel, Serializable {

    private String nomeEmpresa;
    private String moradaEmpresa;
    private int telemovel;
    private double areaPretendida;
    private int quantidadeConvites;

    private Representante rep;
    private EstadoCandidatura estadoCandidatura;
    private ListaProdutos listaProdutos;
    private Stand stand;
    private ListaDemonstracoes listaDemonstracoes;

    private List<Avaliacao> lstAvaliacoes;
    private List<Keyword> keywordList;
    private boolean standConfirmado;

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

        this.estadoCandidatura = new EstadoCandidaturaEmSubmissao(this);
        this.listaProdutos = new ListaProdutos();

        this.lstAvaliacoes = new ArrayList<>();
        this.keywordList = new ArrayList<>();
        this.listaDemonstracoes = new ListaDemonstracoes();
        this.keywordList.addAll(keywordList);
        standConfirmado = false;
    }

    public Candidatura() {
        this.estadoCandidatura = new EstadoCandidaturaEmSubmissao(this);
        this.listaProdutos = new ListaProdutos();
        this.lstAvaliacoes = new ArrayList<>();
        this.keywordList = new ArrayList<>();
        this.listaDemonstracoes = new ListaDemonstracoes();
        standConfirmado = false;
    }

    public void addAvaliacao(Avaliacao a) {
        this.lstAvaliacoes.add(a);
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

    public Representante getRep() {
        return rep;
    }

    public ListaDemonstracoes getListaDemonstracoes() {
        return listaDemonstracoes;
    }

    public void addDemonstracao(Demonstracao demonstracao) {
        listaDemonstracoes.addDemonstracao(demonstracao);

    }

    public void setRep(Representante rep) {
        this.rep = rep;
    }

    public void setStandConfirmado(boolean standConfirmado) {
        this.standConfirmado = standConfirmado;
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
        return areaPretendida > 0;
    }

    public static boolean validaQuantidadeConvites(int quantidadeConvites) {
        return quantidadeConvites > 0;
    }

    @Override
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public List<Avaliacao> getLstAvaliacoes() {
        return lstAvaliacoes;
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

    public Stand getStand() {
        return stand;
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

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public boolean valida() {
        if (nomeEmpresa == null || nomeEmpresa.trim().isEmpty()) {
            return false;
        }
        if (moradaEmpresa == null || moradaEmpresa.trim().isEmpty()) {
            return false;
        }
        if (quantidadeConvites < 0) {
            return false;
        }
        if (telemovel < 100000000 || telemovel > 999999999) {
            return false;
        }
        if (areaPretendida <= 0) {
            return false;
        }
        return true;
    }

    public void setEstado(EstadoCandidatura estadoCandidatura) {
        this.estadoCandidatura = estadoCandidatura;
    }

    public boolean setAvaliada(){
        return this.estadoCandidatura.setAvaliada();
    }
    
    public EstadoCandidatura getEstado() {
        return this.estadoCandidatura;
    }

    public boolean isStandConfirmado() {
        return standConfirmado;
    }

    public boolean isRetiravel() {
        return this.estadoCandidatura.isEmSubmissao();
    }

    public boolean isRetirada() {
        return this.estadoCandidatura.isRetirada();
    }

    public boolean isAvaliada() {
        return this.estadoCandidatura.isAvaliada();
    }

    public boolean isTerminada() {
        if (this.estadoCandidatura.isAceite()
                || this.estadoCandidatura.isRejeitada()
                || this.estadoCandidatura.isRetirada()
                || this.estadoCandidatura.isNaoAvaliada()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setRetirada() {
        return this.estadoCandidatura.setRetirada();
    }

    public boolean setAceite() {
        return this.estadoCandidatura.setAceite();
    }

    public boolean setRejeitada() {
        return this.estadoCandidatura.setRejeitada();
    }

    public boolean setEmAvaliacao() {
        return this.estadoCandidatura.setEmAvaliacao();
    }

    public boolean setNaoAvaliada() {
        return this.estadoCandidatura.setNaoAvaliada();
    }
    
    public void getAllSubFAE(FAE fae, List<Avaliacao> listSubFAEFinal) {
        for (Avaliacao avaliacao : this.lstAvaliacoes) {
            if(fae.equals(avaliacao.getAtribuicao().getFae())){
                listSubFAEFinal.add(avaliacao);
            }
        }
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
        return nomeEmpresa;
    }

    public String getInfo() {
        return "\nCandidatura{" + "nomeEmpresa=" + nomeEmpresa + ", moradaEmpresa=" + moradaEmpresa + ", telemovel=" + telemovel + ", areaPretendida=" + areaPretendida + ", quantidadeConvites="
                + quantidadeConvites + ", estadoCandidatura=" + estadoCandidatura + ",\n listaProdutos=" + listaProdutos + '}';
    }

}
