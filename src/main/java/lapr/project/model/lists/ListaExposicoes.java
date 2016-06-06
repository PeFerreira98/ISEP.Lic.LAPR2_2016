/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Node;

/**
 *
 * @author Marcos
 */
public class ListaExposicoes implements Exportable, Importable<ListaExposicoes>{

    private List<Exposicao> listaExposicoes;

    public ListaExposicoes() {
        listaExposicoes = new ArrayList<>();
    }

    public boolean addExposicao(Exposicao exposicao) {
        if (!listaExposicoes.stream().noneMatch((e) -> (e.equals(exposicao)))) {
            return false;
        }
        return listaExposicoes.add(exposicao);
    }

    public void setListaExposicoes(List<Exposicao> lst) {
        this.listaExposicoes = lst;
    }

    public List<Exposicao> getListaExposicoes() {
        return this.listaExposicoes;
    }

    public boolean validaExposicao(Exposicao exposicao) {
        return exposicao.valida();
    }

    public boolean registaExposicao(Exposicao exposicao) {
        if (validaExposicao(exposicao) == true) {
            return this.listaExposicoes.add(exposicao);
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nListaExposicoes{" + "listaExposicoes=" + listaExposicoes + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListaExposicoes importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
