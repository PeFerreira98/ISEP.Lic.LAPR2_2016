/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sara Silva
 */
public class Demonstracao {

    private String codigo;
    private String descricao;
    private List<Recurso> recursos;

    public Demonstracao() {
        recursos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public void addRecursos(Recurso recurso) {
        this.recursos.add(recurso);
    }
}


