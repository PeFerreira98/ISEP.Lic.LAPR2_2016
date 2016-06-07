/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Candidatura;

/**
 *
 * @author Sara Silva
 */
public class ListaCandidaturas {

    private List<Candidatura> listaCandidaturas;

    public ListaCandidaturas() {
        this.listaCandidaturas = new ArrayList<>();
    }

    public boolean registaCandidatura(Candidatura candidatura) {
        if (validaCandidatura(candidatura)) {
            return addCandidatura(candidatura);
        } else {
            return false;
        }
    }

    public boolean addCandidatura(Candidatura candidatura) {
        //procura na lista se ja existe esta candidatura
        if (!this.listaCandidaturas.stream().noneMatch((can) -> (can.equals(candidatura)))) {
            return false;
        }
        return this.listaCandidaturas.add(candidatura);
    }

    private boolean validaCandidatura(Candidatura candidatura) {
        return candidatura.valida() && !listaCandidaturas.contains(candidatura);
    }

    public Candidatura novaCandidatura() {
        return new Candidatura();
    }

    public List<Candidatura> getListaCandidaturas() {
        return listaCandidaturas;
    }

    @Override
    public String toString() {
        return "\n ListaCandidaturas{" + "listaCandidaturas=" + listaCandidaturas + '}';
    }

}
