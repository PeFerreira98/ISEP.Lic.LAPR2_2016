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
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Exportable;
import lapr.project.utils.FileOp;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class RegistoUtilizadores implements Exportable, Importable<RegistoUtilizadores> {

    private static final String ROOT_ELEMENT_NAME = "registoUtilizadores";
    private static final String REG_USERS_ELEMENT_NAME = "utilizadoresRegistados";
    private static final String UNREG_USERS_ELEMENT_NAME = "utilizadoresNaoRegistados";

    private List<Utilizador> listaUtilizadoresRegistados;
    private List<Utilizador> listaUtilizadoresNaoRegistados;

    public RegistoUtilizadores() {
        this.listaUtilizadoresRegistados = new ArrayList<Utilizador>();
        this.listaUtilizadoresNaoRegistados = new ArrayList<Utilizador>();
    }

    public Utilizador checkUtilizadorByUsername(String username) {
        for (Utilizador u : listaUtilizadoresNaoRegistados) {
            if (u.validateUsername(username)) {
                return u;
            }
        }
        for (Utilizador u : listaUtilizadoresRegistados) {
            if (u.validateUsername(username)) {
                return u;
            }
        }
        return null;
    }

    public Utilizador checkUtilizadorByEmail(String email) {
        for (Utilizador u : listaUtilizadoresNaoRegistados) {
            if (u.validateEmail(email)) {
                return u;
            }
        }
        for (Utilizador u : listaUtilizadoresRegistados) {
            if (u.validateEmail(email)) {
                return u;
            }
        }
        return null;
    }

    public boolean addUtilizadorNaoRegistado(Utilizador utilizador) {
        for (Utilizador u : listaUtilizadoresRegistados) {
            if (u.equals(utilizador)) {
                return false;
            }
        }
        for (Utilizador u : listaUtilizadoresNaoRegistados) {
            if (u.equals(utilizador)) {
                return false;
            }
        }
        new FileOp().writeFile(utilizador);
        return listaUtilizadoresNaoRegistados.add(utilizador);
    }

    public boolean addUtilizadorNaoRegistadoByFicheiro(Utilizador utilizador) {
        for (Utilizador u : listaUtilizadoresRegistados) {
            if (u.equals(utilizador)) {
                return false;
            }
        }
        for (Utilizador u : listaUtilizadoresNaoRegistados) {
            if (u.equals(utilizador)) {
                return false;
            }
        }
        return listaUtilizadoresNaoRegistados.add(utilizador);
    }

    public boolean registarUtilizador(Utilizador utilizador) {
        for (Utilizador u : listaUtilizadoresNaoRegistados) {
            if (u.equals(utilizador)) {
                return registo(utilizador);
            }
        }
        return false;
    }

    private boolean registo(Utilizador utilizador) {
        if (listaUtilizadoresNaoRegistados.remove(utilizador)) {
            utilizador.setRegistado();
            return listaUtilizadoresRegistados.add(utilizador);
        }
        return false;
    }

    public List<Utilizador> getListaUtilizadoresNaoRegistados() {
        return this.listaUtilizadoresNaoRegistados;
    }

    public List<Utilizador> getListaUtilizadoresRegistados() {
        return this.listaUtilizadoresRegistados;
    }

    @Override
    public String toString() {
        return "\n RegistoUtilizadores{" + "listaUtilizadoresRegistados=" + listaUtilizadoresRegistados + ", \n\tlistaUtilizadoresNaoRegistados=" + listaUtilizadoresNaoRegistados + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementRegistoUtilizadores = document.createElement(ROOT_ELEMENT_NAME);

            
            //Create a sub-element //iterate over keywords
            Element elementRegUsers = document.createElement(REG_USERS_ELEMENT_NAME);
            elementRegistoUtilizadores.appendChild(elementRegUsers);
            for (Utilizador utilizador : getListaUtilizadoresRegistados()) {
                Node utilizadorNode = utilizador.exportContentToXMLNode();
                elementRegUsers.appendChild(document.importNode(utilizadorNode, true));
            }

            //Create a sub-element //iterate over keywords
            Element elementUnRegUsers = document.createElement(UNREG_USERS_ELEMENT_NAME);
            elementRegistoUtilizadores.appendChild(elementUnRegUsers);
            for (Utilizador utilizador : getListaUtilizadoresNaoRegistados()) {
                Node utilizadorNode = utilizador.exportContentToXMLNode();
                elementUnRegUsers.appendChild(document.importNode(utilizadorNode, true));
            }

            
            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementRegistoUtilizadores);
            node = elementRegistoUtilizadores;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public RegistoUtilizadores importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
