/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Atribuicao;

/**
 *
 * @author Sara Silva
 */
public class ListaAtribuicoes {

    private List<Atribuicao> listaAtribuicoes;

    public void addAtribuicoes(List<Atribuicao> atrs) {
        listaAtribuicoes.addAll(atrs);
    }

    public List<Atribuicao> getListaAtribuicoes() {
        return listaAtribuicoes;
    }

    public Atribuicao novaAtribuicao() {
        return new Atribuicao();
    }

    public List<Atribuicao> getAtribuicoes(String id) {
        List<Atribuicao> atr = new ArrayList<>();
        for (Atribuicao at : listaAtribuicoes) {
            if (at.getFae().getUtilizador().getUsername().equals(id)) {
                atr.add(at);
            }
        }
        return atr;
    }

    public void addAtribuicao(Atribuicao a) {
        listaAtribuicoes.add(a);
    }

}
