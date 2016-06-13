/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Data;

/**
 *
 * @author TiagoSilvestre
 */
public class CriarExposicaoController {

    private ListaExposicoes listaExposicoes;
    private CentroExposicoes centroExposicoes;
    private Exposicao exposicao;
    private ListaOrganizadores listaOrganizadores;

    public CriarExposicaoController() {
        this.listaExposicoes = new ListaExposicoes();
        this.centroExposicoes = new CentroExposicoes();
        this.exposicao = new Exposicao();
        this.listaOrganizadores = new ListaOrganizadores();
    }

    public boolean novaExposicao() {
        return this.listaExposicoes.addExposicao(exposicao);
    }

    public void setDados(String nomeExposicao, String descricaoExposicao, Data dataInicioRealizacao, Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao, String local) {
        exposicao.setTitle(nomeExposicao);
        exposicao.setDescription(descricaoExposicao);
        exposicao.setDataInicioRealizacao(dataInicioRealizacao);
        exposicao.setDataFimRealizacao(dataFimRealizacao);
        exposicao.setDataInicioSubmissao(dataInicioSubmissao);
        exposicao.setDataFimSubmissao(dataFimSubmissao);
        exposicao.setLocal(local);
    }

    public Utilizador getUtilizador(String username) {
        return this.getRegistoUtilizadores().checkUtilizadorByUsername(username);
    }
    
    public RegistoUtilizadores getRegistoUtilizadores(){
        return this.centroExposicoes.getRegistoUtilizadores();
    }

    public void addOrganizador(Utilizador utilizador) {
        this.listaOrganizadores.addOrganizador(utilizador);
    }

    public boolean validaExposicao() {
        return this.exposicao.valida();
    }

    public boolean registaExposicao() {
        return this.listaExposicoes.registaExposicao(exposicao);
    }
}
