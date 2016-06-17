/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.organizador;

import java.io.Serializable;
import java.util.List;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author zero_
 */
public class DefinirFAEController implements Serializable{

    private RegistoUtilizadores registoUtilizadores;
    private ListaFAE listaFAE;

    public DefinirFAEController(RegistoUtilizadores registoUtilizadores, Exposicao exposicao) {
        this.registoUtilizadores = registoUtilizadores;
        this.listaFAE = exposicao.getListaFAE();
    }

    public boolean addUtilizadorListaFAE(Utilizador utilizador) {
        final FAE fae = new FAE(utilizador);
        return this.listaFAE.addFAE(fae);
    }

    public List<Utilizador> getListaUtilizadoresRegistados() {
        return this.registoUtilizadores.getListaUtilizadoresRegistados();
    }

}
