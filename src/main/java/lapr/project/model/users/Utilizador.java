/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.states.EstadoUtilizador;
import lapr.project.model.states.utilizador.EstadoUtilizadorPending;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Sara Silva
 */
public class Utilizador implements Exportable, Importable<Utilizador> {

    private static final String ROOT_ELEMENT_NAME = "utilizador";
    private static final String NAME_ELEMENT_NAME = "nome";
    private static final String USERNAME_ELEMENT_NAME = "username";
    private static final String PASSWORD_ELEMENT_NAME = "password";
    private static final String EMAIL_ELEMENT_NAME = "email";
    private static final String USERTYPE_ELEMENT_NAME = "usertype";
    private static final String STATE_ELEMENT_NAME = "estado";

    private String nome;
    private String username;
    private String password;
    private String email;

    //TODO: Change string to respective state class
    private String tipoUtilizador;

    private EstadoUtilizador estadoUtilizador;

    public Utilizador(String nome, String username, String password, String email, String tipoUtilizador) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.email = email;

        this.tipoUtilizador = tipoUtilizador;

        this.estadoUtilizador = new EstadoUtilizadorPending(this);
    }

    public Utilizador() {
        this.nome = "";
        this.username = "";
        this.password = "";
        this.email = "";

        this.tipoUtilizador = "default";

        this.estadoUtilizador = new EstadoUtilizadorPending(this);
    }

    public boolean validateUsername(String username) {
        return this.username.equals(username);
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public boolean validateEmail(String email) {
        return this.email.equals(email);
    }

    public boolean isGestor() {
        return "GESTOR".equalsIgnoreCase(this.tipoUtilizador);
    }

    public boolean isFAE() {
        return "FAE".equalsIgnoreCase(this.tipoUtilizador);
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUtilizador() {
        return this.tipoUtilizador;
    }

    public void setEstado(EstadoUtilizador estadoUtilizador) {
        this.estadoUtilizador = estadoUtilizador;
    }

    public EstadoUtilizador getEstado() {
        return this.estadoUtilizador;
    }

    public String getEstadoString() {
        if (isPending()) {
            return "PENDING";
        }
        return "REGISTERED";
    }

    public boolean isPending() {
        return this.estadoUtilizador.isPending();
    }

    public boolean isRegistado() {
        return this.estadoUtilizador.isRegistado();
    }

    public boolean setRegistado() {
        return this.estadoUtilizador.setRegistado();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 72 * hash + Objects.hashCode(this.username);
        hash = 73 * hash + Objects.hashCode(this.password);
        hash = 74 * hash + Objects.hashCode(this.email);
        hash = 75 * hash + Objects.hashCode(this.tipoUtilizador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Utilizador other = (Utilizador) obj;
        if (Objects.equals(this.username, other.username)) {
            return true;
        }
        if (Objects.equals(this.email, other.email)) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "\nUtilizador{" + "nome=" + nome + ", username=" + username + ", password=" + password + ", email=" + email + ", tipoUtilizador=" + tipoUtilizador + ", estado=" + getEstadoString() + '}';
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementUtilizador = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementName = document.createElement(NAME_ELEMENT_NAME);
            elementName.setTextContent(getNome());
            elementUtilizador.appendChild(elementName);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementUserName = document.createElement(USERNAME_ELEMENT_NAME);
            elementUserName.setTextContent(getUsername());
            elementUtilizador.appendChild(elementUserName);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementPassword = document.createElement(PASSWORD_ELEMENT_NAME);
            elementPassword.setTextContent(getPassword());
            elementUtilizador.appendChild(elementPassword);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementEmail = document.createElement(EMAIL_ELEMENT_NAME);
            elementEmail.setTextContent(getEmail());
            elementUtilizador.appendChild(elementEmail);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementUserType = document.createElement(USERTYPE_ELEMENT_NAME);
            elementUserType.setTextContent(getTipoUtilizador());
            elementUtilizador.appendChild(elementUserType);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementState = document.createElement(STATE_ELEMENT_NAME);
            elementState.setTextContent(getEstadoString());
            elementUtilizador.appendChild(elementState);

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementUtilizador);
            node = elementUtilizador;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

    @Override
    public Utilizador importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            //Create document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Obtain a new document
            Document document = builder.newDocument();
            document.appendChild(document.importNode(node, true));

            NodeList nodeListUtilizador = document.getElementsByTagName(ROOT_ELEMENT_NAME);

            Node nodeUtilizador = nodeListUtilizador.item(0);

            //TODO: Get description
            this.nome = nodeUtilizador.getFirstChild().getFirstChild().getNodeValue();

//            //Get description
//            this.username = nodeUtilizador.getFirstChild().getFirstChild().getNodeValue();
//            
//            //Get description
//            this.password = nodeUtilizador.getFirstChild().getFirstChild().getNodeValue();
//            
//            //Get description
//            this.email = nodeUtilizador.getFirstChild().getFirstChild().getNodeValue();
//            
//            //Get description
//            this.tipoUtilizador = nodeUtilizador.getFirstChild().getFirstChild().getNodeValue();
//            
//            //Get description
//            this.estado = nodeUtilizador.getFirstChild().getFirstChild().getNodeValue();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return this;
    }

}
