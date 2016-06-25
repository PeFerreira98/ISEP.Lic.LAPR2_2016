/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.submissions.Produto;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author zero_
 */
public class ListaProdutos implements Exportable, Serializable{

    private static final String ROOT_ELEMENT_NAME = "listaProdutos";
    private static final String RECUR_ELEMENT_NAME = "produtos";
    
    private List<Produto> listProdutos;

    public ListaProdutos() {
        listProdutos = new ArrayList<>();
    }

    public boolean addProduto(Produto produto) {
        for (Produto p : this.listProdutos) {
            if (p.equals(produto)) {
                return false;
            }
            return false;
        }
        return this.listProdutos.add(produto);
    }

    public List<Produto> getListaProdutos() {
        return this.listProdutos;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementListaProd = document.createElement(ROOT_ELEMENT_NAME);

            //TODO: Create a sub-element //iterate over keywords
            Element elementProduto = document.createElement(RECUR_ELEMENT_NAME);
            elementListaProd.appendChild(elementProduto);
            for (Produto produto : getListaProdutos()) {
                Node elementProdutoNode = produto.exportContentToXMLNode();
                elementProduto.appendChild(document.importNode(elementProdutoNode, true));
            }

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementListaProd);
            node = elementListaProd;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }

}
