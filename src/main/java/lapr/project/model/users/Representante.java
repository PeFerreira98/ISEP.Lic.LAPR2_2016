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
public class Representante {

    private Utilizador utilizador;

    /**
     * Construtor de objecto FAE (Funcionário de Apoio à Exposição)
     *
     * @param utilizador
     */
    public Representante(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.utilizador);
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

        final Representante other = (Representante) obj;
        if (!Objects.equals(this.utilizador, other.utilizador)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "\n Representante{" + "utilizador=" + utilizador + '}';
    }

}
