/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import lapr.project.model.users.FAE;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import lapr.project.utils.Data;


/**
 *
 * @author TiagoSilvestre
 */
public class Exposicao {

//    private RegistoCandidatura lstCandidatura;
//    private ListaFAE lstFae;
    private String title;
    private String description;
    private Data dataInicio;
    private Data dataFim;
    private List<FAE> lstFae;

    /**
     * Construtor de Exposicao
     *
     * @param listaCandidatura o registo de candidaturas
     * @param listaFaes a lista de faes
     * @param nomeExposicao o nome da exposicao
     * @param descricaoExposicao a descricao da exposicao
     * @param dataInicio a data de inicio da exposicao
     * @param dataFim a data de fim da exposicao
     */
    public Exposicao(String nomeExposicao, String descricaoExposicao, Data dataInicio, Data dataFim, List<FAE> responsaveis) {
        this.title = nomeExposicao;
        this.description = descricaoExposicao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.lstFae = responsaveis;
    }

    public Exposicao(){
        this.title = "";
        this.description = "";
        this.dataFim = null;
        this.dataInicio = null;
        this.lstFae = new ArrayList<>();
    } 

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the dataInicio
     */
    public Data getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public Data getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the lstFae
     */
    public List<FAE> getLstFae() {
        return lstFae;
    }

    /**
     * @param lstFae the lstFae to set
     */
    public void setLstFae(List<FAE> lstFae) {
        this.lstFae = lstFae;
    }
    
    

}
