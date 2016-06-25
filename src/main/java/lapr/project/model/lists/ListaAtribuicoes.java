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
import lapr.project.model.submissions.Atribuicao;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class ListaAtribuicoes implements Exportable, Serializable{

    private static final String ROOT_ELEMENT_NAME = "listaAtribuicoes";
    private static final String ATRIB_ELEMENT_NAME = "atribuicoes";
    
    private List<Atribuicao> listAtribuicoes;

    public ListaAtribuicoes() {
        this.listAtribuicoes = new ArrayList<>();
    }

    public boolean addAtribuicoes(List<Atribuicao> atrs) {
        return listAtribuicoes.addAll(atrs);
    }

    public boolean addAtribuicao(Atribuicao atribuicao) {

        //procura na lista se ja existe esta atribuição
        for (Atribuicao a : this.listAtribuicoes) {
            if (a.equals(atribuicao)) {
                return false;
            }
        }
        return this.listAtribuicoes.add(atribuicao);
    }

    public List<Atribuicao> getListaAtribuicoes() {
        return listAtribuicoes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.listAtribuicoes);
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
        final ListaAtribuicoes other = (ListaAtribuicoes) obj;
        if (!Objects.equals(this.listAtribuicoes, other.listAtribuicoes)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "\n ListaAtribuicoes{" + "\t listaAtribuicoes=" + listAtribuicoes + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaAtribuicoes = document.createElement(ROOT_ELEMENT_NAME);

            //TODO: Create a sub-element //iterate over keywords
            Element elementAtribuicoes = document.createElement(ATRIB_ELEMENT_NAME);
            elementListaAtribuicoes.appendChild(elementAtribuicoes);
            for (Atribuicao candidatura : getListaAtribuicoes()) {
                Node candiNode = candidatura.exportContentToXMLNode();
                elementAtribuicoes.appendChild(document.importNode(candiNode, true));
            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaAtribuicoes);
            node = elementListaAtribuicoes;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }
    
}
