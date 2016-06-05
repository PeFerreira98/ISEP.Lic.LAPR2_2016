/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.exhibitions.Exposicao;

/**
 *
 * @author Marcos
 */
public class ListaExposicoes {

    private List<Exposicao> listaExposicoes;

    public ListaExposicoes() {
        listaExposicoes = new ArrayList<>();
    }

    public boolean addExposicao(Exposicao exposicao) {
        for (Exposicao e : listaExposicoes) {
            if (e.equals(exposicao)) {
                return false;
            }
        }
        return listaExposicoes.add(exposicao);
    }

    public void setListaExposicoes(List<Exposicao> lst) {
        this.listaExposicoes = lst;
    }

    public List<Exposicao> getListaExposicoes() {
        return this.listaExposicoes;
    }

    public List<Exposicao> getListaExpOrg(String id) {
        List<Exposicao> ex = new ArrayList<>();
        for (Exposicao e : listaExposicoes) {
            if (e.hasOrg(id)) {
                ex.add(e);
            }
        }
        return ex;
    }

    public List<Exposicao> getListaExpFAE(String id) {
        List<Exposicao> ex = new ArrayList<>();
        for (Exposicao e : listaExposicoes) {
            if (e.hasFAE(id)) {
                ex.add(e);
            }
        }
        return ex;
    }

    @Override
    public String toString() {
        return "\nListaExposicoes{" + "listaExposicoes=" + listaExposicoes + '}';
    }

    public boolean validaExposicao(Exposicao exposicao) {
        return !listaExposicoes.isEmpty();
    }
}
