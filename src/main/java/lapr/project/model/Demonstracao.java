/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author zero_
 */
public class Demonstracao {

    //Classe incompleta. Não especificação sobre o que a Demonstracao se trata
    
    private String designacao;
    
    public Demonstracao(String designacao) {
        this.designacao = designacao;
    }
    
    public static boolean validateDesignacao(String designacao){
        return !(designacao == null || designacao.isEmpty());
    }

    public String getDesignacao() {
        return designacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.designacao);
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
        final Demonstracao other = (Demonstracao) obj;
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nDemonstracao{" + "designacao=" + designacao + '}';
    }
    
}
