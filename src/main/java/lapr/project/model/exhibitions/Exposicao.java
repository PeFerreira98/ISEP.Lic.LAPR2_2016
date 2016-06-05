/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.model.Atribuicao;
import lapr.project.model.Demonstracao;
import lapr.project.model.Local;
import lapr.project.model.Candidatura;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Organizador;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Data;

/**
 *
 * @author TiagoSilvestre
 */
public class Exposicao {

    private String titulo;
    private String descricao;
    private Data dataInicio;
    private Data dataFim;
    private Local local;
    private Data dataInicioSubmissao;
    private Data dataFimSubmissao;
    private ListaOrganizadores listaOrganizadores;
    private ListaFAE listaFAE;
    private List<Atribuicao> listaAtribuicoes;
    private List<Candidatura> listaCandidaturas;
    private ListaDemonstracoes listaDemonstracoes;

    public Exposicao(String titulo, String descricao, Data converterParaData, Data converterParaData0, Data dataInicioSubmissao, Data dataFimSubmissao, String local) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = converterParaData;
        this.dataFim = converterParaData0;
    }

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

        this.titulo = nomeExposicao;
        this.descricao = descricaoExposicao;
        this.local = new Local(local);

        this.dataInicio = dataInicioRealizacao;
        this.dataFim = dataFimRealizacao;
        this.dataInicioSubmissao = dataInicioSubmissao;
        this.dataFimSubmissao = dataFimSubmissao;

        this.listaOrganizadores = listaOrganizadores;
        this.listaFAE = listaFAE;
        this.listaDemonstracoes = new ListaDemonstracoes();
    }

    public Exposicao() {
        this.titulo = "";
        this.descricao = "";
        this.local = new Local();

        this.dataInicio = new Data();
        this.dataFim = new Data();
        this.dataInicioSubmissao = new Data();
        this.dataFimSubmissao = new Data();

        this.listaOrganizadores = new ListaOrganizadores();
        this.listaFAE = new ListaFAE();
        this.listaDemonstracoes = new ListaDemonstracoes();
    }

    public Data getDataInicioSubmissao() {
        return dataInicioSubmissao;
    }

    public Data getDataFimSubmissao() {
        return dataFimSubmissao;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    public Local getLocal() {
        return local;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public ListaOrganizadores getListaOrganizadores() {
        return listaOrganizadores;
    }

    public ListaFAE getListaFAE() {
        return this.listaFAE;
    }

    public Data getDataFim() {
        return dataFim;
    }

    public ListaDemonstracoes getListaDemonstracoes() {
        return listaDemonstracoes;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    public FAE getFAE(String id) {
        for (FAE fae : listaFAE.getListaFAE()) {
            if (fae.getUtilizador().hasID(id)) {
                return fae;
            }
        }
        return new FAE();
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    public boolean addCandidatura(Candidatura c) {
        return listaCandidaturas.add(c);
    }

    public void addAtribuicao(Atribuicao a) {
        listaAtribuicoes.add(a);
    }

    public void addFAE(FAE fae) {
        listaFAE.getListaFAE().add(fae);
    }

    public Candidatura novaCandidatura() {
        return new Candidatura();
    }

    public List<Candidatura> getListaCandidaturas() {
        return listaCandidaturas;
    }

    public FAE novoFAE(Utilizador ut) {
        FAE fae = new FAE();
        fae.setUtilizador(ut);
        return fae;
    }

    public void registaListaFAE(List<FAE> listaFAE) {
        listaFAE.addAll(listaFAE);
    }

    public boolean registaCandidatura(Candidatura candidatura) {
        if (validaCandidatura(candidatura)) {
            return addCandidatura(candidatura);
        } else {
            return false;
        }
    }

    private boolean validaCandidatura(Candidatura candidatura) {
        return candidatura.valida() && !listaCandidaturas.contains(candidatura);
    }

    public List<Atribuicao> getAtribuicoes(String id) {
        List<Atribuicao> atr = new ArrayList<>();
        for (Atribuicao at : listaAtribuicoes) {
            if (at.getFae().getUtilizador().getUsername().equals(id)) {
                atr.add(at);
            }
        }
        return atr;
    }

    public List<Atribuicao> getListaAtribuicoes() {
        return listaAtribuicoes;
    }

    public Atribuicao novaAtribuicao() {
        return new Atribuicao();
    }

    public boolean hasFAE(String id) {
        for (FAE fae : listaFAE.getListaFAE()) {
            if (fae.getUtilizador().hasID(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasOrg(String id) {
        for (Organizador org : listaOrganizadores.getLstOrganizadores()) {
            if (org.getUtilizador().hasID(id)) {
                return true;
            }
        }
        return false;
    }

    public void addAtribuicoes(List<Atribuicao> atrs) {
        listaAtribuicoes.addAll(atrs);
    }

    public void setTitle(String title) {
        this.titulo = title;
    }

    public void setDescription(String description) {
        this.descricao = description;
    }

    public void setLocal(String local) {
        this.local = new Local(local);
    }

    public void setDataInicioRealizacao(Data dataInicioRealizacao) {
        this.dataInicio = dataInicioRealizacao;
    }

    public void setDataFimRealizacao(Data dataFimRealizacao) {
        this.dataFim = dataFimRealizacao;
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
        return !(this.titulo.equalsIgnoreCase("")
                || this.descricao.equalsIgnoreCase("")
                || this.dataInicio == null
                || this.dataFim == null
                || this.dataInicioSubmissao == null
                || this.dataFimSubmissao == null
                || this.local.valida()
                || !listaFAE.valida()
                || !listaOrganizadores.valida());
    }

    @Override
    public String toString() {
        return "\nExposicao{" + "title=" + titulo + ", description=" + descricao
                + ", local=" + local + ", dataInicioRealizacao=" + dataInicio
                + ", dataFimRealizacao=" + dataFim + ", dataInicioSubmissao="
                + dataInicioSubmissao + ", dataFimSubmissao=" + dataFimSubmissao + ", \nlistaOrganizadores="
                + listaOrganizadores + ", \nlistaFAE=" + listaFAE + ", \nlistaDemonstracoes="
                + listaDemonstracoes + '}';
    }

}
