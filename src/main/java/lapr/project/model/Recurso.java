/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author Sara Silva
 */
public class Recurso {

    private String descricao;

    public Recurso(String desc) {
        descricao = desc;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj.getClass() == this.getClass()){
            Recurso that =(Recurso) obj;
            return this.descricao.equals(that.descricao);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

}
