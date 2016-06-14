/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.model.mecanismos.MecanismoDetecao;

/**
 *
 * @author Sara Silva
 */
public class TipoConflito {

    private String descricao;
    private MecanismoDetecao mecanismoDetecao;

    public TipoConflito(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
