/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Sara Silva
 */
public class ConfirmarRegistoController {

    private final CentroExposicoes m_centro_exposicoes;
    private Utilizador utilizador;

    public ConfirmarRegistoController(CentroExposicoes centro_exposicoes) {
        m_centro_exposicoes = centro_exposicoes;
    }

    public List<Utilizador> getListUtNaoConfirmado() {
        return m_centro_exposicoes.getRegistoUt().getListaUtilizadoresNaoRegistados();
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public String utilizadorToString() {
        return utilizador.toString();
    }

    public void confirmaUtilizador() {
        m_centro_exposicoes.getRegistoUt().registarUtilizador(utilizador);
    }
}
