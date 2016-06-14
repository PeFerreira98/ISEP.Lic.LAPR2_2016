/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Candidatura;
import lapr.project.model.Retiravel;

/**
 *
 * @author Sara Silva
 */
public class ListaCandidaturas {

    private List<Candidatura> listCandidaturas;

    public ListaCandidaturas() {
        this.listCandidaturas = new ArrayList<>();
    }

    public boolean registaCandidatura(Candidatura candidatura) {
        if (validaCandidatura(candidatura)) {
            return addCandidatura(candidatura);
        } else {
            return false;
        }
    }

    public boolean addCandidatura(Candidatura candidatura) {

        //procura na lista se ja existe esta cand
        for (Candidatura c : this.listCandidaturas) {
            if (c.equals(candidatura)) {
                return false;
            }
        }
        return this.listCandidaturas.add(candidatura);
    }

    private boolean validaCandidatura(Candidatura candidatura) {
        return candidatura.valida() && !listCandidaturas.contains(candidatura);
    }

    public Candidatura novaCandidatura() {
        return new Candidatura();
    }

    public List<Candidatura> getListaCandidaturas() {
        return listCandidaturas;
    }
    
    public List<Retiravel> getCandidaturasRetiraveis() {
        List<Retiravel> lRetiraveis = new ArrayList<>();
        for (Candidatura c : this.listCandidaturas) {
            if (c.isRetiravel()) {
                lRetiraveis.add(c);
            }
        }
        return lRetiraveis;
    }

    @Override
    public String toString() {
        return "\n ListaCandidaturas{" + "listaCandidaturas=" + listCandidaturas + '}';
    }

}
