/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.MecanismoAtribuicao;
import lapr.project.model.MecanismoCargaFAE;
import lapr.project.model.MecanismoExpProfissional;
import lapr.project.model.MecanismoNumeroFAE;
import lapr.project.model.Recurso;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.RegistoUtilizadores;

/**
 *
 * @author Sara Silva
 */
public class CentroExposicoes implements Serializable {

    private final List<MecanismoAtribuicao> listaMecanismos;
    private final List<Recurso> listaRecursos;
    private final ListaExposicoes registoExp;
    private final RegistoUtilizadores registoUt;

    public CentroExposicoes() {

        listaMecanismos = new ArrayList<>();
        listaRecursos = new ArrayList<>();
        registoExp = new ListaExposicoes();
        registoUt = new RegistoUtilizadores();
        listaMecanismos.add(new MecanismoCargaFAE());
        listaMecanismos.add(new MecanismoExpProfissional());
        listaMecanismos.add(new MecanismoNumeroFAE());
    }
    

    public RegistoUtilizadores getRegistoUt() {
        return registoUt;
    }

    public ListaExposicoes getListaExp() {
        return getRegistoExp();
    }

    public List<Recurso> getListaRecursos() {
        return listaRecursos;
    }

    public List<MecanismoAtribuicao> getListaMecanismos() {
        return listaMecanismos;
    }

    public Recurso getRecurso(String recursosSeparado) {
        for (Recurso r : listaRecursos) {
            if (r.getDescricao().equals(recursosSeparado)) {
                return r;
            }
        }
        return null;
    }

    public void addRecurso(String recurso) {
        Recurso r = new Recurso(recurso);
        listaRecursos.add(r);
    }

    /**
     * @return the registoExp
     */
    public ListaExposicoes getRegistoExp() {
        return registoExp;
    }
}
