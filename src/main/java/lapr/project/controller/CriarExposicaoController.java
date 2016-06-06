/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaFAE;
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
    private RegistoUtilizadores registoUtilizadores;
    private Utilizador utilizador;
    private Exposicao exposicao;
    private ListaOrganizadores listaOrganizadores;

    public CriarExposicaoController() {
        this.listaExposicoes = new ListaExposicoes();
        this.centroExposicoes = new CentroExposicoes();
        this.registoUtilizadores = new RegistoUtilizadores();
        this.utilizador = new Utilizador();
        this.exposicao = new Exposicao();
        this.listaOrganizadores = new ListaOrganizadores();
    }

    public boolean novaExposicao(Exposicao exposicao) {
        return listaExposicoes.addExposicao(exposicao);
    }

    public void setDados(String nomeExposicao, String descricaoExposicao, Data dataInicioRealizacao, Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao, String local, ListaOrganizadores listaOrganizadores, ListaFAE listaFAE) {
        exposicao.setTitle(nomeExposicao);
        exposicao.setDescription(descricaoExposicao);
        exposicao.setDataInicioRealizacao(dataInicioRealizacao);
        exposicao.setDataFimRealizacao(dataFimRealizacao);
        exposicao.setDataInicioSubmissao(dataInicioSubmissao);
        exposicao.setDataFimSubmissao(dataFimSubmissao);
        exposicao.setListaOrganizadores(listaOrganizadores);
        exposicao.setListaFAE(listaFAE);
    }

    public Utilizador getUtilizador(String username) {
        return registoUtilizadores.checkUtilizadorByUsername(username);
    }

    public void addOrganizador(Utilizador utilizador) {
        listaOrganizadores.addOrganizador(utilizador);
    }

    public boolean validaExposicao() {
        if (listaExposicoes.validaExposicao(exposicao) == true) {
            return true;
        }
        return false;
    }

    public boolean registaExposicao() {
        return listaExposicoes.registaExposicao(exposicao);
    }
}
