/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

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
 * @author zero_
 */
public class Demonstracao implements Exportable, Importable<Demonstracao> {

    //Classe incompleta. Não especificação sobre o que a Demonstracao se trata
    private static final String ROOT_ELEMENT_NAME = "demonstracao";
    private static final String DES_ELEMENT_NAME = "designacao";
    
    //TODO: depois de adicionar a classe ListaRecursos, retirar os comentarios
    
    private String designacao;
    private String cod;
//    private ListaRecursos listaRecursos;

    public Demonstracao(){
        this.cod = "";
        this.designacao = "";
//        this.listaRecursos = new ListaRecursos();
    }
    
    public Demonstracao(String cod, String designacao/*, ListaRecursos lst*/) {
        this.cod = cod;
        this.designacao = designacao;
//        this.listaRecursos = lst;
    }

    public static boolean validateDesignacao(String designacao) {
        return !(designacao == null || designacao.isEmpty());
    }

//    public void addListaRecursos(ListaRecursos lst){
//        this.listaRecursos = lst;
//    }
    
    public String getDesignacao() {
        return designacao;
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
        return "\nDemonstracao{" + "designacao=" + designacao + '}';
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

    @Override
    public Demonstracao importContentFromXMLNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
