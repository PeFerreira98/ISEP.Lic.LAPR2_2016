/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.utilizador;

import lapr.project.model.states.EstadoUtilizador;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author zero_
 */
public class EstadoUtilizadorRegistado implements EstadoUtilizador {

    private Utilizador utilizador;
    
    public EstadoUtilizadorRegistado(Utilizador utilizador){
        this.utilizador = utilizador;
    }
    
    @Override
    public boolean setPending() {
        return false;
    }

    @Override
    public boolean setRegistado() {
        return false;
    }

    @Override
    public boolean isPending() {
        return false;
    }

    @Override
    public boolean isRegistado() {
        return true;
    }

}
