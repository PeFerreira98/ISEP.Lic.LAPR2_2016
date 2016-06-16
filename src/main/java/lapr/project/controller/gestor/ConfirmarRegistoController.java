/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.gestor;

import java.util.List;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Sara Silva
 */
public class ConfirmarRegistoController {

    private final CentroExposicoes centroExposicoes;
    private Utilizador utilizador;

    public ConfirmarRegistoController(CentroExposicoes centroExposicoes) {
        this.centroExposicoes = centroExposicoes;
    }

    public List<Utilizador> getListUtNaoConfirmado() {
        return this.centroExposicoes.getRegistoUtilizadores().getListaUtilizadoresNaoRegistados();
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public String utilizadorToString() {
        return this.utilizador.toString();
    }

    public void confirmaUtilizador() {
        this.centroExposicoes.getRegistoUtilizadores().registarUtilizador(utilizador);
    }
}
