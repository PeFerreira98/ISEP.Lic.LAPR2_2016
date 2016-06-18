/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Retiravel;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoConflitos;
import lapr.project.model.users.FAE;
import lapr.project.model.users.GestorExposicoes;
import lapr.project.model.users.Organizador;
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
public class Exposicao implements Exportable, Importable<Exposicao>, Serializable {

    private static final String ROOT_ELEMENT_NAME = "exposicao";
    private static final String TITLE_ELEMENT_NAME = "titulo";
    private static final String DESC_ELEMENT_NAME = "descricao";
    private static final String LOCAL_ELEMENT_NAME = "local";

    private String title;
    private String description;
    private String local;

    private GestorExposicoes gestor;

    private Data dataInicioRealizacao;
    private Data dataFimRealizacao;
    private Data dataInicioSubmissao;
    private Data dataFimSubmissao;

    private ListaOrganizadores listaOrganizadores;
    private ListaFAE listaFAE;
    private ListaDemonstracoes listaDemonstracoes;
    private ListaAtribuicoes listaAtribuicoes;
    private ListaCandidaturas listaCandidaturas;
    private RegistoConflitos listaConflitos;

    public Exposicao(String nomeExposicao, String descricaoExposicao, Data dataInicioRealizacao,
            Data dataFimRealizacao, Data dataInicioSubmissao, Data dataFimSubmissao, String local) {

        //TODO >> add gestor to constructor (check ViewExpoUI)
//        this.gestor = ???;
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
        this.listaAtribuicoes = new ListaAtribuicoes();
        this.listaCandidaturas = new ListaCandidaturas();
        this.listaConflitos = new RegistoConflitos();
    }

    public Exposicao() {

        //TODO >> add gestor to constructor (check ViewExpoUI)
//        this.gestor = ???;
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
        this.listaAtribuicoes = new ListaAtribuicoes();
        this.listaCandidaturas = new ListaCandidaturas();
        this.listaConflitos = new RegistoConflitos();
    }

    public void setGestor(GestorExposicoes ge) {
        this.gestor = ge;
    }

    public GestorExposicoes getGestor() {
        return this.gestor;
    }

    public FAE getFAE(String username) {
        return this.listaFAE.getFAE(username);
    }

    public ListaAtribuicoes getListaAtribuicoes() {
        return listaAtribuicoes;
    }

    public ListaCandidaturas getListaCandidaturas() {
        return listaCandidaturas;
    }

    public RegistoConflitos getRegistoConflitos() {
        return this.listaConflitos;
    }

    public boolean hasFAE(String username) {
        return this.listaFAE.hasFAE(username);
    }

    public boolean hasOrganizador(String username) {
        return this.listaOrganizadores.hasOrganizador(username);
    }

    public boolean addCandidatura(Candidatura candidatura) {
        return this.listaCandidaturas.addCandidatura(candidatura);
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
        return this.local;
    }

    public ListaOrganizadores getListaOrganizadores() {
        return this.listaOrganizadores;
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

    public boolean isOrganizador(Organizador org) {
        return this.listaOrganizadores.isOrganizador(org);
    }

    public boolean valida() {
        return !("".equalsIgnoreCase(this.title)
                || "".equalsIgnoreCase(this.description)
                || this.dataInicioRealizacao == null
                || this.dataFimRealizacao == null
                || this.dataInicioSubmissao == null
                || this.dataFimSubmissao == null
                || "".equalsIgnoreCase(this.local));
    }

    public List<Retiravel> getCandidaturasExposicoesRetiraveis() {
        return this.listaCandidaturas.getCandidaturasRetiraveis();
    }

    public List<Retiravel> getCandidaturasDemonstracoesRetiraveis() {
        return this.listaDemonstracoes.getCandidaturasDemonstracoesRetiraveis();
    }

    public boolean isCandidaturaTerminada() {
        for (Candidatura can : this.listaCandidaturas.getListaCandidaturas()) {
            if (!can.isTerminada()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean hasConflitos(){
        return this.listaConflitos.hasConflitos();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.local);
        hash = 89 * hash + Objects.hashCode(this.gestor);
        hash = 89 * hash + Objects.hashCode(this.dataInicioRealizacao);
        hash = 89 * hash + Objects.hashCode(this.dataFimRealizacao);
        hash = 89 * hash + Objects.hashCode(this.dataInicioSubmissao);
        hash = 89 * hash + Objects.hashCode(this.dataFimSubmissao);
        hash = 89 * hash + Objects.hashCode(this.listaOrganizadores);
        hash = 89 * hash + Objects.hashCode(this.listaFAE);
        hash = 89 * hash + Objects.hashCode(this.listaDemonstracoes);
        hash = 89 * hash + Objects.hashCode(this.listaAtribuicoes);
        hash = 89 * hash + Objects.hashCode(this.listaCandidaturas);
        hash = 89 * hash + Objects.hashCode(this.listaConflitos);
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
        final Exposicao other = (Exposicao) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.gestor, other.gestor)) {
            return false;
        }
        if (!Objects.equals(this.dataInicioRealizacao, other.dataInicioRealizacao)) {
            return false;
        }
        if (!Objects.equals(this.dataFimRealizacao, other.dataFimRealizacao)) {
            return false;
        }
        if (!Objects.equals(this.dataInicioSubmissao, other.dataInicioSubmissao)) {
            return false;
        }
        if (!Objects.equals(this.dataFimSubmissao, other.dataFimSubmissao)) {
            return false;
        }
        if (!Objects.equals(this.listaOrganizadores, other.listaOrganizadores)) {
            return false;
        }
        if (!Objects.equals(this.listaFAE, other.listaFAE)) {
            return false;
        }
        if (!Objects.equals(this.listaDemonstracoes, other.listaDemonstracoes)) {
            return false;
        }
        if (!Objects.equals(this.listaAtribuicoes, other.listaAtribuicoes)) {
            return false;
        }
        if (!Objects.equals(this.listaCandidaturas, other.listaCandidaturas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nExposicao{" + "title=" + title + ", description=" + description
                + ", local=" + local + ", dataInicioRealizacao=" + dataInicioRealizacao
                + ", dataFimRealizacao=" + dataFimRealizacao + ", dataInicioSubmissao="
                + dataInicioSubmissao + ", dataFimSubmissao=" + dataFimSubmissao
                + ",\n listaOrganizadores=" + listaOrganizadores + ",\n listaFAE=" + listaFAE
                + ",\n listaDemonstracoes=" + listaDemonstracoes + ",\n listaAtribuicoes="
                + listaAtribuicoes + ",\n listaCandidaturas=" + listaCandidaturas + '}';
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
            Node gestorNode = this.gestor.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(gestorNode, true));

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

            //Create a sub-element
            Node listaOrgNode = this.listaOrganizadores.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(listaOrgNode, true));

            //Create a sub-element
            Node listaFaeNode = this.listaFAE.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(listaFaeNode, true));

            //Create a sub-element
            Node listaDemonstacoesNode = this.listaDemonstracoes.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(listaDemonstacoesNode, true));

            //Create a sub-element
            Node listaAtribuicoesNode = this.listaAtribuicoes.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(listaAtribuicoesNode, true));

            //Create a sub-element
            Node listaCandidaturasNode = this.listaCandidaturas.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(listaCandidaturasNode, true));

            //Create a sub-element
            Node listaConflitosNode = this.listaConflitos.exportContentToXMLNode();
            elementExposicao.appendChild(document.importNode(listaConflitosNode, true));

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
