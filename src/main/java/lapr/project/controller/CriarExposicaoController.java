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
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Data;

/**
 *
 * @author TiagoSilvestre
 */
public class CriarExposicaoController {

    private ListaExposicoes listaExposicoes;
    private CentroExposicoes centroExposicoes;
    private Utilizador utilizador;
    private Exposicao exposicao;
    private ListaOrganizadores listaOrganizadores;

    public boolean novaExposicao(Exposicao exposicao) {
        return listaExposicoes.addExposicao(exposicao);
    }

    public String getUtilizador() {
        centroExposicoes.getRegistoUtilizadores();
        return utilizador.getUsername();
    }

    public void addOrganizador(Utilizador utilizador) {
        listaOrganizadores.getLstOrganizadores();
        listaOrganizadores.addOrganizador(utilizador);
    }

    public boolean validaExposicao() {
        return listaExposicoes.validaExposicao(exposicao);
    }
}
