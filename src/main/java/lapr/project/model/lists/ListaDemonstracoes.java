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
import lapr.project.model.Demonstracao;
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
public class ListaDemonstracoes implements Exportable, Importable<ListaDemonstracoes> {

    private static final String ROOT_ELEMENT_NAME = "listaDemonstracoes";
    private static final String DEMO_LST_ELEMENT_NAME = "demonstracoes";
    
    private List<Demonstracao> listaDemonstracoes;

    public ListaDemonstracoes() {
        listaDemonstracoes = new ArrayList<>();
    }

    public boolean addDemonstracao(Demonstracao demonstracao) {

        //Verificação de ja existe esta Demonstracao
        if (!listaDemonstracoes.stream().noneMatch((d) -> (d.equals(demonstracao)))) {
            return false;
        }

        return this.listaDemonstracoes.add(demonstracao);
    }

    public List<Demonstracao> getListaDemonstracoes() {
        return this.listaDemonstracoes;
    }

    @Override
    public String toString() {
        return "\nListaDemonstracoes{" + "listaDemonstracoes=" + listaDemonstracoes + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaDemonstracoes = document.createElement(ROOT_ELEMENT_NAME);

            
            //Create a sub-element //iterate over keywords
            Element elementDemos = document.createElement(DEMO_LST_ELEMENT_NAME);
            elementListaDemonstracoes.appendChild(elementDemos);
            for (Demonstracao demo : getListaDemonstracoes()) {
                Node demoNode = demo.exportContentToXMLNode();
                elementDemos.appendChild(document.importNode(demoNode, true));
            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaDemonstracoes);
            node = elementListaDemonstracoes;

            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public ListaDemonstracoes importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
