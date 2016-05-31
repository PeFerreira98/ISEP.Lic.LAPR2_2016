/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class RegistoUtilizadores implements Exportable, Importable {

    private List<Utilizador> listaUtilizadores;
    private List<Utilizador> listaUtilizadoresNaoConfirmados;

    public RegistoUtilizadores() {
        this.listaUtilizadores = new ArrayList<Utilizador>();
        this.listaUtilizadoresNaoConfirmados = new ArrayList<Utilizador>();
    }

    public String listaUtilizadoresToString() {
        StringBuilder s = new StringBuilder();
        for (Utilizador u : listaUtilizadores) {
            s.append(u);
            s.append("\n");
        }
        return s.toString();
    }

    public List<Utilizador> getListaParaFAE() {
        return listaUtilizadores;
    }

    public Utilizador getUtilizador(String id) {
        for (Utilizador ut : listaUtilizadores) {
            if (ut.getUserName().equals(id)) {
                return ut;
            }
        }
        for (Utilizador ut : listaUtilizadoresNaoConfirmados) {
            if (ut.getUserName().equals(id)) {
                return ut;
            }
        }
        return null;
    }

    public boolean addUtilizador(Utilizador utilizador) {
        return listaUtilizadoresNaoConfirmados.add(utilizador);
    }

    public Utilizador novoUtilizador() {
        return new Utilizador();
    }

    public boolean validaUtilizador(Utilizador utilizador) {
        return utilizador.valida();
    }

    public boolean registaUtilizador(Utilizador utilizador) {
        if (validaUtilizador(utilizador)) {
            return addUtilizador(utilizador);
        }
        return false;
    }

    public boolean Confirmar(String id) {
        Utilizador ut = getUtilizador(id);
        boolean add = listaUtilizadores.add(ut);
        boolean remove = listaUtilizadoresNaoConfirmados.remove(ut);
        return add && remove;

    }

    @Override
    public Node exportContentToXMLNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Exportable importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
