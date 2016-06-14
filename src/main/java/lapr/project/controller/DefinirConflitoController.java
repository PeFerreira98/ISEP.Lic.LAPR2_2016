/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.TipoConflito;
import lapr.project.model.exhibitions.CentroExposicoes;

/**
 *
 * @author Sara Silva
 */
public class DefinirConflitoController {

    private List<TipoConflito> listaTipoConflito;

    public DefinirConflitoController(CentroExposicoes centroExp) {
        listaTipoConflito = centroExp.getListaTipoConflito();
    }

    public void novoTipoConflito(String descricao) {
        TipoConflito tipoConflito = new TipoConflito(descricao);
        listaTipoConflito.add(tipoConflito);

    }

}
