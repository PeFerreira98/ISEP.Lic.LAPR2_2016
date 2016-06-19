/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.fae;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Conflito;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.exhibitions.TipoConflito;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaTipoConflito;
import lapr.project.model.lists.RegistoConflitos;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;

/**
 *
 * @author zero_
 */
public class ActualizarConflitosController {
    
    private FAE fae;
    private Candidatura candidatura;
    
    private List<Exposicao> listaExposicoes;
    private List<Demonstracao> listaDemonstracoes;
    private ListaTipoConflito listaTipoConflito;
    
    private ListaCandidaturas listaCandidaturas;
    private RegistoConflitos registoConflitos;
    
    private List<Conflito> listaConflito;
    
    public ActualizarConflitosController(CentroExposicoes centroExposicoes, FAE fae){
        this.listaExposicoes = centroExposicoes.getListaExposicoes().getListaExposicoesComConflitos();
        this.listaDemonstracoes = new ArrayList<>();
        for (Exposicao expo : centroExposicoes.getListaExposicoes().getListaExposicoes()) {
            this.listaDemonstracoes.addAll(expo.getListaDemonstracoes().getListaDemonstracoesComConflitos());
        }
        this.listaTipoConflito = centroExposicoes.getListaTipoConflito();
        this.fae = fae;
    }
    
    public List<Exposicao> getListaExposicoes(){
        return this.listaExposicoes;
    }
    
    public List<Demonstracao> getListaDemonstracoes(){
        return this.listaDemonstracoes;
    }
    
    public void selectExposicao(Exposicao exposicao){
        this.registoConflitos = exposicao.getRegistoConflitos();
        this.listaCandidaturas = exposicao.getListaCandidaturas();
    }
    
    public void selectDemonstracao(Demonstracao demonstracao){
        this.registoConflitos = demonstracao.getRegistoConflitos();
        this.listaCandidaturas = demonstracao.getListaCandidaturas();
    }
    
    public List<Candidatura> getListaCandidaturas(){
        return this.listaCandidaturas.getListaCandidaturas();
    }
    
    public void selectCandidatura(Candidatura candidatura){
        this.candidatura = candidatura;
        this.listaConflito = this.registoConflitos.getConflitos(candidatura);
    }
    
    public String getFAELabel(){
        return this.fae.getUtilizador().getUsername();
    }
    
    public String getCandidaturaLabel(){
        return this.candidatura.getNomeEmpresa();
    }
    
    public List<Conflito> getListaConflitos(){
        return this.listaConflito;
    }
    
    public List<TipoConflito> getListaTiposConflito(){
        return this.listaTipoConflito.getListaTipoConflito();
    }
    
    public boolean eliminarConflito(Conflito conflito){
        return this.registoConflitos.deleteConflito(conflito);
    }
    
    public boolean adicionaConflito(TipoConflito tipoConflito){
        return this.registoConflitos.registarConflito(this.fae, this.candidatura, tipoConflito);
    }
            
}
