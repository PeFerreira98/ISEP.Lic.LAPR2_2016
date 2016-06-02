/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author TiagoSilvestre
 */
public class Candidatura {

    private String nomeEmpresa;
    private String moradaEmpresa;
    private String produto;
    private double areaPretendida;
    private int telemovel;
    private int quantidadeConvites;
    private CandidaturaState candidaturaStatus;

    /**
     * Construtor de objecto Candidatura
     *
     * @param nomeEmpresa o nome da empresa
     * @param moradaEmpresa a morada da empresa
     * @param telemovel o numero de telemovel da empresa
     * @param areaPretendida a area pretendida para exposição
     * @param produto o produto a expôr
     * @param quantidadeConvites a quantidade de convites pretendida
     * @param listaDemonstracoes
     */
    public Candidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites, String produto) {
        this.nomeEmpresa = nomeEmpresa;
        this.moradaEmpresa = moradaEmpresa;
        this.telemovel = telemovel;
        this.areaPretendida = areaPretendida;
        this.quantidadeConvites = quantidadeConvites;
    }

    /**
     * Devolve o nome da empresa
     *
     * @return nome da empresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * Modifica o nome da empresa
     *
     * @param nomeEmpresa o novo nome da empresa
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        if (nomeEmpresa == null || nomeEmpresa.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é inválido!");
        }
        this.nomeEmpresa = nomeEmpresa;

    }

    /**
     * Devolve a morada da empresa
     *
     * @return a morada da empresa
     */
    public String getMoradaEmpresa() {
        return moradaEmpresa;
    }

    /**
     * Modifica a morada da empresa
     *
     * @param moradaEmpresa a nova morada da empresa
     */
    public void setMoradaEmpresa(String moradaEmpresa) {
        if (moradaEmpresa == null || moradaEmpresa.trim().isEmpty()) {
            throw new IllegalArgumentException("Morada é inválida!");
        }
        this.moradaEmpresa = moradaEmpresa;

    }

    /**
     * Devolve o numero de telemovel da empresa
     *
     * @return o numero de telemovel da empresa
     */
    public int getTelemovel() {
        return telemovel;
    }

    /**
     * Modifica o numero de telemovel da empresa
     *
     * @param telemovel o novo numero de telemovel da empresa
     */
    public void setTelemovel(int telemovel) {
        if (telemovel < 100000000 || telemovel > 999999999) {
            throw new NumberFormatException("Telemóvel é inválido!");
        }
        this.telemovel = telemovel;

    }

    /**
     * Devolve a area pretendida para exposicao
     *
     * @return a area pretendida para exposicao
     */
    public double getAreaPretendida() {
        return areaPretendida;
    }

    /**
     * Modifica a area pretendida para exposicao
     *
     * @param areaPretendida a nova area pretendida para exposicao
     */
    public void setAreaPretendida(double areaPretendida) {
        if (areaPretendida == 0) {
            throw new IllegalArgumentException("Área é inválida!");
        }
        this.areaPretendida = areaPretendida;

    }

    /**
     * Devolve a quantidade de convites
     *
     * @return a quantidade de convites
     */
    public int getQuantidadeConvites() {
        return quantidadeConvites;
    }

    /**
     * Modifica a quantidade de convites
     *
     * @param quantidadeConvites a nova quantidade de convites
     */
    public void setQuantidadeConvites(int quantidadeConvites) {
        if (quantidadeConvites == 0) {
            throw new IllegalArgumentException("Quantidade de convites é inválida!");
        }
        this.quantidadeConvites = quantidadeConvites;

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
        if (this.quantidadeConvites != other.quantidadeConvites) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "\nCandidatura{" + "nomeEmpresa=" + nomeEmpresa + ", moradaEmpresa=" + moradaEmpresa + ", produto=" + produto + ", areaPretendida=" + areaPretendida + ", telemovel=" + telemovel + ", quantidadeConvites=" + quantidadeConvites + ", candidaturaStatus=" + candidaturaStatus + '}';
    }

    /**
     * Método para validar a Candidatura
     *
     * @return true caso valide, false caso contrario
     */
    public boolean valida() {
        return !(this.areaPretendida == 0 || this.moradaEmpresa.equalsIgnoreCase("") || this.nomeEmpresa.equalsIgnoreCase("") || this.telemovel == 0 && this.quantidadeConvites < 1);
    }

}
