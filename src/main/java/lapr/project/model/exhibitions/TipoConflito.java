/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.mecanismos.MecanismoDetecaoConflito;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class TipoConflito implements Exportable, Serializable {

    private static final String ROOT_ELEMENT_NAME = "tipoConflito";
    private static final String DESC_ELEMENT_NAME = "descricao";

    private String descricao;
    private MecanismoDetecaoConflito mecanismoDetecaoConflito;

    public TipoConflito(String descricao) {
        this.descricao = descricao;
    }

    public TipoConflito(String descricao, MecanismoDetecaoConflito mecanismoDetecaoConflito) {
        this.descricao = descricao;
        this.mecanismoDetecaoConflito = mecanismoDetecaoConflito;
    }

    public TipoConflito() {
        ///For Import use only
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public MecanismoDetecaoConflito getMecanismoDetecaoConflito() {
        return this.mecanismoDetecaoConflito;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TipoConflito) {
            TipoConflito tc = (TipoConflito) obj;
            return this.descricao.equals(tc.descricao);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;
    
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementTipoConflito = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementDescricao = document.createElement(DESC_ELEMENT_NAME);
            elementDescricao.setTextContent(getDescricao());
            elementTipoConflito.appendChild(elementDescricao);

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementTipoConflito);
            node = elementTipoConflito;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
}
        return node;
    }
}
