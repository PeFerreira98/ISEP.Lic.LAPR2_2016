/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.users.Organizador;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author TiagoSilvestre
 */
public class ListaOrganizadores {

    private List<Organizador> listaOrganizador;

    public ListaOrganizadores() {
        this.listaOrganizador = new ArrayList<>();
    }

    public List<Organizador> getLstOrganizadores() {
        return this.listaOrganizador;
    }
    
    public boolean isOrganizador(Organizador org){
        for(Organizador o : this.listaOrganizador){
            if(o.equals(org)){
                return true;
            }
        }
        return false;
    }
    
    public void addOrganizador(Utilizador u) {
        Organizador org = new Organizador(u);
        if (validaOrganizador(org)) {

            listaOrganizador.add(org);
        }
    }

    public boolean validaOrganizador(Organizador organizador) {
        return organizador.valida();
    }

    public boolean valida() {
        if (listaOrganizador.isEmpty() || listaOrganizador == null) {
            return false;
        }
        return true;
    }

}
