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
import lapr.project.model.users.FAE;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class ListaFAE implements Exportable, Importable<ListaFAE> {

    private static final String ROOT_ELEMENT_NAME = "listaFAE";
    private static final String FAE_LST_ELEMENT_NAME = "FAEs";
    
    private List<FAE> listaFAE;

    public ListaFAE() {
        listaFAE = new ArrayList<>();
    }

    public boolean addFAE(FAE fae) {

        //Verificação de ja existe este FAE
        if (!listaFAE.stream().noneMatch((f) -> (f.equals(fae)))) {
            return false;
        }

        return this.listaFAE.add(fae);
    }

    public List<FAE> getListaFAE() {
        return this.listaFAE;
    }

    public boolean valida() {
        return !(listaFAE.isEmpty() || listaFAE == null);
    }

    @Override
    public String toString() {
        return "\nListaFAE{" + "listaFAE=" + listaFAE + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaFAE = document.createElement(ROOT_ELEMENT_NAME);

            
            //Create a sub-element //iterate over keywords
            Element elementFAEs = document.createElement(FAE_LST_ELEMENT_NAME);
            elementListaFAE.appendChild(elementFAEs);
            for (FAE fae : getListaFAE()) {
                Node faeNode = fae.exportContentToXMLNode();
                elementFAEs.appendChild(document.importNode(faeNode, true));
            }

            
            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaFAE);
            node = elementListaFAE;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public ListaFAE importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
