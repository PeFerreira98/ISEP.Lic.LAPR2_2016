/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;
import lapr.project.model.users.FAE;

/**
 *
 * @author Sara Silva
 */
public class Atribuicao {

    private Avaliacao avaliacao;
    private FAE fae;

    public Atribuicao() {
    }

    /**
     * @return the fae
     */
    public FAE getFae() {
        return fae;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    /**
     * @param fae the fae to set
     */
    public void setFae(FAE fae) {
        this.fae = fae;
    }

    Avaliacao novaAvaliacao() {
        return new Avaliacao();
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
        if (!Objects.equals(this.avaliacao, other.avaliacao)) {
            return false;
        }
        if (!Objects.equals(this.fae, other.fae)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.avaliacao);
        hash = 71 * hash + Objects.hashCode(this.fae);
        return hash;
    }

    @Override
    public String toString() {
        return fae.getUtilizador().getNome() + " - " + avaliacao.getCandidatura().getNomeEmpresa();
    }

}
