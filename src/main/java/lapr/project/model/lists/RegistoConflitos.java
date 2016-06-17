/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.exhibitions.Conflito;
import lapr.project.model.users.FAE;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class RegistoConflitos implements Exportable, Importable<RegistoConflitos> {

    private static final String ROOT_ELEMENT_NAME = "registoConflitos";
    private static final String CAND_ELEMENT_NAME = "conflitos";

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
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaCandidaturas = document.createElement(ROOT_ELEMENT_NAME);

            //TODO: Create a sub-element //iterate over keywords
//            Element elementCandidaturas = document.createElement(CAND_ELEMENT_NAME);
//            elementListaCandidaturas.appendChild(elementCandidaturas);
//            for (Candidatura candidatura : getListaCandidaturas()) {
//                Node candiNode = candidatura.exportContentToXMLNode();
//                elementCandidaturas.appendChild(document.importNode(candiNode, true));
//            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaCandidaturas);
            node = elementListaCandidaturas;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public RegistoConflitos importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
