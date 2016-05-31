/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.TipoUtilizador;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author zero_
 */
public class DefinirFAEController {
    
    ListaFAE listaFAE;
    
    public DefinirFAEController(ListaFAE listaFAE){
        this.listaFAE = listaFAE;
    }
    
    public FAE addFAE(Utilizador utilizador){
        if (utilizador == null) return null;
        
        final FAE fae = new FAE(utilizador);
        
        if (listaFAE.addFAE(fae) != null) {
            utilizador.setTipoUtilizador(TipoUtilizador.FAE);
        }
        return null;
    }
    
}
