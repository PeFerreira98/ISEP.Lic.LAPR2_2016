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
import lapr.project.model.Demonstracao;
import lapr.project.model.submissions.Retiravel;
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
public class ListaDemonstracoes implements Exportable, Importable<ListaDemonstracoes>, Serializable {

    private static final String ROOT_ELEMENT_NAME = "listaDemonstracoes";
    private static final String DEMO_LST_ELEMENT_NAME = "demonstracoes";

    private List<Demonstracao> listDemonstracoes;

    public ListaDemonstracoes() {
        listDemonstracoes = new ArrayList<>();
    }

    public boolean addDemonstracao(Demonstracao demonstracao) {

        //procura na lista se ja existe esta demo
        for (Demonstracao d : this.listDemonstracoes) {
            if (d.equals(demonstracao)) {
                return false;
            }
        }
        return this.listDemonstracoes.add(demonstracao);
    }

    public List<Demonstracao> getListaDemonstracoes() {
        return this.listDemonstracoes;
    }

    public List<Retiravel> getCandidaturasDemonstracoesRetiraveis() {
        List<Retiravel> lRetiraveis = new ArrayList<>();
        for (Demonstracao d : this.listDemonstracoes) {
            lRetiraveis.addAll(d.getCandidaturasDemonstracoesRetiraveis());
        }
        return lRetiraveis;
    }

    public List<Demonstracao> getListaDemonstracoesCandidaturaTerminada() {
        List<Demonstracao> listDemoTemp = new ArrayList<>();
        for (Demonstracao demo : this.listDemonstracoes) {
            if (demo.isCandidaturaTerminada()) {
                listDemoTemp.add(demo);
            }
        }
        return listDemoTemp;
    }

    public List<Demonstracao> getListaDemonstracoesComConflitos() {
        List<Demonstracao> listDemoTemp = new ArrayList<>();
        for (Demonstracao demo : listDemonstracoes) {
            if (demo.hasConflitos()) {
                listDemoTemp.add(demo);
            }
        }
        return listDemoTemp;
    }

    public void getAllFAE(ListaFAE listFAEFinal) {
        for (Demonstracao demo : listDemonstracoes) {
            demo.getAllFAE(listFAEFinal);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.listDemonstracoes);
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
        final ListaDemonstracoes other = (ListaDemonstracoes) obj;
        if (!Objects.equals(this.listDemonstracoes, other.listDemonstracoes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n ListaDemonstracoes{" + "listaDemonstracoes=" + listDemonstracoes + '}';
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
