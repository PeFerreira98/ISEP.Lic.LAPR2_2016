/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author Sara Silva
 */
public class Produto {

    private String descricao;

    public Produto(String designacao) {
        this.descricao = designacao;
    }

    /**
     * @return the designacao
     */
    public String getDescricao() {
        return descricao;
    }

    
    public static boolean validaDesignacao(String designacao){
        return !(designacao == null || designacao.isEmpty());
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Produto other = (Produto) obj;
        return Objects.equals(this.descricao, other.descricao);
    }

    @Override
    public String toString() {
        return "\nProduto{" + "produto=" + descricao + '}';
    }
    
}
