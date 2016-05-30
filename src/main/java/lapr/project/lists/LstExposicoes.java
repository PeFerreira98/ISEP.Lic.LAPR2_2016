/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Exposicao;

/**
 *
 * @author Marcos
 */
public class LstExposicoes {
    private List<Exposicao> lstExposicoes;
    
    public LstExposicoes(){
        lstExposicoes = new ArrayList<>();
    }
    
    public void addExpo(Exposicao expo){
        lstExposicoes.add(expo);
    }
    
    public List<Exposicao> getLstExpo(){
        return this.lstExposicoes;
    }
}
