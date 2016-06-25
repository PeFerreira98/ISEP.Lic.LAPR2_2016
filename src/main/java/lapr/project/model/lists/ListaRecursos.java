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
import lapr.project.model.Recurso;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class ListaRecursos implements Exportable, Serializable{
    
    private static final String ROOT_ELEMENT_NAME = "listaRecursos";
    private static final String RECUR_ELEMENT_NAME = "recursos";

    private final List<Recurso> listRecursos;

    public ListaRecursos() {
        this.listRecursos = new ArrayList<>();
    }

    public List<Recurso> getListaRecursos() {
        return listRecursos;
    }

    public boolean addRecurso(Recurso recurso) {
        for (Recurso r : this.listRecursos) {
            if (r.equals(recurso)) {
                return false;
            }
        }
        return listRecursos.add(recurso);
    }

    @Override
    public String toString() {
        return "\n ListaRecursos{" + "listaRecursos=" + listRecursos + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaRecursos = document.createElement(ROOT_ELEMENT_NAME);

            //TODO: Create a sub-element //iterate over keywords
            Element elementRecurso = document.createElement(RECUR_ELEMENT_NAME);
            elementListaRecursos.appendChild(elementRecurso);
            for (Recurso recurso : getListaRecursos()) {
                Node recursoNode = recurso.exportContentToXMLNode();
                elementRecurso.appendChild(document.importNode(recursoNode, true));
            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaRecursos);
            node = elementListaRecursos;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

}
