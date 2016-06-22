package lapr.project.utils;

import lapr.project.model.exhibitions.CentroExposicoes;
import org.w3c.dom.Node;

/**
 * All domains classes should include this interface. Created by Nuno
 * Bettencourt [NMB] on 29/05/16.
 */
@FunctionalInterface
public interface Importable<T extends Exportable> {
    
    default CentroExposicoes importContentFromFile(String filename) throws Exception{
        CentroExposicoes centroExposicoes = new CentroExposicoes();
        
        Node node;
        
        XMLParser xmlParser = new XMLParser();
        
        try{
            node = xmlParser.readXMLElementFromFile(filename);
            centroExposicoes = centroExposicoes.importContentFromXMLNode(node);
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return centroExposicoes;
    }

    /**
     * Imports the object content from an XML format.
     *
     * @return Structured String containing content.
     */
    T importContentFromXMLNode(Node node);
}
