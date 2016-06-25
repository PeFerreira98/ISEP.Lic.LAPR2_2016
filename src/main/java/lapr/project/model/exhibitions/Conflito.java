/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.io.Serializable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.util.Objects;

/**
 *
 * @author Sara Silva
 */
public class Conflito implements Exportable, Serializable {

    private static final String ROOT_ELEMENT_NAME = "conflito";

    private Candidatura candidatura;
    private FAE fae;
    private TipoConflito tipoConflito;

    public Conflito(FAE fae, Candidatura candidatura, TipoConflito tipoConflito) {
        this.fae = fae;
        this.candidatura = candidatura;
        this.tipoConflito = tipoConflito;
    }

    public Conflito(FAE fae, Candidatura candidatura) {
        this.fae = fae;
        this.candidatura = candidatura;
        this.tipoConflito = new TipoConflito("SemDescricao");
    }

    public boolean isFrom(Candidatura candidatura) {
        return this.candidatura.equals(candidatura);
    }

    public String toStringList() {
        return this.fae.getUtilizador().getUsername() + " - " + this.candidatura.getNomeEmpresa() + " - " + this.tipoConflito.getDescricao();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Conflito) {
            Conflito c = (Conflito) obj;
            return this.fae.equals(c.fae) && this.candidatura.equals(c.candidatura) && this.tipoConflito.equals(c.tipoConflito);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.candidatura);
        hash = 29 * hash + Objects.hashCode(this.fae);
        hash = 29 * hash + Objects.hashCode(this.tipoConflito);
        return hash;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementConflito = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element
            Node faeNode = this.fae.exportContentToXMLNode();
            elementConflito.appendChild(document.importNode(faeNode, true));

            //Create a sub-element
            Node candNode = this.candidatura.exportContentToXMLNode();
            elementConflito.appendChild(document.importNode(candNode, true));

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementConflito);
            node = elementConflito;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

}
