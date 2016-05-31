/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author zero_
 */
public class ListaUtilizadores {

    private List<Utilizador> listaUtilizadores;

    public ListaUtilizadores() {
        listaUtilizadores = new ArrayList<>();
    }

    public void addUtilizador(Utilizador utilizador) {
        listaUtilizadores.add(utilizador);
    }

    public Utilizador checkUtilizadorByUsername(String username) {
        for (Utilizador u : listaUtilizadores) {
            if (u.validateUsername(username)) {
                return u;
            }
        }
        return null;
    }

    public List<Utilizador> getListaUtilizadores() {
        return this.listaUtilizadores;
    }

    @Override
    public String toString() {
        return "\nListaUtilizadores{" + "listaUtilizadores=" + listaUtilizadores + '}';
    }
    
}
