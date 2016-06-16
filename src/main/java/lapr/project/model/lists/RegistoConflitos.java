/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.exhibitions.Conflito;
import lapr.project.model.users.FAE;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class RegistoConflitos implements Exportable, Importable<RegistoConflitos> {
    
    private List<Conflito> listaConflitos;
    
    public RegistoConflitos() {
        this.listaConflitos = new ArrayList<>();
    }
    
    public boolean registarConflito(FAE fae, Candidatura candidatura) {
        Conflito conflito = new Conflito(fae, candidatura);
        return this.listaConflitos.add(conflito);
    }
    
    @Override
    public Node exportContentToXMLNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public RegistoConflitos importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
