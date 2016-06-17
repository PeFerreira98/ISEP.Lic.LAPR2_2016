/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.gestor;

import java.util.List;
import lapr.project.model.Stand;
import lapr.project.model.exhibitions.CentroExposicoes;

/**
 *
 * @author Sara Silva
 */
public class DefinirStandCentroController {

    private final List<Stand> listaStands;

    public DefinirStandCentroController(CentroExposicoes centroExp) {
        listaStands = centroExp.getListaStands();
    }

    public void addStand(String stand) {
        listaStands.add(new Stand(stand));

    }

    public List<Stand> getListaStands() {
        return listaStands;
    }

}
