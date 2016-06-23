/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaRecursos;
import lapr.project.model.lists.RegistoConflitos;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Retiravel;
import lapr.project.model.users.FAE;
import lapr.project.utils.Data;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class Demonstracao implements Exportable, Serializable {

    private static final String ROOT_ELEMENT_NAME = "demonstracao";
    private static final String DES_ELEMENT_NAME = "designacao";

    private String designacao;
    private String cod;
    private ListaRecursos listaRecursos;
    private ListaCandidaturas listaCandidaturas;
    private RegistoConflitos registoConflitos;
    private ListaFAE listaFAE;
    private boolean demonstracaoEfetiva;
    private Data data;

    public Demonstracao() {
        this.cod = "NULL";
        this.designacao = "NULL";
        this.listaRecursos = new ListaRecursos();
        this.listaCandidaturas = new ListaCandidaturas();
        this.registoConflitos = new RegistoConflitos();
        this.listaFAE = new ListaFAE();
        demonstracaoEfetiva = false;
    }

    public Demonstracao(String desc) {
        this.cod = "NULL";
        this.designacao = desc;
        this.listaRecursos = new ListaRecursos();
        this.listaCandidaturas = new ListaCandidaturas();
        this.registoConflitos = new RegistoConflitos();
        this.listaFAE = new ListaFAE();
        demonstracaoEfetiva = false;
    }

    public Demonstracao(String cod, String desc) {
        this.cod = cod;
        this.designacao = desc;
        this.listaRecursos = new ListaRecursos();
        this.listaCandidaturas = new ListaCandidaturas();
        this.registoConflitos = new RegistoConflitos();
        this.listaFAE = new ListaFAE();
        demonstracaoEfetiva = false;
    }

    public Demonstracao(String cod, String designacao, ListaRecursos lst) {
        this.cod = cod;
        this.designacao = designacao;
        this.listaRecursos = lst;
        this.listaCandidaturas = new ListaCandidaturas();
        this.registoConflitos = new RegistoConflitos();
        this.listaFAE = new ListaFAE();
        demonstracaoEfetiva = false;
    }

    public static boolean validateDesignacao(String designacao) {
        return !(designacao == null || designacao.isEmpty());
    }

    public void addListaRecursos(ListaRecursos lst) {
        this.listaRecursos = lst;
    }

    public String getDesignacao() {
        return designacao;
    }

    public String getCod() {
        return cod;
    }

    public ListaRecursos getListaRecursos() {
        return listaRecursos;
    }

    public ListaFAE getListaFAE() {
        return this.listaFAE;
    }

    public RegistoConflitos getRegistoConflitos() {
        return this.registoConflitos;
    }

    public boolean addCandidatura(Candidatura candidatura) {
        return this.listaCandidaturas.registaCandidatura(candidatura);
    }

    public ListaCandidaturas getListaCandidaturas() {
        return listaCandidaturas;
    }

    public List<Retiravel> getCandidaturasDemonstracoesRetiraveis() {
        return this.listaCandidaturas.getCandidaturasRetiraveis();
    }

    public void setDemonstracaoEfetiva(boolean demonstracaoEfetiva) {
        this.demonstracaoEfetiva = demonstracaoEfetiva;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public boolean isDemonstracaoEfetiva() {
        return demonstracaoEfetiva;
    }

    public boolean isCandidaturaTerminada() {
        for (Candidatura can : this.listaCandidaturas.getListaCandidaturas()) {
            if (!can.isTerminada()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasConflitos() {
        return this.registoConflitos.hasConflitos();
    }

    public void getAllFAE(ListaFAE listFAEFinal) {
        for (FAE fae : listaFAE.getListaFAE()) {
            listFAEFinal.addFAE(fae);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.designacao);
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
        final Demonstracao other = (Demonstracao) obj;
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return designacao;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node rootNode = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementDemo = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementDescricao = document.createElement(DES_ELEMENT_NAME);
            elementDescricao.setTextContent(getDesignacao());
            elementDemo.appendChild(elementDescricao);

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementDemo);
            rootNode = elementDemo;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return rootNode;
    }

}
