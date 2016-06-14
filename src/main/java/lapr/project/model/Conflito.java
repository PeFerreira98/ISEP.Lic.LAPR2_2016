/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.users.FAE;

/**
 *
 * @author Sara Silva
 */
public class Conflito {

    private Candidatura candidatura;
    private FAE fae;
    private String tipoConflito;

    public Conflito(String tipoConflito) {
        this.tipoConflito = tipoConflito;

    }

    public String getTipoConflito() {
        return tipoConflito;
    }

    public void setTipoConflito(String tipoConflito) {
        this.tipoConflito = tipoConflito;
    }

    public boolean valida() {
        return candidatura.valida() && fae != null && !tipoConflito.isEmpty();
    }

}
