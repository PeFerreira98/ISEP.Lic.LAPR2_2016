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

    public boolean addAtribuicoes(List<Atribuicao> atrs) {
        return listaAtribuicoes.addAll(atrs);
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

    @Override
    public String toString() {
        return "\n ListaAtribuicoes{" + "\t listaAtribuicoes=" + listaAtribuicoes + '}';
    }

}
