/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.submissions.Avaliacao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Retiravel;
import lapr.project.model.users.FAE;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Sara Silva
 */
public class ListaCandidaturas implements Exportable, Serializable {

    private static final String ROOT_ELEMENT_NAME = "listaCandidaturas";
    private static final String CAND_ELEMENT_NAME = "candidaturas";

    private List<Candidatura> listCandidaturas;

    public ListaCandidaturas() {
        this.listCandidaturas = new ArrayList<>();
    }

    public boolean registaCandidatura(Candidatura candidatura) {
        if (validaCandidatura(candidatura)) {
            return addCandidatura(candidatura);
        } else {
            return false;
        }
    }

    private boolean addCandidatura(Candidatura candidatura) {

        //procura na lista se ja existe esta cand
        for (Candidatura c : this.listCandidaturas) {
            if (c.equals(candidatura)) {
                return false;
            }
        }
        return this.listCandidaturas.add(candidatura);
    }

    private boolean validaCandidatura(Candidatura candidatura) {
        return candidatura.valida() && !listCandidaturas.contains(candidatura);
    }

    public Candidatura novaCandidatura() {
        return new Candidatura();
    }

    public List<Candidatura> getListaCandidaturas() {
        return listCandidaturas;
    }

    public List<Retiravel> getCandidaturasRetiraveis() {
        List<Retiravel> lRetiraveis = new ArrayList<>();
        for (Candidatura c : this.listCandidaturas) {
            if (c.isRetiravel()) {
                lRetiraveis.add(c);
            }
        }
        return lRetiraveis;
    }
    
    public void getAllSubFAE(FAE fae, List<Avaliacao> listSubFAEFinal) {
        for (Candidatura cand : this.listCandidaturas) {
            cand.getAllSubFAE(fae, listSubFAEFinal);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.listCandidaturas);
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
        final ListaCandidaturas other = (ListaCandidaturas) obj;
        if (!Objects.equals(this.listCandidaturas, other.listCandidaturas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n ListaCandidaturas{" + "listaCandidaturas=" + listCandidaturas + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaCandidaturas = document.createElement(ROOT_ELEMENT_NAME);

            //TODO: Create a sub-element //iterate over keywords
            Element elementCandidaturas = document.createElement(CAND_ELEMENT_NAME);
            elementListaCandidaturas.appendChild(elementCandidaturas);
            for (Candidatura candidatura : getListaCandidaturas()) {
                Node candiNode = candidatura.exportContentToXMLNode();
                elementCandidaturas.appendChild(document.importNode(candiNode, true));
            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaCandidaturas);
            node = elementListaCandidaturas;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

}
