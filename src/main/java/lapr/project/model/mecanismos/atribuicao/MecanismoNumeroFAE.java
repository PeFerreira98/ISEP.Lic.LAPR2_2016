/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mecanismos.atribuicao;

import java.util.List;
import lapr.project.model.Atribuicao;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.mecanismos.MecanismoAtribuicao;

/**
 *
 * @author Sara Silva
 */
public class MecanismoNumeroFAE implements MecanismoAtribuicao {

    private String descricao;

    public MecanismoNumeroFAE() {
        descricao = "Numero FAE";
    }

    @Override
    public List<Atribuicao> getListaAtribuicoes(Exposicao exposicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
