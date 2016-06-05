/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Demonstracao(String demo) {
        this.codigo= demo;
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
    
    public static boolean validateDesignacao(String designacao){
        return !(designacao == null || designacao.isEmpty());
    }

    public String getDesignacao() {
        return descricao;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Demonstracao other = (Demonstracao) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nDemonstracao{" + "designacao=" + descricao + '}';
    }
    
}
