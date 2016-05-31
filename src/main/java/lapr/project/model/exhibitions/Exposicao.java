/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import lapr.project.model.users.FAE;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
    private ListaOrganizadores lstOrganizadores;
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
        this.dataInicioRealizacao = dataInicioRealizacao;
        this.dataFimRealizacao = dataFimRealizacao;
        this.dataInicioSubmissao = dataInicioSubmissao;
        this.dataFimSubmissao = dataFimSubmissao;
        this.local = local;
        this.listaFAE = listaFAE;
    }

    public Data getDataInicioSubmissao() {
        return dataInicioSubmissao;
    }

    public void setDataInicioSubmissao(Data dataInicioSubmissao) {
        this.dataInicioSubmissao = dataInicioSubmissao;
    }

    public Data getDataFimSubmissao() {
        return dataFimSubmissao;
    }

    public void setDataFimSubmissao(Data dataFimSubmissao) {
        this.dataFimSubmissao = dataFimSubmissao;
    }

    public Exposicao() {
        this.title = "";
        this.description = "";
        this.dataFimRealizacao = null;
        this.dataInicioRealizacao = null;
        this.listaFAE = new ListaFAE();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the dataInicioRealizacao
     */
    public Data getDataInicioRealizacao() {
        return dataInicioRealizacao;
    }

    /**
     * @param dataInicioRealizacao the dataInicioRealizacao to set
     */
    public void setDataInicioRealizacao(Data dataInicioRealizacao) {
        this.dataInicioRealizacao = dataInicioRealizacao;
    }

    /**
     * @return the dataFimRealizacao
     */
    public Data getDataFimRealizacao() {
        return dataFimRealizacao;
    }

    /**
     * @param dataFimRealizacao the dataFimRealizacao to set
     */
    public void setDataFimRealizacao(Data dataFimRealizacao) {
        this.dataFimRealizacao = dataFimRealizacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean valida() {
        if (this.title.equalsIgnoreCase("") || this.description.equalsIgnoreCase("") || this.dataInicioRealizacao == null || this.dataFimRealizacao == null || this.dataInicioSubmissao == null || this.dataFimRealizacao == null || this.local.equalsIgnoreCase("")) {
            return false;
        }
        return lstOrganizadores.valida();
    }
}
