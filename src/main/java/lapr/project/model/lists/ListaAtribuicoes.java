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

    private List<Atribuicao> listAtribuicoes;

    public ListaAtribuicoes() {
        this.listAtribuicoes = new ArrayList<>();
    }

    public boolean addAtribuicoes(List<Atribuicao> atrs) {
        return listAtribuicoes.addAll(atrs);
    }

    public boolean addAtribuicao(Atribuicao atribuicao) {

        //procura na lista se ja existe esta atribuição
        for (Atribuicao a : this.listAtribuicoes) {
            if (a.equals(atribuicao)) {
                return false;
            }
        }
        return this.listAtribuicoes.add(atribuicao);
    }

    public List<Atribuicao> getListaAtribuicoes() {
        return listAtribuicoes;
    }

    @Override
    public String toString() {
        return "\n ListaAtribuicoes{" + "\t listaAtribuicoes=" + listAtribuicoes + '}';
    }

}
