/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.util.Objects;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.RegistoUtilizadores;

/**
 *
 * @author zero_
 */
public class CentroExposicoes {

    private RegistoUtilizadores registoUtilizadores;
    private ListaExposicoes listaExposicoes;

    /**
     * Construtor de CentroExposicoes
     *
     * @param lstUtilizador a lista de utilizadores
     * @param lstExposicao a lista de exposicoes
     * @param registoExposicao o registo de exposicoes
     * @param registoCandidatura o registo de candidaturas
     * @param registoUtilizador o registo de utilizadores
     */
    public CentroExposicoes(RegistoUtilizadores registoUtilizadores, ListaExposicoes listaExposicoes) {
        this.registoUtilizadores = registoUtilizadores;
        this.listaExposicoes = listaExposicoes;
    }

    public ListaExposicoes getListaExposicoes() {
        return listaExposicoes;
    }

    public RegistoUtilizadores getRegistoUtilizadores() {
        return registoUtilizadores;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final CentroExposicoes other = (CentroExposicoes) obj;
        if (!Objects.equals(this.registoUtilizadores, other.registoUtilizadores)) {
            return false;
        }
        if (!Objects.equals(this.listaExposicoes, other.listaExposicoes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CentroExposicoes{" + "\nregistoUtilizadores=" + registoUtilizadores + ", \nlistaExposicoes=" + listaExposicoes + '}';
    }
 
}
