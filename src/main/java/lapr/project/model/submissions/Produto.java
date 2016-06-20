/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author zero_
 */
public class Produto implements Serializable{

    //Classe incompleta. Não especificação sobre o que o produto se trata
    
    private String designacao;
    
    public Produto(String designacao) {
        this.designacao = designacao;
    }
    
    public static boolean validaDesignacao(String designacao){
        return !(designacao == null || designacao.isEmpty());
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.designacao);
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
        
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        
        return true;
    }

    

    @Override
    public String toString() {
        return designacao;
    }
    
}
