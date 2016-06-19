/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Stand;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaRecursos;
import lapr.project.model.lists.ListaTipoConflito;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.mecanismos.MecanismoAtribuicao;
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
public class CentroExposicoes implements Exportable, Importable<CentroExposicoes>, Serializable {

    private static final String ROOT_ELEMENT_NAME = "centroExposicoes";
    private static final String MECANISMOS_ELEMENT_NAME = "mecanismos";

    private RegistoUtilizadores registoUtilizadores;
    private ListaExposicoes listaExposicoes;
    private ListaRecursos listaRecursos;
    private ListaTipoConflito listaTipoConflito;
    
    //TODO: Retirar Lista demo daqui! Só pertence as expo
    private ListaDemonstracoes listaDemonstracoes;
    private List<MecanismoAtribuicao> listaMecanismos;
    private final List<Stand> listaStands;

    /**
     * Construtor de CentroExposicoes
     *
     * @param lstUtilizador a lista de utilizadores
     * @param lstExposicao a lista de exposicoes
     * @param registoExposicao o registo de exposicoes
     * @param registoCandidatura o registo de candidaturas
     * @param registoUtilizador o registo de utilizadores
     */
    public CentroExposicoes(RegistoUtilizadores registoUtilizadores, ListaExposicoes listaExposicoes) {
        this.registoUtilizadores = registoUtilizadores;
        this.listaExposicoes = listaExposicoes;
        this.listaRecursos = new ListaRecursos();
        this.listaTipoConflito = new ListaTipoConflito();
        this.listaMecanismos = new ArrayList<>();
        this.listaStands = new ArrayList<>();

    }

    public CentroExposicoes() {
        this.listaExposicoes = new ListaExposicoes();
        this.registoUtilizadores = new RegistoUtilizadores();
        this.listaRecursos = new ListaRecursos();
        this.listaTipoConflito = new ListaTipoConflito();
        this.listaMecanismos = new ArrayList<>();
        this.listaStands = new ArrayList<>();

    }

    public void addMecanismo(MecanismoAtribuicao mecanismoAtribuicao) {
        listaMecanismos.add(mecanismoAtribuicao);
    }

    public void addStand(Stand stand) {
        getListaStands().add(stand);
    }

    public List<Stand> getListaStands() {
        return listaStands;
    }

    public ListaExposicoes getListaExposicoes() {
        return listaExposicoes;
    }

    public RegistoUtilizadores getRegistoUtilizadores() {
        return registoUtilizadores;
    }

    public ListaRecursos getListaRecursos() {
        return listaRecursos;
    }

    public List<MecanismoAtribuicao> getListaMecanismos() {
        return listaMecanismos;
    }

    public ListaDemonstracoes getListaDemonstracoes() {
        return listaDemonstracoes;
    }

    public ListaTipoConflito getListaTipoConflito() {
        return listaTipoConflito;
    }

    @Override
    public String toString() {
        return "CentroExposicoes{" + "\nregistoUtilizadores=" + registoUtilizadores + ", \nlistaExposicoes=" + listaExposicoes + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node rootNode = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementCentroExposicoes = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element
            Node registoUtilizadoresNode = this.registoUtilizadores.exportContentToXMLNode();
            elementCentroExposicoes.appendChild(document.importNode(registoUtilizadoresNode, true));

            //Create a sub-element
            Node listaExposicoesNode = this.listaExposicoes.exportContentToXMLNode();
            elementCentroExposicoes.appendChild(document.importNode(listaExposicoesNode, true));

            //TODO: Create a sub-element
//            Node listaCandidaturasNode = this.listaCandidaturas.exportContentToXMLNode();
//            elementCentroExposicoes.appendChild(document.importNode(listaCandidaturasNode, true));
            //TODO: Create a sub-element
//            Node listaRecursosNode = this.listaRecursos.exportContentToXMLNode();
//            elementCentroExposicoes.appendChild(document.importNode(listaRecursosNode, true));
            //TODO: Create a sub-element
//            Node listaTipoConflitoNode = this.listaTipoConflito.exportContentToXMLNode();
//            elementCentroExposicoes.appendChild(document.importNode(listaTipoConflitoNode, true));
            //TODO: Create a sub-element //iterate over keywords
//            Element elementMecanismos = document.createElement(MECANISMOS_ELEMENT_NAME);
//            elementCentroExposicoes.appendChild(elementMecanismos);
//            for (MecanismoAtribuicao meca : getListaMecanismos()) {
//                Node mecanismoNode = meca.exportContentToXMLNode();
//                elementMecanismos.appendChild(document.importNode(mecanismoNode, true));
//            }
            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementCentroExposicoes);
            rootNode = elementCentroExposicoes;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rootNode;
    }

    @Override
    public CentroExposicoes importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            //Create document builder //Obtain a new document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            document.appendChild(document.importNode(node, true));

            //Init
            NodeList elements1CentroExposicoes = document.getElementsByTagName(ROOT_ELEMENT_NAME);
            Node element2CentroExposicoes = elements1CentroExposicoes.item(0);

            //TODO: Add import for all Lists (Verify)
            //Add List Class
            Node nodeRegUsers = element2CentroExposicoes.getFirstChild();
            RegistoUtilizadores instanceRegUsers = new RegistoUtilizadores();
            instanceRegUsers = instanceRegUsers.importContentFromXMLNode(nodeRegUsers);
            this.registoUtilizadores = instanceRegUsers;

            //Add List Class
            Node nodeListExpo = element2CentroExposicoes.getFirstChild().getNextSibling();
            ListaExposicoes instanceListaExposicoes = new ListaExposicoes();
            instanceListaExposicoes = instanceListaExposicoes.importContentFromXMLNode(nodeListExpo);
            this.listaExposicoes = instanceListaExposicoes;

            //Add List Class
            Node nodeListaRecur = element2CentroExposicoes.getFirstChild().getNextSibling().getNextSibling().getNextSibling();
            ListaRecursos instanceRecursos = new ListaRecursos();
            instanceRecursos = instanceRecursos.importContentFromXMLNode(nodeListaRecur);
            this.listaRecursos = instanceRecursos;

            //Add List Class
            Node nodeListaTipConf = element2CentroExposicoes.getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling();
            ListaTipoConflito instanceListaTipoConf = new ListaTipoConflito();
            instanceListaTipoConf = instanceListaTipoConf.importContentFromXMLNode(nodeListaTipConf);
            this.listaTipoConflito = instanceListaTipoConf;

            //TODO: Import for Mecanismos List (is this really necessary?)
//            NodeList elementsKeywords = document.getElementsByTagName(KEYWORDS_ELEMENT_NAME);
//            NodeList keywords = elementsKeywords.item(0).getChildNodes();
//            for (int position = 0; position < keywords.getLength(); position++) {
//                Node keyword = keywords.item(position);
//                KeywordExample keywordExample = new KeywordExample();
//
//                keywordExample = keywordExample.importContentFromXMLNode(keyword);
//                addKeyword(keywordExample);
//            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return this;
    }

}
