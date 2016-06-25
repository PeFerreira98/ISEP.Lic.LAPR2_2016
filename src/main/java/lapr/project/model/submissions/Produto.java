/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class Produto implements Exportable, Serializable{

    private static final String ROOT_ELEMENT_NAME = "produto";
    private static final String DESIG_ELEMENT_NAME = "desigancao";
    
    //Classe incompleta. Não especificação sobre o que o produto se trata
    private String designacao;
    
    public Produto(String designacao) {
        this.designacao = designacao;
    }
    
    public static boolean validaDesignacao(String designacao){
        return !(designacao == null || designacao.isEmpty());
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.designacao);
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
        
        final Produto other = (Produto) obj;
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
       Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementProduto = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementDesig = document.createElement(DESIG_ELEMENT_NAME);
            elementDesig.setTextContent(this.designacao);
            elementProduto.appendChild(elementDesig);

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementProduto);
            node = elementProduto;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }
    
}
