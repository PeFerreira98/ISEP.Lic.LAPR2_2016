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

    public void addExposicao() {
        Exposicao exposicao = new Exposicao();
        listaExposicoes.add(exposicao);
    }

    public List<Exposicao> getListaExposicoes() {
        return this.listaExposicoes;
    }

    public boolean validaExposicao(Exposicao exposicao) {
        return exposicao.valida();
    }
}
