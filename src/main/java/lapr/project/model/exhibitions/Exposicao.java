/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Candidatura;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.utils.Data;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author TiagoSilvestre
 */
public class Exposicao implements Exportable, Importable<Exposicao> {

    private static final String ROOT_ELEMENT_NAME = "exposicao";
    
    private static final String TITLE_ELEMENT_NAME = "titulo";
    private static final String DESC_ELEMENT_NAME = "descricao";
    private static final String LOCAL_ELEMENT_NAME = "local";
    
    private static final String DATA_INI_REA_ELEMENT_NAME = "dataInicioRealizacao";
    private static final String DATA_FIM_REA_ELEMENT_NAME = "dataFimRealizacao";
    private static final String DATA_INI_SUB_ELEMENT_NAME = "dataInicioSubmicao";
    private static final String DATA_FIM_SUB_ELEMENT_NAME = "dataFimSubmissao";
    
    private static final String ORG_LST_ELEMENT_NAME = "listaOrganizadores";
    private static final String FAE_LST_ELEMENT_NAME = "listaFAE";
    private static final String DEMO_LST_ELEMENT_NAME = "listaDemonstracoes";
    private static final String CANDID_ELEMENT_NAME = "candidatura";
    
    
    private String title;
    private String description;
    private String local;
    
    private Data dataInicioRealizacao;
    private Data dataFimRealizacao;
    private Data dataInicioSubmissao;
    private Data dataFimSubmissao;
    
    private ListaOrganizadores listaOrganizadores;
    private ListaFAE listaFAE;
    private ListaDemonstracoes listaDemonstracoes;
    
    //TODO:  Change to list
    private Candidatura candidatura;

    /**
     * Construtor de Exposicao
     *
     * @param nomeExposicao o nome da exposicao
     * @param descricaoExposicao a descricao da exposicao
     * @param dataInicioSubmissao a data de inicio da submissao da exposicao
     * @param dataFimSubmissao a data de fim da submissao da exposicao
     * @param dataInicioRealizacao a data de inicio da realização da exposicao
     * @param dataFimRealizacao a data de fim da realização da exposicao
     * @param local
     * @param listaOrganizadores
     * @param listaFAE
     */
    public Exposicao(String nomeExposicao, String descricaoExposicao, Data dataInicioRealizacao,
            Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao, String local,
            ListaOrganizadores listaOrganizadores, ListaFAE listaFAE) {

        this.title = nomeExposicao;
        this.description = descricaoExposicao;
        this.local = local;

        this.dataInicioRealizacao = dataInicioRealizacao;
        this.dataFimRealizacao = dataFimRealizacao;
        this.dataInicioSubmissao = dataInicioSubmissao;
        this.dataFimSubmissao = dataFimSubmissao;

        this.listaOrganizadores = listaOrganizadores;
        this.listaFAE = listaFAE;
        this.listaDemonstracoes = new ListaDemonstracoes();
    }

    public Exposicao(String nomeExposicao, String descricaoExposicao, Data dataInicioRealizacao,
            Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao, String local) {

        this.title = nomeExposicao;
        this.description = descricaoExposicao;
        this.local = local;

        this.dataInicioRealizacao = dataInicioRealizacao;
        this.dataFimRealizacao = dataFimRealizacao;
        this.dataInicioSubmissao = dataInicioSubmissao;
        this.dataFimSubmissao = dataFimSubmissao;

        this.listaOrganizadores = new ListaOrganizadores();
        this.listaFAE = new ListaFAE();
        this.listaDemonstracoes = new ListaDemonstracoes();
    }

    public Exposicao() {
        this.title = "";
        this.description = "";
        this.local = "";

        this.dataInicioRealizacao = new Data();
        this.dataFimRealizacao = new Data();
        this.dataInicioSubmissao = new Data();
        this.dataFimSubmissao = new Data();

        this.listaOrganizadores = new ListaOrganizadores();
        this.listaFAE = new ListaFAE();
        this.listaDemonstracoes = new ListaDemonstracoes();
    }

    public boolean addCandidatura(Candidatura candidatura) {
        if (this.candidatura == null) {
            this.candidatura = candidatura;
            return true;
        }
        return false;
    }

    public Data getDataInicioSubmissao() {
        return dataInicioSubmissao;
    }

    public Data getDataFimSubmissao() {
        return dataFimSubmissao;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the dataInicioRealizacao
     */
    public Data getDataInicioRealizacao() {
        return dataInicioRealizacao;
    }

    /**
     * @return the dataFimRealizacao
     */
    public Data getDataFimRealizacao() {
        return dataFimRealizacao;
    }

    public String getLocal() {
        return local;
    }

    public ListaOrganizadores getListaOrganizadores() {
        return listaOrganizadores;
    }

    public ListaFAE getListaFAE() {
        return this.listaFAE;
    }

    public ListaDemonstracoes getListaDemonstracoes() {
        return this.listaDemonstracoes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setDataInicioRealizacao(Data dataInicioRealizacao) {
        this.dataInicioRealizacao = dataInicioRealizacao;
    }

    public void setDataFimRealizacao(Data dataFimRealizacao) {
        this.dataFimRealizacao = dataFimRealizacao;
    }

    public void setDataInicioSubmissao(Data dataInicioSubmissao) {
        this.dataInicioSubmissao = dataInicioSubmissao;
    }

    public void setDataFimSubmissao(Data dataFimSubmissao) {
        this.dataFimSubmissao = dataFimSubmissao;
    }

    public void setListaOrganizadores(ListaOrganizadores listaOrganizadores) {
        this.listaOrganizadores = listaOrganizadores;
    }

    public void setListaFAE(ListaFAE listaFAE) {
        this.listaFAE = listaFAE;
    }

    public boolean valida() {
        return !(this.title.equalsIgnoreCase("")
                || this.description.equalsIgnoreCase("")
                || this.dataInicioRealizacao == null
                || this.dataFimRealizacao == null
                || this.dataInicioSubmissao == null
                || this.dataFimRealizacao == null
                || this.local.equalsIgnoreCase("")
                || !listaFAE.valida()
                || !listaOrganizadores.valida());
    }

    @Override
    public String toString() {
        return "\nExposicao{" + "title=" + title + ", description=" + description
                + ", local=" + local + ", dataInicioRealizacao=" + dataInicioRealizacao
                + ", dataFimRealizacao=" + dataFimRealizacao + ", dataInicioSubmissao="
                + dataInicioSubmissao + ", dataFimSubmissao=" + dataFimSubmissao + ", \nlistaOrganizadores="
                + listaOrganizadores + ", \nlistaFAE=" + listaFAE + ", \nlistaDemonstracoes="
                + listaDemonstracoes + ", \ncandidatura=" + candidatura + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementExposicao = document.createElement(ROOT_ELEMENT_NAME);

            
            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementTitle = document.createElement(TITLE_ELEMENT_NAME);
            elementTitle.setTextContent(getTitle());
            elementExposicao.appendChild(elementTitle);
            
            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementDesc = document.createElement(DESC_ELEMENT_NAME);
            elementDesc.setTextContent(getDescription());
            elementExposicao.appendChild(elementDesc);
            
            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementLocal = document.createElement(LOCAL_ELEMENT_NAME);
            elementLocal.setTextContent(getLocal());
            elementExposicao.appendChild(elementLocal);
            
            //Create a sub-element
            Node dataInicioReaNode = this.dataInicioRealizacao.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(dataInicioReaNode, true));
            
            //Create a sub-element
            Node dataFimReaNode = this.dataFimRealizacao.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(dataFimReaNode, true));
            
            //Create a sub-element
            Node dataInicioSubNode = this.dataInicioSubmissao.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(dataInicioSubNode, true));
            
            //Create a sub-element
            Node dataFimSubNode = this.dataFimSubmissao.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(dataFimSubNode, true));
            
//            //Create a sub-element
//            Node listaOrgNode = this.listaOrganizadores.exportContentToXMLNode();
//            elementExposicao.appendChild(document.importNode(listaOrgNode, true));
//            
//            //Create a sub-element
//            Node listaFaeNode = this.listaFAE.exportContentToXMLNode();
//            elementExposicao.appendChild(document.importNode(listaFaeNode, true));
//            
//            //Create a sub-element
//            Node candidaturaNode = this.candidatura.exportContentToXMLNode();
//            elementExposicao.appendChild(document.importNode(candidaturaNode, true));


            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementExposicao);
            node = elementExposicao;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public Exposicao importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
