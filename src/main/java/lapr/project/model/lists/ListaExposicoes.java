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
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Marcos
 */
public class ListaExposicoes implements Exportable, Importable<ListaExposicoes> {

    private static final String ROOT_ELEMENT_NAME = "listaExposicoes";
    private static final String EXPO_ELEMENT_NAME = "exposicoes";
    
    private List<Exposicao> listaExposicoes;

    public ListaExposicoes() {
        listaExposicoes = new ArrayList<>();
    }

    public boolean addExposicao(Exposicao exposicao) {
        if (!listaExposicoes.stream().noneMatch((e) -> (e.equals(exposicao)))) {
            return false;
        }
        return listaExposicoes.add(exposicao);
    }

    public void setListaExposicoes(List<Exposicao> lst) {
        this.listaExposicoes = lst;
    }

    public List<Exposicao> getListaExposicoes() {
        return this.listaExposicoes;
    }

    public boolean validaExposicao(Exposicao exposicao) {
        return exposicao.valida();
    }

    public boolean registaExposicao(Exposicao exposicao) {
        if (validaExposicao(exposicao) == true) {
            return this.listaExposicoes.add(exposicao);
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nListaExposicoes{" + "listaExposicoes=" + listaExposicoes + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaExposicoes = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element //iterate over keywords
            Element elementExposicoes = document.createElement(EXPO_ELEMENT_NAME);
            elementListaExposicoes.appendChild(elementExposicoes);
            for (Exposicao exposicao : getListaExposicoes()) {
                Node exposicaoNode = exposicao.exportContentToXMLNode();
                elementExposicoes.appendChild(document.importNode(exposicaoNode, true));
            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaExposicoes);
            node = elementListaExposicoes;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public ListaExposicoes importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
