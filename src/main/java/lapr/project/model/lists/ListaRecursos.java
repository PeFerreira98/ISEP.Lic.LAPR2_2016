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

    private final List<Recurso> listRecursos;

    public ListaRecursos() {
        this.listRecursos = new ArrayList<>();
    }

    public List<Recurso> getListaRecursos() {
        return listRecursos;
    }

    public boolean addRecurso(Recurso recurso) {
        for (Recurso r : this.listRecursos) {
            if (r.equals(recurso)) {
                return false;
            }
        }
        return listRecursos.add(recurso);
    }

    @Override
    public String toString() {
        return "\n ListaRecursos{" + "listaRecursos=" + listRecursos + '}';
    }

}
