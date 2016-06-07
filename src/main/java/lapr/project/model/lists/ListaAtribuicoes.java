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

    public ListaAtribuicoes() {
        this.listaAtribuicoes = new ArrayList<>();
    }

    public void addAtribuicoes(List<Atribuicao> atrs) {
        listaAtribuicoes.addAll(atrs);
    }

    public boolean addAtribuicao(Atribuicao atribuicao) {
        //procura na lista se ja existe esta atribuição
        if (!this.listaAtribuicoes.stream().noneMatch((atr) -> (atr.equals(atribuicao)))) {
            return false;
        }
        return this.listaAtribuicoes.add(atribuicao);
    }

    public List<Atribuicao> getListaAtribuicoes() {
        return listaAtribuicoes;
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

    @Override
    public String toString() {
        return "\n ListaAtribuicoes{" + "listaAtribuicoes=" + listaAtribuicoes + '}';
    }

}
