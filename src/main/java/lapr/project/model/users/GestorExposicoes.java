/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

import java.util.Objects;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class GestorExposicoes implements Exportable, Importable<GestorExposicoes>{

    private Utilizador utilizador;

    /**
     * Construtor de objecto Gestor
     *
     * @param utilizador
     */
    public GestorExposicoes(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
    
    public Utilizador getUtilizador() {
        return utilizador;
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

    @Override
    public Node exportContentToXMLNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GestorExposicoes importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
