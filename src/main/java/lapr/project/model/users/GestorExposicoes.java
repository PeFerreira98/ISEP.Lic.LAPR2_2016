/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

import java.util.Objects;

/**
 *
 * @author zero_
 */
public class GestorExposicoes {

    private Utilizador utilizador;

    /**
     * Construtor de objecto FAE (Funcionário de Apoio à Exposição)
     *
     * @param utilizador
     */
    public GestorExposicoes(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.utilizador);
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
        
        final GestorExposicoes other = (GestorExposicoes) obj;
        if (!Objects.equals(this.utilizador, other.utilizador)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "\n GestorExposicoes{" + "utilizador=" + utilizador + '}';
    }

}
