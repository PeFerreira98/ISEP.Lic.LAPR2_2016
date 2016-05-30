/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import lapr.project.lists.LstExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.utils.Data;

/**
 *
 * @author TiagoSilvestre
 */
public class RegistarExposicaoController {
    
    Exposicao expo;
    LstExposicoes lst;

    public RegistarExposicaoController(String titulo, String desc, Data dataInicio, Data dataFim, List<FAE> responsaveis){
        Exposicao expoAux = new Exposicao(titulo, desc, dataInicio, dataFim, responsaveis);
        
        if(valida(expoAux)){
            this.expo = expoAux;
            lst.getLstExpo().add(expo);
        }
    }
    
  
    public boolean valida(Exposicao expo){
        
        if(expo.getTitle()=="" || expo.getDescription()==""){
            throw new IllegalArgumentException("Parametros invalidos");
        }
        
        return true;
    }
}
