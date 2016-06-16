/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.TipoConflito;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.lists.ListaTipoConflito;

/**
 *
 * @author Sara Silva
 */
public class DefinirTipoConflitoController {

    private ListaTipoConflito listaTipoConflito;

    public DefinirTipoConflitoController(CentroExposicoes centroExp) {
        listaTipoConflito = centroExp.getListaTipoConflito();
    }

    public void novoTipoConflito(String descricao) {
        TipoConflito tipoConflito = new TipoConflito(descricao);
        listaTipoConflito.addTipoConflito(tipoConflito);

    }

}
