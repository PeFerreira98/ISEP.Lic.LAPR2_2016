/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Retiravel;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.listCandidaturas);
        return hash;
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
        final ListaCandidaturas other = (ListaCandidaturas) obj;
        if (!Objects.equals(this.listCandidaturas, other.listCandidaturas)) {
            return false;
        }
        return true;
    }

}
