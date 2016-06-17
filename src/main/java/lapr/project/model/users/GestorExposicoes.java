/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class GestorExposicoes implements Exportable, Importable<GestorExposicoes>, Serializable{

    private static final String ROOT_ELEMENT_NAME = "gestor";
    
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
        Node rootNode = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementGestor = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element
            Node utilizadorNode = this.utilizador.exportContentToXMLNode();
            elementGestor.appendChild(document.importNode(utilizadorNode, true));

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementGestor);
            rootNode = elementGestor;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rootNode;
    }

    @Override
    public GestorExposicoes importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
