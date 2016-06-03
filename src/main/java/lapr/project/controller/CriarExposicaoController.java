/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

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

    public boolean novaExposicao(Exposicao exposicao) {
        return listaExposicoes.addExposicao(exposicao);
    }
    
    public void setDados(String nomeExposicao, String descricaoExposicao, Data dataInicioRealizacao, Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao, String local, ListaFAE listaFAE){
        exposicao.setTitle(nomeExposicao);
        exposicao.setDescription(descricaoExposicao);
        exposicao.setDataInicioRealizacao(dataInicioRealizacao);
        exposicao.setDataFimRealizacao(dataFimRealizacao);
        exposicao.setDataInicioSubmissao(dataInicioSubmissao);
        exposicao.setDataFimSubmissao(dataFimSubmissao);
        exposicao.setListaOrganizadores(listaOrganizadores);
        exposicao.setListaFAE(listaFAE);
    }

    public Utilizador getUtilizador() {
        centroExposicoes.getRegistoUtilizadores();
        return registoUtilizadores.checkUtilizadorByUsername(utilizador.getUsername());
    }

    public void addOrganizador(Utilizador utilizador) {
        listaOrganizadores.getLstOrganizadores();
        listaOrganizadores.addOrganizador(utilizador);
    }

    public boolean validaExposicao() {
        return listaExposicoes.validaExposicao(exposicao);
    }
    
    public boolean registaExposicao(){
        return listaExposicoes.registaExposicao(exposicao);
    }
}
