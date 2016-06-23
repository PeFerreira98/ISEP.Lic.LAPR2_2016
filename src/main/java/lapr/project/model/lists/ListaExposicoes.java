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
import lapr.project.model.submissions.Retiravel;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.users.FAE;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Marcos
 */
public class ListaExposicoes implements Exportable, Importable<ListaExposicoes>, Serializable {

    private static final String ROOT_ELEMENT_NAME = "listaExposicoes";
    private static final String EXPO_ELEMENT_NAME = "exposicoes";

    private List<Exposicao> listExposicoes;

    public ListaExposicoes() {
        listExposicoes = new ArrayList<>();
    }

    public boolean addExposicao(Exposicao exposicao) {

        //procura na lista se ja existe esta expo
        for (Exposicao e : this.listExposicoes) {
            if (e.equals(exposicao)) {
                return false;
            }
        }
        return listExposicoes.add(exposicao);
    }

    public void setListaExposicoes(List<Exposicao> lst) {
        this.listExposicoes = lst;
    }

    public List<Exposicao> getListaExposicoes() {
        return this.listExposicoes;
    }

    public boolean validaExposicao(Exposicao exposicao) {
        return exposicao.valida();
    }

    public boolean registaExposicao(Exposicao exposicao) {
        if (validaExposicao(exposicao)) {
            return this.listExposicoes.add(exposicao);
        }
        return false;
    }
    
    public List<Atribuicao> getAllAtribuicoes(){
        List<Atribuicao> lst = new ArrayList<>();
        for(Exposicao e : this.listExposicoes){
            for(Atribuicao a : e.getListaAtribuicoes().getListaAtribuicoes()){
                lst.add(a);
            }
        }
        return lst;
    }

    public Exposicao getExpoByName(String title) {
        for (Exposicao e : this.listExposicoes) {
            if (e.getTitle().equalsIgnoreCase(title)) {
                return e;
            }
        }
        return null;
    }

    public List<Retiravel> getCandidaturasExposicoesRetiraveis() {
        List<Retiravel> lRetiraveis = new ArrayList<>();
        for (Exposicao e : this.listExposicoes) {
            lRetiraveis.addAll(e.getCandidaturasExposicoesRetiraveis());
        }
        return lRetiraveis;
    }

    public List<Exposicao> getListaExposicoesCandidaturaTerminada() {
        List<Exposicao> listExpoTemp = new ArrayList<>();
        for (Exposicao expo : listExposicoes) {
            if (expo.isCandidaturaTerminada()) {
                listExpoTemp.add(expo);
            }
        }
        return listExpoTemp;
    }
    
    public List<Exposicao> getListaExposicoesComConflitos(){
        List<Exposicao> listExpoTemp = new ArrayList<>();
        for (Exposicao expo : listExposicoes) {
            if (expo.hasConflitos()) {
                listExpoTemp.add(expo);
            }
        }
        return listExpoTemp;
    }
    
    public List<FAE> getAllFAE() {
        ListaFAE listFAEFinal = new ListaFAE();

        for (Exposicao expo : listExposicoes) {
            expo.getAllFAE(listFAEFinal);
        }

        return listFAEFinal.getListaFAE();
    }
    
    public int nrSubFAE(FAE fae){
        return 0;
    }

    @Override
    public String toString() {
        return "\n ListaExposicoes{" + "listaExposicoes=" + listExposicoes + '}';
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
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            //Create document builder //Obtain a new document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.appendChild(document.importNode(node, true));

            //Init
            NodeList elements1ListaExpo = document.getElementsByTagName(ROOT_ELEMENT_NAME);
            Node element2ListaExpo = elements1ListaExpo.item(0);

            //Add Lista
            NodeList elements3Expos = document.getElementsByTagName(EXPO_ELEMENT_NAME);
            NodeList expos4 = elements3Expos.item(0).getChildNodes();
            for (int position = 0; position < expos4.getLength(); position++) {
                Node expo5 = expos4.item(position);
                Exposicao expo6sicao = new Exposicao();
                expo6sicao = expo6sicao.importContentFromXMLNode(expo5);
                addExposicao(expo6sicao);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return this;
    }

}
