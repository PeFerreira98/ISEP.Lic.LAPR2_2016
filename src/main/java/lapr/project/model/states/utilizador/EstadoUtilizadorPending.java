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
public class EstadoUtilizadorPending implements EstadoUtilizador {

    private Utilizador utilizador;
    
    public EstadoUtilizadorPending(Utilizador utilizador){
        this.utilizador = utilizador;
    }
    
    @Override
    public boolean setPending() {
        return false;
    }

    @Override
    public boolean setRegistado() {
        if (this.utilizador.isPending()) {
            EstadoUtilizador eu = new EstadoUtilizadorRegistado(this.utilizador);
            this.utilizador.setEstado(eu);
            return true;
        }
        return false;
    }

    @Override
    public boolean isPending() {
        return true;
    }

    @Override
    public boolean isRegistado() {
        return false;
    }

}
