/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mecanismos.detecaoconflito;

import lapr.project.model.submissions.Candidatura;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.RegistoConflitos;
import lapr.project.model.mecanismos.MecanismoDetecaoConflito;
import lapr.project.model.users.FAE;

/**
 *
 * @author zero_
 */
public class MecanismoDetecaoConflito1 implements MecanismoDetecaoConflito {

    private ListaFAE listaFAE;
    private ListaCandidaturas listaCandidaturas;
    private RegistoConflitos registoConflitos;

    @Override
    public void detectConflitos(Exposicao exposicao) {
        this.listaFAE = exposicao.getListaFAE();
        this.listaCandidaturas = exposicao.getListaCandidaturas();
        this.registoConflitos = exposicao.getRegistoConflitos();

        for (FAE fae : listaFAE.getListaFAE()) {
            for (Candidatura candidatura : listaCandidaturas.getListaCandidaturas()) {
                if (isConflito(fae, candidatura)) {
                    this.registoConflitos.registarConflito(fae, candidatura);
                }
            }
        }
    }

    @Override
    public boolean isConflito(FAE fae, Candidatura candidatura) {
        return true;
    }

}
