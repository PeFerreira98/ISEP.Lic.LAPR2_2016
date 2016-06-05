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
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (a == null || getClass() != a.getClass()) {
            return false;
        }
        Atribuicao outraAtribuicao = (Atribuicao) a;

        return fae.equals(outraAtribuicao.fae) && avaliacao.equals(outraAtribuicao.avaliacao);
    }

    @Override
    public String toString() {
        return fae.getUtilizador().getNome() + " - " + avaliacao.getCandidatura().getNomeEmpresa();
    }

}
