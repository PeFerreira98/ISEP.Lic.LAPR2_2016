/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.utils.Data;

/**
 *
 * @author TiagoSilvestre
 */
public class Exposicao {

    private String title;
    private String description;
    private String local;
    private Data dataInicioRealizacao;
    private Data dataFimRealizacao;
    private Data dataInicioSubmissao;
    private Data dataFimSubmissao;
    private ListaOrganizadores listaOrganizadores;
    private ListaFAE listaFAE;

    /**
     * Construtor de Exposicao
     *
     * @param nomeExposicao o nome da exposicao
     * @param descricaoExposicao a descricao da exposicao
     * @param dataInicioSubmissao a data de inicio da submissao da exposicao
     * @param dataFimSubmissao a data de fim da submissao da exposicao
     * @param dataInicioRealizacao a data de inicio da realização da exposicao
     * @param dataFimRealizacao a data de fim da realização da exposicao
     * @param local
     * @param listaOrganizadores
     * @param listaFAE
     */
    public Exposicao(String nomeExposicao, String descricaoExposicao, Data dataInicioRealizacao, 
            Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao, String local, 
            ListaOrganizadores listaOrganizadores, ListaFAE listaFAE) {
        this.title = nomeExposicao;
        this.description = descricaoExposicao;
        this.local = local;
        this.dataInicioRealizacao = dataInicioRealizacao;
        this.dataFimRealizacao = dataFimRealizacao;
        this.dataInicioSubmissao = dataInicioSubmissao;
        this.dataFimSubmissao = dataFimSubmissao;
        this.listaOrganizadores = listaOrganizadores;
        this.listaFAE = listaFAE;
    }

    public Exposicao() {
        this.title = "";
        this.description = "";
        this.local = "";
        this.dataInicioRealizacao = new Data();
        this.dataFimRealizacao = new Data();
        this.dataInicioSubmissao = new Data();
        this.dataFimSubmissao = new Data();
        this.listaOrganizadores = new ListaOrganizadores();
        this.listaFAE = new ListaFAE();
    }

    public Data getDataInicioSubmissao() {
        return dataInicioSubmissao;
    }

    public Data getDataFimSubmissao() {
        return dataFimSubmissao;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the dataInicioRealizacao
     */
    public Data getDataInicioRealizacao() {
        return dataInicioRealizacao;
    }

    /**
     * @return the dataFimRealizacao
     */
    public Data getDataFimRealizacao() {
        return dataFimRealizacao;
    }

    public String getLocal() {
        return local;
    }

    public ListaOrganizadores getListaOrganizadores() {
        return listaOrganizadores;
    }

    public ListaFAE getListaFAE() {
        return this.listaFAE;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setDataInicioRealizacao(Data dataInicioRealizacao) {
        this.dataInicioRealizacao = dataInicioRealizacao;
    }

    public void setDataFimRealizacao(Data dataFimRealizacao) {
        this.dataFimRealizacao = dataFimRealizacao;
    }

    public void setDataInicioSubmissao(Data dataInicioSubmissao) {
        this.dataInicioSubmissao = dataInicioSubmissao;
    }

    public void setDataFimSubmissao(Data dataFimSubmissao) {
        this.dataFimSubmissao = dataFimSubmissao;
    }

    public void setListaOrganizadores(ListaOrganizadores listaOrganizadores) {
        this.listaOrganizadores = listaOrganizadores;
    }

    public void setListaFAE(ListaFAE listaFAE) {
        this.listaFAE = listaFAE;
    }

    public boolean valida() {
        if (this.title.equalsIgnoreCase("") || this.description.equalsIgnoreCase("") || 
                this.dataInicioRealizacao == null || this.dataFimRealizacao == null || 
                this.dataInicioSubmissao == null || this.dataFimRealizacao == null || 
                this.local.equalsIgnoreCase("") || listaOrganizadores.valida() != true
                || listaFAE.valida() != true) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nExposicao{" + "title=" + title + ", description=" + description + ", local=" + local 
                + ", dataInicioRealizacao=" + dataInicioRealizacao + ", dataFimRealizacao=" + dataFimRealizacao 
                + ", dataInicioSubmissao=" + dataInicioSubmissao + ", dataFimSubmissao=" + dataFimSubmissao 
                + ", \nlistaOrganizadores=" + listaOrganizadores + ", \nlistaFAE=" + listaFAE + '}';
    }

}
