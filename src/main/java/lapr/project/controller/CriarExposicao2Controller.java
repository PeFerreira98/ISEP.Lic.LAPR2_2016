/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.users.GestorExposicoes;
import lapr.project.model.users.Organizador;
import lapr.project.utils.Data;

/**
 *
 * @author TiagoSilvestre
 */
public class CriarExposicao2Controller {

    private CentroExposicoes centroExposicoes;
    private Exposicao exposicao;

    public CriarExposicao2Controller(CentroExposicoes centroExpo) {
        this.centroExposicoes = centroExpo;
        this.exposicao = new Exposicao();
    }

    public Data convertStringToData(String data) {
        final Data d;

        String[] aux = data.split("-");
        int dia = Integer.parseInt(aux[0]);
        int mes = Integer.parseInt(aux[1]);
        int ano = Integer.parseInt(aux[2]);

        d = new Data(ano, mes, dia);

        return d;
    }

    public void addListaOrganizador(ListaOrganizadores lst) {
        if (lst.getLstOrganizadores().isEmpty()) {
            return;
        }
        for (Organizador o : lst.getLstOrganizadores()) {
            this.exposicao.getListaOrganizadores().getLstOrganizadores().add(o);
        }
    }

    public void addGestor(GestorExposicoes g) {
        this.exposicao.setGestor(g);
    }

    public void criarExpo(String titulo, String desc, String local, Data dataInicioRealizacao, Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao) {
        this.exposicao = new Exposicao(titulo, desc, dataInicioRealizacao, dataFimRealizacao, dataInicioSubmissao, dataFimSubmissao, local);
        addExpo(exposicao);
    }

    private void addExpo(Exposicao expo) {
        this.centroExposicoes.getListaExposicoes().addExposicao(expo);
    }

}
