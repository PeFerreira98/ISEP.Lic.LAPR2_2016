/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Recurso;

/**
 *
 * @author Sara Silva
 */
public class ListaRecursos {

    private final List<Recurso> listaRecursos;

    public ListaRecursos() {
        this.listaRecursos = new ArrayList<>();
    }

    public List<Recurso> getListaRecursos() {
        return listaRecursos;
    }

    public boolean addRecurso(Recurso recurso) {
        if (listaRecursos.stream().anyMatch((rec) -> (rec.equals(recurso)))) {
            return false;
        }
        return listaRecursos.add(recurso);
    }

    @Override
    public String toString() {
        return "\n ListaRecursos{" + "listaRecursos=" + listaRecursos + '}';
    }

}
