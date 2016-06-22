/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import java.io.Serializable;
import java.util.Objects;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;

/**
 *
 * @author Sara Silva
 */
public class Atribuicao implements Serializable {

    private FAE fae;
    private Candidatura candidatura;

    public Atribuicao(FAE f, Candidatura c) {
        this.fae = f;
        this.candidatura = c;
    }
    
    public Atribuicao(FAE fae){
        this.fae = fae;
        //used in XML Don't know about candidatura
    }

    /**
     * @return the fae
     */
    public FAE getFae() {
        return fae;
    }

    public Candidatura getCandidatura() {
        return this.candidatura;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.fae);
        hash = 61 * hash + Objects.hashCode(this.candidatura);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atribuicao other = (Atribuicao) obj;
        if (!Objects.equals(this.fae, other.fae)) {
            return false;
        }
        if (!Objects.equals(this.candidatura, other.candidatura)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n Atribuicao{" + "fae=" + fae + ", candidatura=" + candidatura + '}';
    }

}
