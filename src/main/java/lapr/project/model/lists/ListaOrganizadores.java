/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.users.Organizador;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author TiagoSilvestre
 */
public class ListaOrganizadores implements Exportable, Importable<ListaOrganizadores> {

    private static final String ROOT_ELEMENT_NAME = "listaOrganizadores";
    private static final String ORG_LST_ELEMENT_NAME = "organizadores";

    private List<Organizador> listOrganizadores;

    public ListaOrganizadores() {
        this.listOrganizadores = new ArrayList<>();
    }

    public List<Organizador> getLstOrganizadores() {
        return this.listOrganizadores;
    }

    public boolean isOrganizador(Organizador org) {
        //Verifica se existe este organizador. Retorna true or false
        for (Organizador o : this.listOrganizadores) {
            if (o.equals(org)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasOrganizador(String username) {
        //Verifica se algum organizador tem este username. Retorna true or false
        for (Organizador o : this.listOrganizadores) {
            if (o.getUtilizador().validateUsername(username)) {
                return true;
            }
        }
        return false;
    }

    public void addOrganizador(Utilizador u) {
        Organizador org = new Organizador(u);
        if (validaOrganizador(org)) {
            listOrganizadores.add(org);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.listOrganizadores);
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
        final ListaOrganizadores other = (ListaOrganizadores) obj;
        if (!Objects.equals(this.listOrganizadores, other.listOrganizadores)) {
            return false;
        }
        return true;
    }

    public boolean validaOrganizador(Organizador organizador) {
        return organizador.valida();
    }

    public boolean valida() {
        return !(listOrganizadores.isEmpty() || listOrganizadores == null);
    }

    @Override
    public String toString() {
        return "\n ListaOrganizadores{" + "listaOrganizadores=" + listOrganizadores + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaOrganizadores = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element //iterate over keywords
            Element elementOrganizadores = document.createElement(ORG_LST_ELEMENT_NAME);
            elementListaOrganizadores.appendChild(elementOrganizadores);
            for (Organizador organizador : getLstOrganizadores()) {
                Node organizadorNode = organizador.exportContentToXMLNode();
                elementOrganizadores.appendChild(document.importNode(organizadorNode, true));
            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaOrganizadores);
            node = elementListaOrganizadores;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public ListaOrganizadores importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
