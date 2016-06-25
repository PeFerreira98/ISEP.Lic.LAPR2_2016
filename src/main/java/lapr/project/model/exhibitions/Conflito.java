/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.io.Serializable;
import java.util.Objects;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;

/**
 *
 * @author Sara Silva
 */
public class Conflito implements Serializable {

    private Candidatura candidatura;
    private FAE fae;
    private TipoConflito tipoConflito;

    public Conflito(FAE fae, Candidatura candidatura, TipoConflito tipoConflito) {
        this.fae = fae;
        this.candidatura = candidatura;
        this.tipoConflito = tipoConflito;
    }

    public Conflito(FAE fae, Candidatura candidatura) {
        this.fae = fae;
        this.candidatura = candidatura;
        this.tipoConflito = new TipoConflito("SemDescricao");
    }

    public boolean isFrom(Candidatura candidatura) {
        return this.candidatura.equals(candidatura);
    }

    public String toStringList() {
        return this.fae.getUtilizador().getUsername() + " - " + this.candidatura.getNomeEmpresa() + " - " + this.tipoConflito.getDescricao();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Conflito) {
            Conflito c = (Conflito) obj;
            return this.fae.equals(c.fae) && this.candidatura.equals(c.candidatura) && this.tipoConflito.equals(c.tipoConflito);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.candidatura);
        hash = 29 * hash + Objects.hashCode(this.fae);
        hash = 29 * hash + Objects.hashCode(this.tipoConflito);
        return hash;
    }

}
