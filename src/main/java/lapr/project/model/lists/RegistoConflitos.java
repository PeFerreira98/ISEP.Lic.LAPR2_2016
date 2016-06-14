/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Conflito;

/**
 *
 * @author Sara Silva
 */
public class RegistoConflitos {

    private List<Conflito> listaConflitos;

    public RegistoConflitos() {
        this.listaConflitos = new ArrayList<Conflito>();
    }

    public Conflito novoConflito(String descricao) {
        return new Conflito(descricao);
    }

    public boolean addConflito(Conflito c) {
        return listaConflitos.add(c);
    }

    public boolean registaConflito(Conflito conflito) {
        if (validaConflito(conflito)) {
            return addConflito(conflito);
        } else {
            return false;
        }
    }

    private boolean validaConflito(Conflito conflito) {
        return conflito.valida() && !listaConflitos.contains(conflito);
    }

}
