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
import lapr.project.model.exhibitions.TipoConflito;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author zero_
 */
public class ListaTipoConflito implements Exportable, Importable<ListaTipoConflito>{

    private static final String ROOT_ELEMENT_NAME = "listaTipoConflito";
    private static final String TIPOCONF_ELEMENT_NAME = "tipoConflitos";
    
    private List<TipoConflito> listTipoConflito;

    public ListaTipoConflito() {
        listTipoConflito = new ArrayList<>();
    }

    public List<TipoConflito> getListaTipoConflito() {
        return this.listTipoConflito;
    }
    
    public boolean addTipoConflito(TipoConflito tipoConflito){
        return this.listTipoConflito.add(tipoConflito);
    }

    @Override
    public String toString() {
        return "\nListaTipoConflito{" + "listTipoConflito=" + listTipoConflito + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
      Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaTipoConflito = document.createElement(ROOT_ELEMENT_NAME);

            //TODO: Create a sub-element //iterate over keywords
//            Element elementTipoConflitos = document.createElement(TIPOCONF_ELEMENT_NAME);
//            elementListaTipoConflito.appendChild(elementTipoConflitos);
//            for (TipoConflito tipoConflito : getListaTipoConflito()) {
//                Node tipoConflitoNode = tipoConflito.exportContentToXMLNode();
//                elementTipoConflitos.appendChild(document.importNode(tipoConflitoNode, true));
//            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaTipoConflito);
            node = elementListaTipoConflito;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public ListaTipoConflito importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            //Create document builder //Obtain a new document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.appendChild(document.importNode(node, true));

            //Init
            NodeList nodeList1ListaTiposConflito = document.getElementsByTagName(ROOT_ELEMENT_NAME);
            Node node2listaTipos = nodeList1ListaTiposConflito.item(0);

            //TODO: Add Lista
//            NodeList nodeList3tiposConflito = document.getElementsByTagName(TIPOCONF_ELEMENT_NAME);
//            NodeList nodeList4tiposConflito = nodeList3tiposConflito.item(0).getChildNodes();
//            for (int position = 0; position < nodeList4tiposConflito.getLength(); position++) {
//                Node node5tipoConflito = nodeList4tiposConflito.item(position);
//                TipoConflito instance6TipoConfl = new TipoConflito();
//                instance6TipoConfl = instance6TipoConfl.importContentFromXMLNode(node5tipoConflito);
//                addTipoConflito(instance6TipoConfl);
//            }
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return this;
    }

}
