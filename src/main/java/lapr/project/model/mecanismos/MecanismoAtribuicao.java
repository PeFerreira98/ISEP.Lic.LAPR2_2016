/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mecanismos;

import java.io.Serializable;
import java.util.List;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.exhibitions.Exposicao;

/**
 *
 * @author Sara Silva
 */
public interface MecanismoAtribuicao extends Serializable {

    public List<Atribuicao> getListaAtribuicoes(Exposicao exposicao);

    public String getDescricao();

}
