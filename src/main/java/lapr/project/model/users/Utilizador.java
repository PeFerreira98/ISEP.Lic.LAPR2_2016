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
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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
    private String estado;

    public Utilizador(String nome, String username, String password, String email, String tipoUtilizador) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.email = email;

        this.estado = "PENDING";
        this.tipoUtilizador = tipoUtilizador;
    }

    public Utilizador() {
        this.nome = "";
        this.username = "";
        this.password = "";
        this.email = "";

        this.estado = "PENDING";
        this.tipoUtilizador = "default";
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

    public boolean isRegistado() {
        return this.estado.equalsIgnoreCase("REGISTERED");
    }

    public boolean isGestor() {
        return this.tipoUtilizador.equalsIgnoreCase("GESTOR");
    }

    public boolean isFAE() {
        return this.tipoUtilizador.equalsIgnoreCase("FAE");
    }

    public void setRegistado() {
        this.estado = "REGISTERED";
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

    public String getEstado() {
        return this.estado;
    }

    public String getTipoUtilizador() {
        return this.tipoUtilizador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 72 * hash + Objects.hashCode(this.username);
        hash = 73 * hash + Objects.hashCode(this.password);
        hash = 74 * hash + Objects.hashCode(this.email);
        hash = 75 * hash + Objects.hashCode(this.tipoUtilizador);
        hash = 76 * hash + Objects.hashCode(this.estado);
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
        return "\nUtilizador{" + "nome=" + nome + ", username=" + username + ", password=" + password + ", email=" + email + ", tipoUtilizador=" + tipoUtilizador + ", estado=" + estado + '}';
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
            elementState.setTextContent(getEstado());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
