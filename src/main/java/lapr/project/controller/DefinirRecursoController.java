/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Recurso;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.lists.ListaRecursos;

/**
 *
 * @author Sara Silva
 */
public class DefinirRecursoController {

    private ListaRecursos listaRecursos;

    public DefinirRecursoController(CentroExposicoes centroExp) {
        listaRecursos = centroExp.getListaRecursos();
    }
    
    public void addRecurso(String rec) {
        listaRecursos.addRecurso(new Recurso(rec));
    }

}
