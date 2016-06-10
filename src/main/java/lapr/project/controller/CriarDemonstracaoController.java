/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaRecursos;

/**
 *
 * @author Marcos
 */
public class CriarDemonstracaoController {
    
    private Demonstracao demo;
    private Exposicao expo;
    
    public CriarDemonstracaoController(Exposicao expo){
        this.expo = expo;
    }
    
    public void criarDemo (String cod, String desc, ListaRecursos r){
        this.demo = new Demonstracao(desc, cod, r);
        addDemoToExpo(demo);
    } 
    
    private void addDemoToExpo(Demonstracao demo){
        this.expo.getListaDemonstracoes().addDemonstracao(demo);
    }
}
