/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.users.FAE;

/**
 *
 * @author zero_
 */
public class ListaDemonstracoes {

    private List<Demonstracao> listaDemonstracoes;

    public ListaDemonstracoes() {
        listaDemonstracoes = new ArrayList<>();
    }

    public boolean addDemonstracao(Demonstracao demonstracao) {

        //Verificação de ja existe esta Demonstracao
        if (!listaDemonstracoes.stream().noneMatch((d) -> (d.equals(demonstracao)))) {
            return false;
        }

        return this.listaDemonstracoes.add(demonstracao);
    }

    public List<Demonstracao> getListaDemonstracoes() {
        return this.listaDemonstracoes;
    }

    @Override
    public String toString() {
        return "\nListaDemonstracoes{" + "listaDemonstracoes=" + listaDemonstracoes + '}';
    }

}
