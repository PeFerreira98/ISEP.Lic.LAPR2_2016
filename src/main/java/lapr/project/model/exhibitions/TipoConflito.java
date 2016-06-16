/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import lapr.project.model.mecanismos.MecanismoDetecaoConflito;

/**
 *
 * @author Sara Silva
 */
public class TipoConflito {

    private String descricao;
    private MecanismoDetecaoConflito mecanismoDetecaoConflito;

    public TipoConflito(String descricao) {
        this.descricao = descricao;
    }
    
    public TipoConflito(String descricao, MecanismoDetecaoConflito mecanismoDetecaoConflito) {
        this.descricao = descricao;
        this.mecanismoDetecaoConflito = mecanismoDetecaoConflito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public MecanismoDetecaoConflito getMecanismoDetecaoConflito(){
        return this.mecanismoDetecaoConflito;
    }

}