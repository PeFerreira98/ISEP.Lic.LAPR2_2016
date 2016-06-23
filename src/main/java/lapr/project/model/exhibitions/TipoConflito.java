/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.io.Serializable;
import lapr.project.model.mecanismos.MecanismoDetecaoConflito;

/**
 *
 * @author Sara Silva
 */
public class TipoConflito implements Serializable {

    private String descricao;
    private MecanismoDetecaoConflito mecanismoDetecaoConflito;

    public TipoConflito(String descricao) {
        this.descricao = descricao;
    }

    public TipoConflito(String descricao, MecanismoDetecaoConflito mecanismoDetecaoConflito) {
        this.descricao = descricao;
        this.mecanismoDetecaoConflito = mecanismoDetecaoConflito;
    }

    public TipoConflito() {
        ///For Import use only
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public MecanismoDetecaoConflito getMecanismoDetecaoConflito() {
        return this.mecanismoDetecaoConflito;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TipoConflito) {
            TipoConflito tc = (TipoConflito) obj;
            return this.descricao.equals(tc.descricao);
        }
        return false;
    }
}
