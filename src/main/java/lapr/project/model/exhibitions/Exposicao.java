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
import lapr.project.model.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.Local;
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
    private Date dataInicio;
    private Date dataFim;
    private Local local;
    private Data dataInicioSubmissao;
    private Data dataFimSubmissao;
    private ListaOrganizadores listaOrganizadores;
    private ListaFAE listaFAE;
    private List<Demonstracao> listaDemonstracoes;
    private List<Atribuicao> listaAtribuicoes;
    private List<Candidatura> listaCandidaturas;

    public Exposicao(String titulo, String descricao, Date converterParaData, Date converterParaData0, Data dataInicioSubmissao, Data dataFimSubmissao, String local, ListaOrganizadores listaOrganizadores, ListaFAE listaFAE, List<Demonstracao> listaDemonstracao, List<Candidatura> listaCandidaturas, List<Atribuicao> listaAtribuicao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = converterParaData;
        this.dataFim = converterParaData0;
        this.dataInicioSubmissao = dataInicioSubmissao;
        this.dataFimSubmissao = dataFimSubmissao;
        this.local = new Local(local);
        this.listaOrganizadores = listaOrganizadores;
        this.listaCandidaturas = listaCandidaturas;
        listaDemonstracoes = listaDemonstracao;
        listaAtribuicoes = listaAtribuicao;
        this.listaFAE = listaFAE;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public List<Demonstracao> getListaDemonstracoes() {
        return listaDemonstracoes;
    }

    public List<Organizador> getListaOrganizadores() {
        return listaOrganizadores.getLstOrganizadores();
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
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Date dataFim) {
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

    public List<FAE> getListaFAE() {
        return listaFAE.getListaFAE();
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

    public List<Demonstracao> getDemonstracoes() {
        return listaDemonstracoes;
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

    @Override
    public String toString() {
        return titulo;
    }

}
