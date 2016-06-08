/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

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
 * @author TiagoSilvestre
 */
public class FAE implements Exportable, Importable<FAE> {

    private static final String ROOT_ELEMENT_NAME = "FAE";

    private Utilizador utilizador;

    /**
     * Construtor de objecto FAE (Funcionário de Apoio à Exposição)
     *
     * @param utilizador
     */
    public FAE(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public FAE() {
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.utilizador);
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

        final FAE other = (FAE) obj;
        if (!Objects.equals(this.utilizador, other.utilizador)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "\nFAE{" + "utilizador=" + utilizador + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node rootNode = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementFAE = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element
            Node utilizadorNode = this.utilizador.exportContentToXMLNode();
            elementFAE.appendChild(document.importNode(utilizadorNode, true));

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementFAE);
            rootNode = elementFAE;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rootNode;
    }

    @Override
    public FAE importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
