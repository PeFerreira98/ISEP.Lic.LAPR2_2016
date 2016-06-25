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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class Representante implements Exportable, Serializable {

    private static final String ROOT_ELEMENT_NAME = "representante";
    
    private Utilizador utilizador;
    private String nomeEmpresa;

    /**
     * Construtor de objecto FAE (Funcionário de Apoio à Exposição)
     *
     * @param utilizador
     */
    public Representante(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Representante(Utilizador utilizador, String nEmpresa) {
        this.utilizador = utilizador;
        this.nomeEmpresa = nEmpresa;
    }

    public String getNomeEmpresa() {
        return this.nomeEmpresa;
    }

    public Utilizador getUtilizador() {
        return utilizador;
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

    @Override
    public Node exportContentToXMLNode() {
        Node rootNode = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementRep = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element
            Node utilizadorNode = this.utilizador.exportContentToXMLNode();
            elementRep.appendChild(document.importNode(utilizadorNode, true));

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementRep);
            rootNode = elementRep;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rootNode;
    }

}
