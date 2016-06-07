/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mecanismos;

import java.util.List;
import lapr.project.model.Atribuicao;
import lapr.project.model.exhibitions.Exposicao;

/**
 *
 * @author Sara Silva
 */
public class MecanismoCargaFAE implements MecanismoAtribuicao {

    private String descricao;

    public MecanismoCargaFAE() {
        descricao = "Carga FAE";
    }

    @Override
    public List<Atribuicao> gerarAtribuicoes(Exposicao exposicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
