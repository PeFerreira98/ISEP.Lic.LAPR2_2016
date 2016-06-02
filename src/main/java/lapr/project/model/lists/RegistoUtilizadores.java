/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.ReadWriteTxtFile;

/**
 *
 * @author Sara Silva
 */
public class RegistoUtilizadores {

    private List<Utilizador> listaUtilizadoresRegistados;
    private List<Utilizador> listaUtilizadoresNaoRegistados;

    public RegistoUtilizadores() {
        this.listaUtilizadoresRegistados = new ArrayList<Utilizador>();
        this.listaUtilizadoresNaoRegistados = new ArrayList<Utilizador>();
    }

    public Utilizador checkUtilizadorByUsername(String username) {
        for (Utilizador u : listaUtilizadoresNaoRegistados) {
            if (u.validateUsername(username)) {
                return u;
            }
        }
        for (Utilizador u : listaUtilizadoresRegistados) {
            if (u.validateUsername(username)) {
                return u;
            }
        }
        return null;
    }
    
    public Utilizador checkUtilizadorByEmail(String email) {
        for (Utilizador u : listaUtilizadoresNaoRegistados) {
            if (u.validateUsername(email)) {
                return u;
            }
        }
        for (Utilizador u : listaUtilizadoresRegistados) {
            if (u.validateUsername(email)) {
                return u;
            }
        }
        return null;
    }

    public boolean addUtilizadorNaoRegistado(Utilizador utilizador) {
        for (Utilizador u : listaUtilizadoresRegistados) {
            if (u.equals(utilizador)) {
                return false;
            }
        }
        for (Utilizador u : listaUtilizadoresNaoRegistados) {
            if (u.equals(utilizador)) {
                return false;
            }
        }
        new ReadWriteTxtFile().writeFile(utilizador);
        return listaUtilizadoresNaoRegistados.add(utilizador);
    }

    public boolean registarUtilizador(Utilizador utilizador) {
        for (Utilizador u : listaUtilizadoresNaoRegistados) {
            if (u.equals(utilizador)) {
                return registo(utilizador);
            }
        }
        return false;
    }

    private boolean registo(Utilizador utilizador) {
        if (listaUtilizadoresNaoRegistados.remove(utilizador)) {
            utilizador.setRegistado();
            return listaUtilizadoresRegistados.add(utilizador);
        }
        return false;
    }

    public List<Utilizador> getListaUtilizadoresNaoRegistados() {
        return this.listaUtilizadoresNaoRegistados;
    }

    public List<Utilizador> getListaUtilizadoresRegistados() {
        return this.listaUtilizadoresRegistados;
    }

    @Override
    public String toString() {
        return "\nRegistoUtilizadores{" + "listaUtilizadoresRegistados=" + listaUtilizadoresRegistados + ", \n\tlistaUtilizadoresNaoRegistados=" + listaUtilizadoresNaoRegistados + '}';
    }

}
