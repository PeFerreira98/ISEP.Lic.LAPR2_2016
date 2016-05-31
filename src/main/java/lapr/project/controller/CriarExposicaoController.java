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
    
    private Exposicao exposicao;
    private CentroExposicoes centroExposicoes;
    private ListaExposicoes lstExposicoes;
    private Utilizador utilizador;
    private ListaOrganizadores lstOrganizadores;
    
    public ListaExposicoes novaExposicao() {
        lstExposicoes.getListaExposicoes();
        lstExposicoes.addExposicao();
        return lstExposicoes;
    }
    
    public void setDados(String titulo, String descricao, Data dataInicioRealizacao, Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao, String local) {
        exposicao.setTitle(titulo);
        exposicao.setDescription(descricao);
        exposicao.setDataInicioRealizacao(dataInicioRealizacao);
        exposicao.setDataFimRealizacao(dataFimRealizacao);
        exposicao.setDataInicioSubmissao(dataInicioSubmissao);
        exposicao.setDataFimSubmissao(dataFimSubmissao);
        exposicao.setLocal(local);
    }
    
    public String getUtilizador() {
        centroExposicoes.getLstUtilizadores();
        return utilizador.getUsername();
    }
    
    public void addOrganizador(Utilizador utilizador) {
        lstOrganizadores.getLstOrganizadores();
        lstOrganizadores.addOrganizador(utilizador);
    }
    
    public boolean validaExposicao() {
        return lstExposicoes.validaExposicao(exposicao);
    }
}
