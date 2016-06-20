/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.gestor;

import java.io.Serializable;
import java.util.List;
import lapr.project.model.Stand;
import lapr.project.model.exhibitions.CentroExposicoes;

/**
 *
 * @author Sara Silva
 */
public class DefinirStandCentroController implements Serializable {

    private final List<Stand> listaStands;

    public DefinirStandCentroController(CentroExposicoes centroExp) {
        listaStands = centroExp.getListaStands();
    }

    public boolean addStandByObject(Stand stand) {
        return listaStands.add(stand);
    }

    public void addStand(String stand) {
        listaStands.add(new Stand(stand));

    }

    public List<Stand> getListaStands() {
        return listaStands;
    }

}
