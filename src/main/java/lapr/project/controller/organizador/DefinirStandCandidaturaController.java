/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.organizador;

import java.io.Serializable;
import java.util.List;
import lapr.project.model.Stand;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.submissions.Candidatura;

/**
 *
 * @author Marcos
 */
public class DefinirStandCandidaturaController implements Serializable {

    private final Candidatura candidatura;
    private final CentroExposicoes centroExpo;

    public DefinirStandCandidaturaController(CentroExposicoes cExpo, Candidatura c) {
        this.centroExpo = cExpo;
        this.candidatura = c;
    }

    public List<Stand> getStands() {
        return this.centroExpo.getListaStands();
    }

    public void atribuirStand(Stand s) {
        this.candidatura.setStand(s);
    }

}
