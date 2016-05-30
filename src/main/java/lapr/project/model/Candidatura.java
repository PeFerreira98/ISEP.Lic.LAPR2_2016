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

    //atributos de instância
    private String nomeEmpresa;
    private String moradaEmpresa;
    private int telemovel;
    private double areaPretendida;
    private int quantidadeConvites;
    private String produto;
//    private List<Demonstracao> lstDemonstracoes;
//    private List<Avaliacao> lstAvaliacao;
//    private ListaAtribuicao lstAtribuicoes;
//    private Avaliacao avaliacao;
    
    private CandidaturaStatus status;

    //atributos de classe
    private static String NOME_EMPRESA_OMISSAO = "no company name";
    private static String MORADA_EMPRESA_OMISSAO = "no company address";
    private static int TELEMOVEL_OMISSAO = 0;
    private static double AREA_OMISSAO = 0.0;
    private static int QUANTIDADE_CONVITES_OMISSAO = 0;
    private static String PRODUTO_OMISSAO = "no product";

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
    public Candidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites, String produto/*, List<Demonstracao> listaDemonstracoes*/) {
        this.nomeEmpresa = nomeEmpresa;
        this.moradaEmpresa = moradaEmpresa;
        this.telemovel = telemovel;
        this.areaPretendida = areaPretendida;
        this.quantidadeConvites = quantidadeConvites;
//        this.produto = produto;
//        this.lstDemonstracoes = listaDemonstracoes;
    }

    /**
     *
     * @param nomeEmpresa
     * @param moradaEmpresa
     * @param telemovel
     * @param areaPretendida
     * @param quantidadeConvites
     */
    public Candidatura(String nomeEmpresa, String moradaEmpresa, int telemovel, double areaPretendida, int quantidadeConvites) {
        this.nomeEmpresa = nomeEmpresa;
        this.moradaEmpresa = moradaEmpresa;
        this.telemovel = telemovel;
        this.areaPretendida = areaPretendida;
        this.quantidadeConvites = quantidadeConvites;
    }

    /**
     * Construtor vazio de objecto Candidatura
     */
    public Candidatura() {
        this.nomeEmpresa = NOME_EMPRESA_OMISSAO;
        this.moradaEmpresa = MORADA_EMPRESA_OMISSAO;
        this.telemovel = TELEMOVEL_OMISSAO;
        this.areaPretendida = AREA_OMISSAO;
        this.quantidadeConvites = QUANTIDADE_CONVITES_OMISSAO;
        produto = PRODUTO_OMISSAO;
//        lstDemonstracoes = new ArrayList<>();

        this.status = CandidaturaStatus.IN_SUBMISSION;
    }

    /**
     * Construtor cópia de objecto Candidatura
     *
     * @param outraCandidatura objecto Candidatura a copiar
     */
    public Candidatura(Candidatura outraCandidatura) {
        this(outraCandidatura.getNomeEmpresa(), outraCandidatura.getMoradaEmpresa(), outraCandidatura.getTelemovel(),
                outraCandidatura.getAreaPretendida(), outraCandidatura.getQuantidadeConvites());
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

    /**
     * Devolve a lista de produtos a expor
     *
     * @return lista de produtos a expor
     */
//    public String getProduto() {
//        return produto;
//    }

    /**
     * Modifica a lista de produtos a expor
     *
     * @param produto a nova lista de produtos a expor
     */
//    public void setProduto(String produto) {
//        if (produto == null || produto.trim().isEmpty()) {
//            throw new IllegalArgumentException("Produto é inválido!");
//        }
//        this.produto = produto;
//
//    }

    /**
     * Devolve a lista de demonstrações disponíveis
     *
     * @return a lista de demonstrações disponiveis
     */
//    public List<Demonstracao> getListaDemonstracao() {
//        return lstDemonstracoes;
//    }

    /**
     * Modifica a lista de demonstrações disponíveis
     *
     * @param listaDemonstracoes a nova lista de demonstrações
     */
//    public void setListaDemonstracoes(List<Demonstracao> listaDemonstracoes) {
//        this.lstDemonstracoes = listaDemonstracoes;
//    }

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
        if (obj == null) {
            return false;
        }
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
//        if (!Objects.equals(this.produto, other.produto)) {
//            return false;
//        }
//        if (!Objects.equals(this.lstDemonstracoes, other.lstDemonstracoes)) {
//            return false;
//        }
        return true;
    }

    /**
     * Devolve a informação textual do objecto em causa
     *
     * @return informação textual
     */
    @Override
    public String toString() {
        return String.format("CANDIDATURA\n"
                + "Nome da Empresa: %s\n"
                + "Morada da Empresa: %s\n"
                + "Telemóvel: %d\n"
                + "Área pretendida para exposição: %0.2f\n"
                + "Lista de Produtos a expor: %s\n"
                + "Quantidade de convites: %d\n"
                + "Lista de Demonstrações disponíveis: \n", nomeEmpresa, moradaEmpresa, telemovel, areaPretendida, produto, quantidadeConvites);
    }

    /**
     * Método para validar a Candidatura
     *
     * @return true caso valide, false caso contrario
     */
    public boolean valida() {
        return !(this.areaPretendida == 0 || this.moradaEmpresa.equalsIgnoreCase("") || this.nomeEmpresa.equalsIgnoreCase("") || this.telemovel == 0 && this.quantidadeConvites < 1);
    }

    /**
     * Devolve a Lista de Atribuicoes da candidatura
     *
     * @return a lista de atribuicoes
     */
//    public ListaAtribuicao getListaAtribuicao() {
//        return this.lstAtribuicoes;
//    }

    /**
     * Devolve a lista de representantes da candidatura
     *
     * @return a lista de representantes
     */
//    public ListaRegistos getListaRepresentantes() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }

}
