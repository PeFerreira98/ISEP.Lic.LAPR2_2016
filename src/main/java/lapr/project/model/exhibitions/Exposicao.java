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
     * @param listaFAE
     */
    public Exposicao(String nomeExposicao, String descricaoExposicao, Data dataInicioRealizacao, Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao, String local, ListaFAE listaFAE) {
        this.title = nomeExposicao;
        this.description = descricaoExposicao;
        this.local = local;

        this.dataInicioRealizacao = dataInicioRealizacao;
        this.dataFimRealizacao = dataFimRealizacao;
        this.dataInicioSubmissao = dataInicioSubmissao;
        this.dataFimSubmissao = dataFimSubmissao;

        this.listaOrganizadores = new ListaOrganizadores();
        this.listaFAE = listaFAE;
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
    
    public ListaFAE getListaFAE(){
        return this.listaFAE;
    }

    public boolean valida() {
        if (this.title.equalsIgnoreCase("") || this.description.equalsIgnoreCase("") || this.dataInicioRealizacao == null || this.dataFimRealizacao == null || this.dataInicioSubmissao == null || this.dataFimRealizacao == null || this.local.equalsIgnoreCase("")) {
            return false;
        }
        return listaOrganizadores.valida();
    }

    @Override
    public String toString() {
        return "\nExposicao{" + "title=" + title + ", description=" + description + ", local=" + local + ", dataInicioRealizacao=" + dataInicioRealizacao + ", dataFimRealizacao=" + dataFimRealizacao + ", dataInicioSubmissao=" + dataInicioSubmissao + ", dataFimSubmissao=" + dataFimSubmissao + ", \nlistaOrganizadores=" + listaOrganizadores + ", \nlistaFAE=" + listaFAE + '}';
    }

}
