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
    private int telemovel;
    private double areaPretendida;
    private int quantidadeConvites;
    
    private CandidaturaState candidaturaState;
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
        this.quantidadeConvites = quantidadeConvites;

        this.candidaturaState = CandidaturaState.IN_SUBMISSION;
        this.listaDemonstracoes = new ListaDemonstracoes();
        this.listaProdutos = new ArrayList<>();
    }

    public boolean addDemonstracao(Demonstracao demonstracao){
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
        return "\nCandidatura{" + "nomeEmpresa=" + nomeEmpresa + ", moradaEmpresa=" + moradaEmpresa + ", telemovel=" + telemovel + ", areaPretendida=" + areaPretendida + ", quantidadeConvites="
                + quantidadeConvites + ", candidaturaState=" + candidaturaState + ",\n listaDemonstracoes=" + listaDemonstracoes + ",\n listaProdutos=" + listaProdutos + '}';
    }

    
}
