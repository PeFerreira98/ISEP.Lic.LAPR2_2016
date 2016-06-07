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
public interface MecanismoAtribuicao {

    public List<Atribuicao> gerarAtribuicoes(Exposicao exposicao);

    public String getDescricao();
}
