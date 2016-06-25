/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import java.io.Serializable;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.Exportable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Sara Silva
 */
public class Avaliacao implements Exportable, Serializable {

    private static final String ROOT_ELEMENT_NAME = "avaliacao";
    private static final String TXT_ELEMENT_NAME = "texto";
    private static final String CONH_ELEMENT_NAME = "conhecimento";
    private static final String ADEXP_ELEMENT_NAME = "adequacaoExposicao";
    private static final String ADDEM_ELEMENT_NAME = "adequacaoDemonstracao";
    private static final String ADCONV_ELEMENT_NAME = "adequacaoConvites";
    private static final String RECO_ELEMENT_NAME = "recomendacao";

    private String texto;
    private int[] array = new int[5]; //conhecimento, adequacaoExpo, adequDemo, adequConv, reco
    private Atribuicao atribuicao;

    public Avaliacao() {
        //To use with sets
    }

    public Avaliacao(String texto, int conhecimentoFAE, int adequacaoExpo, int adequacaoDemo, int adequacaoCon, int recomendacao, Atribuicao atribuicao) {
        this.texto = texto;
        this.array[0] = conhecimentoFAE;
        this.array[1] = adequacaoExpo;
        this.array[2] = adequacaoDemo;
        this.array[3] = adequacaoCon;
        this.array[4] = recomendacao;
        this.atribuicao = atribuicao;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Atribuicao getAtribuicao() {
        return this.atribuicao;
    }

    public int getRecomendacao() {
        return this.array[4];
    }

    public String getTexto() {
        return this.texto;
    }

    public boolean valida() {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (this.array[i] > 6 || this.array[i] < 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Arrays.hashCode(this.array);
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
        final Avaliacao other = (Avaliacao) obj;
        if (!Arrays.equals(this.array, other.array)) {
            return false;
        }
        return true;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Create document builder //Obtain a new document //Create root element
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element elementAvaliacao = document.createElement(ROOT_ELEMENT_NAME);

            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementTxt = document.createElement(TXT_ELEMENT_NAME);
            elementTxt.setTextContent(this.texto);
            elementAvaliacao.appendChild(elementTxt);
            
            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementConh = document.createElement(CONH_ELEMENT_NAME);
            elementConh.setTextContent(String.valueOf(this.array[0]));
            elementAvaliacao.appendChild(elementConh);
            
            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementAdExpo = document.createElement(ADEXP_ELEMENT_NAME);
            elementAdExpo.setTextContent(String.valueOf(this.array[1]));
            elementAvaliacao.appendChild(elementAdExpo);
            
            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementAdDemo = document.createElement(ADDEM_ELEMENT_NAME);
            elementAdDemo.setTextContent(String.valueOf(this.array[2]));
            elementAvaliacao.appendChild(elementAdDemo);
            
            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementAdConv = document.createElement(ADCONV_ELEMENT_NAME);
            elementAdConv.setTextContent(String.valueOf(this.array[3]));
            elementAvaliacao.appendChild(elementAdConv);
            
            //Create a sub-element //Set the sub-element value //Add sub-element to root element
            Element elementReco = document.createElement(RECO_ELEMENT_NAME);
            elementReco.setTextContent(String.valueOf(this.array[4]));
            elementAvaliacao.appendChild(elementReco);
            
            //Create a sub-element
            Node atribuicaoNode = this.atribuicao.exportContentToXMLNode();
            elementAvaliacao.appendChild(document.importNode(atribuicaoNode, true));

            //Add root element to document //It exports only the element representation to XMÇ, ommiting the XML header
            document.appendChild(elementAvaliacao);
            node = elementAvaliacao;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return node;
    }
}
