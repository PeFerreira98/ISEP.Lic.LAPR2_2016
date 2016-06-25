/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.exhibitions.Conflito;
import lapr.project.model.exhibitions.TipoConflito;
import lapr.project.model.users.FAE;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class RegistoConflitos implements Exportable, Serializable {

    private static final String ROOT_ELEMENT_NAME = "registoConflitos";
    private static final String CONF_ELEMENT_NAME = "conflitos";

    private List<Conflito> listaConflitos;

    public RegistoConflitos() {
        this.listaConflitos = new ArrayList<>();
    }

    public boolean registarConflito(FAE fae, Candidatura candidatura) {
        Conflito conflito = new Conflito(fae, candidatura);
        return this.listaConflitos.add(conflito);
    }
    
    public boolean registarConflito(FAE fae, Candidatura candidatura, TipoConflito tipoConflito) {
        Conflito conflito = new Conflito(fae, candidatura, tipoConflito);
        return this.listaConflitos.add(conflito);
    }
    
    public boolean deleteConflito(Conflito conflito){
        return this.listaConflitos.remove(conflito);
    }
    
    public boolean hasConflitos(){
        //Retorna true se tiver pelo menos 1 conflito
        return !this.listaConflitos.isEmpty();
    }
    
    public List<Conflito> getConflitos(Candidatura candidatura){
        List<Conflito> listConfTemp = new ArrayList<>();
        for (Conflito conf : this.listaConflitos) {
            if (conf.isFrom(candidatura)) {
                listConfTemp.add(conf);
            }
        }
        return listConfTemp;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaConflitos = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element //iterate over keywords
            Element elementConflitos = document.createElement(CONF_ELEMENT_NAME);
            elementListaConflitos.appendChild(elementConflitos);
            for (Conflito conflito : this.listaConflitos) {
                Node confNode = conflito.exportContentToXMLNode();
                elementConflitos.appendChild(document.importNode(confNode, true));
            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaConflitos);
            node = elementListaConflitos;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

}
